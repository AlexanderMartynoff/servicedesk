angular.module('common.ui.ticket-comments')
  .directive('ticketComments', function () {
    return {
      restrict: 'E',
      templateUrl: '/public/application/module/common/dictionary/ui/ticket-comment/template/comment.html',
      scope: {
        ticket: '='
      },
      controller: function ($scope, ticketCommentService, converter, logged, $interval) {
        var interval;
        $scope.commentsCovered = false;
        $scope.l$u = logged.logged;

        function resetComment() {
          $scope.comment = {ticket: converter.out($scope.ticket)};
        }

        function updateCommentsStore(silent) {
          if (!$scope.ticket.id) {
            return;
          }
          if (!silent) $scope.commentsCovered = true;
          ticketCommentService.list({ticketId: $scope.ticket.id}).then(function (response) {
            $scope.commentStore = response;
            if (!silent) {
              resetComment();
              $scope.commentsCovered = false;
            }
          });
        }

        $scope.focus = function () {
          $scope.rows = 3;
        };

        $scope.blur = function () {
          $scope.rows = 1;
        };

        $scope.send = function (comment) {
          stopMonitoring();
          $scope.commentsCovered = true;
          return ticketCommentService.create(comment).then(function () {
            updateCommentsStore();
            $scope.commentsCovered = false;
            startMonitoring();
          });
        };

        $scope.blur();
        resetComment();
        updateCommentsStore();

        function startMonitoring(){
          interval = $interval(function () {
            updateCommentsStore(true);
          }, 2000);
        }

        function stopMonitoring(){
          $interval.cancel(interval);
        }

        if ($scope.ticket.id) {
          startMonitoring();
          $scope.$on("$destroy", function () {
            stopMonitoring();
          });
        }
      }
    }
  });