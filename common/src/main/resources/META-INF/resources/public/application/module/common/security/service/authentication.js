export default ['$http', function($http){

  return function(username, password, url){
    return $http({
      method: 'post',
      url: url || '/auth',
      data: `username=${username}&password=${password}`,
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    })
  }
}]