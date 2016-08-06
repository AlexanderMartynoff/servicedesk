export default [
  '$window',

  ($window) => {
    return {
      responseError: response => {
        if (response.status == 401) {
          $window.location.href = '/';
        } else {
          return response;
        }
      }
    }
  }
]
