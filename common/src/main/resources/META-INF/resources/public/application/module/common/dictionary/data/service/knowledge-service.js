angular.module("common.dictionary.data")
  .factory("knowledgeService", function ($http) {
    return {
      list: function (start, limit) {
        return $http.get('/knowledge', {})
          .then(function (response) {
            return response.data;
          });
      },

      create: function(data){
        return $http.post('/knowledge', data)
          .then(function (response) {
            return response.data;
          });
      },

      update: function(data){
        return $http.put('/knowledge', data)
          .then(function (response) {
            return response.data;
          });
      }
    }
  });