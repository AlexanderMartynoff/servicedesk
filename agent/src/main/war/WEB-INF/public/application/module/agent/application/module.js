// for first import angular - IS IMPORTANT!
import angular from 'angular';

// angular-ui import
import angularUiBootstrapModule from 'angular-ui-bootstrap';
import angularUiRouterModule from 'angular-ui-router/release/angular-ui-router';

// this module import
import config from './config';
import ApplicationToolbar from './controller/application-toolbar-controller';
import RootController from './controller/root-controller';

// application module import
import securityModule from 'security/module';
import dataModule from 'dictionary/data/module';
import utilModule from 'dictionary/util/module';
import coverModule from 'ui/cover/module';
import inputFileModule from 'ui/inputfile/module';
import enumModule from 'ui/enum/module';
import loggedModule from 'logged/module';
import ticketCommentModule from 'dictionary/ui/ticket-comment/module';


import backendTicketModule from '../ticket/module';
import backendSettingsModule from '../settings/module';
import backendServiceModule from '../service/module';
import backendContractorModule from '../contractor/module';
import backendKnowledgeModule from '../knowledge/module';

// application style import
import 'cover.css';
import 'loader.css';
import 'main.css';
import 'override.bootstrap.css';

// bootstrap style import
import 'bootstrap/dist/css/bootstrap-theme.css';
import 'bootstrap/dist/css/bootstrap.css';

// angular-ui-bootstrap style import
import 'angular-ui-bootstrap/dist/ui-bootstrap-csp.css';

// angular-ui-bootstrap style import
import 'font-awesome/css/font-awesome.css';

// bootstrap tools
import ngApplicationBootstrap from 'ng-application-bootstrap';

const applicationModule = `backend.application`;

angular.module(applicationModule, [
  // vendor modules
  angularUiBootstrapModule,
  angularUiRouterModule,
  // application modules
  securityModule,
  backendTicketModule,
  backendSettingsModule,
  backendServiceModule,
  backendContractorModule,
  backendKnowledgeModule,
  // commons modules
  dataModule,
  utilModule,
  coverModule,
  inputFileModule,
  enumModule,
  loggedModule,
  ticketCommentModule
])
  .config(config)
  .controller('ApplicationToolbar', ApplicationToolbar)
  .controller('RootController', RootController);


ngApplicationBootstrap(applicationModule);