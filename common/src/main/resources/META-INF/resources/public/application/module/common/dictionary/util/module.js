import angular from 'angular';


import converter from './service/converter';
import ellipsis from './service/ellipsis';
import Paginator from './service/paginator';


export default angular.module("common.dictionary.util", [])
  .factory('converter', converter)
  .factory('ellipsis', ellipsis)
  .factory('Paginator', Paginator)
  .name;