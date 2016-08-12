export default () => {
  return {
    restrict: 'E',
    templateUrl: '/public/application/module/common/dictionary/ui/ticket-comment/template/comment.html',
    scope: {
      ticket: '='
    },
    controller: ($scope, ticketCommentService, $interval, $attrs, converter, logged) => {
      $scope.covered = false;
      $scope.logged = logged.logged;

      var interval = null;

      var resetComment = () => {
        $scope.comment = {
          ticket: converter.out($scope.ticket)
        };
      };

      var updateCommentsStore = silent => {
        if (!$scope.ticket.id) {
          return;
        }

        if (!silent) $scope.covered = true;
        ticketCommentService.list({ticketId: $scope.ticket.id})
          .then(response => {
            $scope.commentStore = response;
            if (!silent) {
              resetComment();
              $scope.covered = false;
            }
          });
      };

      var startMonitoring = () => {
        interval = $interval(() => {
          updateCommentsStore(true);
        }, 2000);
      };

      var stopMonitoring = () => $interval.cancel(interval);

      $scope.openEdit = comment => {
        if(comment.author.id !== $scope.logged.account.id){
          return
        }
        stopMonitoring();
        $scope.editComment = comment;
      };

      // save edited comment
      $scope.closeEdit = () => {
        $scope.covered = true;
        ticketCommentService.update($scope.editComment)
          .then(() => {
            startMonitoring();
            $scope.covered = false;
            $scope.editComment = null;
          });
      };

      $scope.focus = () => $scope.rows = 3;
      $scope.blur = () => $scope.rows = 1;

      $scope.send = comment => {
        stopMonitoring();
        $scope.covered = true;
        return ticketCommentService.create(comment).then(() => {
          updateCommentsStore();
          $scope.covered = false;
          startMonitoring();
        });
      };

      $scope.blur();
      resetComment();
      updateCommentsStore();

      if ($scope.ticket.id) {
        startMonitoring();
        $scope.$on("$destroy", stopMonitoring);
      }
    }
  }
}
