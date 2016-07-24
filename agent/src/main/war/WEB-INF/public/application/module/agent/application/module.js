import angular from 'angular';
import config from './config';

import service from 'dictionary/data/service/service-service';

// vendor import
import modal from 'angular-ui-bootstrap/src/modal/index-nocss.js';

// import 'bootstrap/dist/css/bootstrap.css';


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