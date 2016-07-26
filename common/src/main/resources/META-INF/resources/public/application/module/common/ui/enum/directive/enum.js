export default function(){
  return {
    restrict: 'E',
    templateUrl: '/public/application/template/common/ui/enum/enum.html',
    scope: {
      model: '=',
      store: '='
    },
    controller: function($scope){

      $scope.isIn = function(record){
        return Array.isArray($scope.model) ? $scope.model.map(function(e){
          return e.id;
        }).indexOf(record.id) != -1: false;
      };

      $scope.click = function(record){
        var index;

        if(!Array.isArray($scope.model)){
          $scope.model = [];
        } else if ($scope.model === $scope.store){
          $scope.model = $scope.store.map(function(e){ return e });
        }

        index = $scope.model.map(function(e){ return e.id }).indexOf(record.id);

        if(index == -1){
          $scope.model.push(record);
        }else{
          $scope.model.splice(index, 1);
        }
      };
    }
  }
}