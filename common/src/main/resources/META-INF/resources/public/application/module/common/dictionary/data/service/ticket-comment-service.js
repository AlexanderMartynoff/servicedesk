export default function ($http) {
  return {
    list: function (params) {
      return $http({
        method: "GET",
        params: params,
        url: "/ticket/comment"
      }).then(function (response) {
        return response.data;
      });
    },
    create: function(comment){
      return $http.post('/ticket/comment', comment).then(function(resposne){
        return resposne.data;
      });
    }
  }
}