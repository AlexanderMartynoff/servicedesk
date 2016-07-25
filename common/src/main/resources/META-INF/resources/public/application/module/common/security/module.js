'use strict';

import angular from 'angular';

// sub import
import accessControl from './service/access-control.js';
import authentication from './service/authentication.js';
import principal from './service/principal.js';

export default angular.module('common.security', [])
  .factory(`accessControl`, accessControl)
  .factory(`authentication`, authentication)
  .factory(`principal`, principal)
  .name;
