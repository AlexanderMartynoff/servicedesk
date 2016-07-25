// for first import angular - IS IMPORTANT!
import angular from 'angular';

// angular-ui-bootstrap import
import modal from 'angular-ui-bootstrap/src/modal';

// application module import
import config from './config';
import service from 'dictionary/data/service/service-service';

// application style import
import 'cover.css';
import 'loader.css';
import 'main.css';
import 'override.bootstrap.css';

// bootstrap style import
import 'bootstrap/dist/css/bootstrap.css';


angular.module('customer.application', [
  // vendor modules
  'ui.router',
  'ui.bootstrap',
  // common modules
  'common.security',
  'common.logged',
  'common.dictionary.data',
  'common.dictionary.util',
  'common.ui.cover',
  'common.ui.inputfile',
  // customer modules
  'customer.ticket',
  'common.ui.ticket-comments'
])
  .config(config);