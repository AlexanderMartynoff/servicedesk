angular.module('common.dictionary.util')
  .factory('ellipsis', function(){
    return function (string, limit){
      limit = limit || 25;
      try{
        return string.length >= limit ? string.substring(0, limit) + ' ...' : string;
      }catch(e){
        return "";
      }
    }
  });