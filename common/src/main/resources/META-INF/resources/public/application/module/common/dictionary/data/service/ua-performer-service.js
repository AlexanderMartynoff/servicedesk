export default function ($http) {
  return {
    listAccount: function(){
      return $http.get('/performer', {}).then(function(response){
        return response.data.map(function(user){
          return user.account;
        });
      });
    }
  }
}