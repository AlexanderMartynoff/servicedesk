// for first import angular - IS IMPORTANT!
import angular from 'angular';


import securityModule from 'security/module';
import commonUiCoverModule from 'ui/cover/module';

import CustomerAuthenticationController from './customer-authentication-controller';

// bootstrap style import
import 'bootstrap/dist/css/bootstrap.css';

// application style import
import 'cover.css';
import 'loader.css';
import 'main.css';
import 'override.bootstrap.css';

angular.module('customer.authentication', [
  securityModule,
  commonUiCoverModule
]).controller('CustomerAuthenticationController', CustomerAuthenticationController);