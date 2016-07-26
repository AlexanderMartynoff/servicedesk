// for first import angular - IS IMPORTANT!
import angular from 'angular';

// angular-ui import
import angularUiBootstrapModule from 'angular-ui-bootstrap';
import angularUiRouterModule from 'angular-ui-router/release/angular-ui-router';

// application module import
import config from './config';
import securityModule from 'security/module';
import backendTicketModule from '../ticket/module';
import backendSettingsModule from '../settings/module';


// application style import
import 'cover.css';
import 'loader.css';
import 'main.css';
import 'override.bootstrap.css';

// bootstrap style import
import 'bootstrap/dist/css/bootstrap.css';

// angular-ui-bootstrap style import
import 'angular-ui-bootstrap/dist/ui-bootstrap-csp.css';


angular.module(`backend.application`, [
  // vendor modules
  angularUiBootstrapModule,
  angularUiRouterModule,
  // application modules
  securityModule,
  backendTicketModule,
  backendSettingsModule,
  `backend.service`,
  `backend.contractor`,
  `backend.knowledge`,
  // commons modules
  `common.dictionary.data`,
  `common.dictionary.util`,
  `common.ui.cover`,
  `common.ui.inputfile`,
  `common.ui.enum`,
  `common.logged`,
  `common.ui.ticket-comments`
]).config(config);