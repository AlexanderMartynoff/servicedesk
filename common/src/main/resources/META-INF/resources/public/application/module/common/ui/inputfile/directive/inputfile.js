export default () => {
  return {
    templateUrl: '/public/application/module/common/ui/inputfile/template/inputfile.html',
    scope: {
      files: '=?',
      onReadBegin: '@',
      onReadComplete: '@'
    },
    controller: ($scope, $parse, $q) => {
      var onBeginReadFn, onCompleteReadFn;

      $scope.files = $scope.files || [];

      $scope.makeFileName = fileName => {
        var firstSize = 3, lastSize = 3, delim = '\u2026';

        if(fileName.length > firstSize + lastSize){
          fileName = fileName.substring(0, firstSize) + delim +
            fileName.substring(fileName.length - lastSize, fileName.length)
        }

        return fileName;
      };

      onBeginReadFn = selection => {
        return $parse($scope.onReadBegin)($scope.$parent, {
          $selection: selection
        })
      };

      onCompleteReadFn = selection => {
        return $parse($scope.onReadComplete)($scope.$parent, {
          $selection: selection
        })
      };

      $scope.change = input => {
        var promise, promises = [], files = [], i;

        onBeginReadFn(input.files);

        for(i = 0; i < input.files.length; i++) {
          files.push(input.files[i]);
        }

        files.forEach(file => {
          var reader = new FileReader();
          promise = $q((resolve, reject) => {
            reader.onload = e => {

              resolve({
                title: file.name,
                content: e.currentTarget.result
              });

            };
            reader.onerror = e => reject(e);
          });
          reader.readAsDataURL(file);
          promises.push(promise);
        });

        $q.all(promises).then(collection => {
          $scope.files = $scope.files.concat(collection);
          onCompleteReadFn(collection);
        }, () => {
          onCompleteReadFn([]);
        });
      };

      $scope.delete = file => {
        $scope.files = $scope.files.filter(e => e !== file);
      };
    }
  }
}