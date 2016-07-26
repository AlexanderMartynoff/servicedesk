// for first import angular - IS IMPORTANT!
import angular from 'angular';


import securityModule from 'security/module';
import commonUiCoverModule from 'ui/cover/module';

// bootstrap style import
import 'bootstrap/dist/css/bootstrap.css';

// application style import
import 'cover.css';
import 'loader.css';
import 'main.css';
import 'override.bootstrap.css';


import AuthenticationController from './controller/authentication-controller';

angular.module('backend.authentication', [
  securityModule,
  commonUiCoverModule
]).controller('AuthenticationController', AuthenticationController);