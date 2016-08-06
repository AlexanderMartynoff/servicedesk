import angular from 'angular';


// sub import
import accessControl from './service/access-control';
import authentication from './service/authentication';
import principal from './service/principal';
import httpInterceptor from './service/http-interceptor';


export default angular.module('common.security', [])
  .factory('accessControl', accessControl)
  .factory('authentication', authentication)
  .factory('principal', principal)
  .factory('httpInterceptor', httpInterceptor)
  .name;