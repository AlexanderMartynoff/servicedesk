// angular import
import angular from 'angular';

// angular-ui-bootstrap import
import modal from 'angular-ui-bootstrap/src/modal';

// bootstrap style import
import 'bootstrap/dist/css/bootstrap.css';

// application module import
import config from './config';
import service from 'dictionary/data/service/service-service';

// application style import
import 'cover.css';
import 'loader.css';
import 'main.css';
import 'override.bootstrap.css';


angular.module('backend.application', [
  // vendor modules
  'ui.router',
  'ui.bootstrap',
  // application modules
  'common.security',
  'backend.ticket',
  'backend.settings',
  'backend.service',
  'backend.contractor',
  'backend.knowledge',
  // commons modules
  'common.dictionary.data',
  'common.dictionary.util',
  'common.ui.cover',
  'common.ui.inputfile',
  'common.ui.enum',
  'common.logged',
  'common.ui.ticket-comments'
]);


angular.config(config);