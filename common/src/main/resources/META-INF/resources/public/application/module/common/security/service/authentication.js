export default ['$http', function($http){

  // todo - done on normal!
  return function(username, password, url){
    return $http({
      method: 'post',
      url: url || '/auth',
      data: sprintf('username=%s&password=%s', username, password),
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    })
  }
}]