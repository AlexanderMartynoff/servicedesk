export default function($scope, $rootScope){
  $scope.indexViewCovered = false;

  $rootScope.$on('$stateChangeStart', function(){
    $scope.indexViewCovered = true;
  });

  $rootScope.$on('$stateChangeSuccess', function(){
    $scope.indexViewCovered = false;
  });
}