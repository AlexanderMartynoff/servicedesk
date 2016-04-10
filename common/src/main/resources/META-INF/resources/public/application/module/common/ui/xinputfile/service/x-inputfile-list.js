angular.module("common.ui.xinputfile")
  .factory("xInputFileList", function ($uibModal) {
    return {
      open: function (files) {
        $uibModal.open({
          controller: 'XInputFileListController',
          resolve: {
            files: function(){ return files }
          },
          size: "lg",
          templateUrl: '/public/application/module/common/ui/xinputfile/template/xinputfile-modal-list.html'
        });
      }
    }
  });