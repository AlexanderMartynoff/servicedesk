angular.module('common.ui.xinputfile', [])
  .directive('xinputfile', function () {
    return {
      templateUrl: '/public/application/module/common/ui/xinputfile/template/xinputfile.html',

      controller: function ($scope, $element, $attrs, $transclude, $uibModal, xInputFileList) {

        $scope.files = [
          {
            name: 'Документация.doc',
            url: '/file/Документация.doc',
            mime: 'text/plain'
          },
          {
            name: 'Spec.doc',
            url: '/file/Скриншот.png',
            mime: 'text/plain'
          }
        ];

        $scope.openXInputFileList = function(){
          xInputFileList.open($scope.files);
        }
      }
    }
  });