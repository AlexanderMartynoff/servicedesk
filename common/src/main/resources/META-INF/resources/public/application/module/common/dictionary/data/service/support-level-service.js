export default function ($http) {
  return {
    list: function (start, limit) {
      return $http.get('/support-level')
        .then(function (response) {
          return response.data;
        });
    }
  }
}