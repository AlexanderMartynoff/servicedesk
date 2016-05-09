angular.module("common.dictionary.data")
  .factory("agentPerformerService", function ($http) {
    return {
      listAccount: function(){
        return $http.get('/ua', {}).then(function(response){
          return response.data.map(function(complex){
            return complex.account;
          });
        });
      }
    }
  });