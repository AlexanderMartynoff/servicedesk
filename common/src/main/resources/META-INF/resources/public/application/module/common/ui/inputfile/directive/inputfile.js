export default function () {
  return {
    templateUrl: '/public/application/module/common/ui/inputfile/template/inputfile.html',
    scope: {
      files: '=?',
      onReadBegin: '@',
      onReadComplete: '@'
    },
    controller: function ($scope, $parse, $q) {
      var onBeginReadFn, onCompleteReadFn;

      $scope.files = $scope.files || [];

      $scope.makeFileName = function(fileName){
        var firstSize = 3, lastSize = 3, delim = '\u2026';

        if(fileName.length > firstSize + lastSize){
          fileName = fileName.substring(0, firstSize) + delim +
            fileName.substring(fileName.length - lastSize, fileName.length)
        }

        return fileName;
      };

      onBeginReadFn = function(selection){
        return $parse($scope.onReadBegin)($scope.$parent, {
          $selection: selection
        })
      };

      onCompleteReadFn = function(selection){
        return $parse($scope.onReadComplete)($scope.$parent, {
          $selection: selection
        })
      };

      $scope.change = function(input){
        var promise, promises = [], files = [], i;

        onBeginReadFn(input.files);

        for(i = 0; i < input.files.length; i++) {
          files.push(input.files[i]);
        }

        files.forEach(function(file){
          var reader = new FileReader();
          promise = $q(function(resolve, reject){
            reader.onload = function(e){

              resolve({
                title: file.name,
                content: e.currentTarget.result
              });
            };
            reader.onerror = function(e){
              reject(e);
            };
          });
          reader.readAsDataURL(file);
          promises.push(promise);
        });

        $q.all(promises).then(function(collection){
          $scope.files = $scope.files.concat(collection);
          onCompleteReadFn(collection);
        }, function(){
          onCompleteReadFn([]);
        });
      };

      $scope.delete = function(file){
        $scope.files = $scope.files.filter(function(e){return e !== file});
      };
    }
  }
}