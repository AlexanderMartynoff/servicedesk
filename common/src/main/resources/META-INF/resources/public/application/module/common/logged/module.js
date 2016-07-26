import angular from 'angular';

import logged from './service/logged';
import loggedNormalization from './service/logged-normalization';


export default angular.module('common.logged', [])
  .factory('logged', logged)
  .factory('loggedNormalization', loggedNormalization)
  .name;