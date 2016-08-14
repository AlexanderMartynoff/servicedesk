import angular from 'angular';

import 'angular-i18n/angular-locale_ru.js';

// angular-ui import
import angularUiBootstrapModule from 'angular-ui-bootstrap';
import angularUiRouterModule from 'angular-ui-router/release/angular-ui-router';

// this module import
import config from './config';
import CustomerToolbar from './controller/customer-toolbar';

import ticketModule from '../ticket/module';
import instructionModule from '../instruction/module';


// commons application module import
import securityModule from 'security/module';
import dataModule from 'dictionary/data/module';
import utilModule from 'dictionary/util/module';
import coverModule from 'ui/cover/module';
import autofocusModule from 'ui/autofocus/module';
import inputFileModule from 'ui/inputfile/module';
import enumModule from 'ui/enum/module';
import loggedModule from 'logged/module';
import ticketCommentModule from 'dictionary/ui/ticket-comment/module';
import monitorModule from 'util/monitor/module';


// bootstrap style import
import 'bootstrap/dist/css/bootstrap.css';

// angular-ui-bootstrap style import
import 'angular-ui-bootstrap/dist/ui-bootstrap-csp.css';

// angular-ui-bootstrap style import
import 'font-awesome/css/font-awesome.css';

// application style import
import 'cover.css';
import 'loader.css';
import 'main.css';
import 'override.bootstrap.css';

// bootstrap tools
import ngApplicationBootstrap from 'ng-application-bootstrap';

const mainModule = angular.module('customer.application', [
  // vendor modules
  angularUiRouterModule,
  angularUiBootstrapModule,
  // common modules
  securityModule,
  loggedModule,
  dataModule,
  utilModule,
  coverModule,
  inputFileModule,
  ticketCommentModule,
  // customer modules
  ticketModule,
  instructionModule,
  autofocusModule,
  monitorModule
]);

mainModule.config(config)
  .controller('CustomerToolbar', CustomerToolbar);

ngApplicationBootstrap(mainModule.name);