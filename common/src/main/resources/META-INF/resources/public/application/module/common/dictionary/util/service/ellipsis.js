angular.module('common.dictionary.util')
  .factory('ellipsis', function(){
    return function (string, limit){
      limit = limit || 15;
      return string.length >= limit ? string.substring(0, limit) + ' ...' : string;
    }
  });