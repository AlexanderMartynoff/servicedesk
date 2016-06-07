angular.module('common.ui.ticket-comments')
  .directive('ticketComments', function(){
    return {
      restrict: 'E',
      templateUrl: '/public/application/module/common/dictionary/ui/ticket-comment/template/comment.html',
      scope: {
        ticket: '='
      },
      controller: function($scope, ticketCommentService, converter, logged$user){
        $scope.commentsCovered = false;
        $scope.l$u = logged$user.data;

        function resetComment(){
          $scope.comment = {ticket: converter.out($scope.ticket)};
        }

        function updateCommentsStore(){
          if(!$scope.ticket.id){
            return;
          }
          $scope.commentsCovered = true;
          ticketCommentService.list({ticketId: $scope.ticket.id}).then(function(response){
            $scope.commentStore = response;
            resetComment();
            $scope.commentsCovered = false;
          });
        }

        $scope.focus = function(){
          $scope.rows = 3;
        };

        $scope.blur = function(){
          $scope.rows = 1;
        };

        $scope.send = function(comment){
          $scope.commentsCovered = true;
          return ticketCommentService.create(comment).then(function(){
            updateCommentsStore();
            $scope.commentsCovered = false;
          });
        };

        $scope.blur();
        resetComment();
        updateCommentsStore();
      }
    }
  });