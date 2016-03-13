angular.module("common.dictionary.data")
  .factory("uaPerformerService", function ($http, uaSpecStore) {
    return {

      listAsUaGlobal: function(){
        return $http.get('/ua/global', {}).then(function(response){
          return response.data.map(function(complex){
            return complex.uaGlobal;
          });
        });
      }
    }
  });