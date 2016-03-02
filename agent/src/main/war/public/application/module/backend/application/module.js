angular.module('backend.application', [
  // vendor modules
  'ui.router',
  'ui.bootstrap',
  // application modules
  'common.security',
  'backend.auth',
  'backend.ticket',
  'backend.settings',
  'backend.contractor',
  'common.dictionary.model',
  'common.dictionary.service',
  'common.ui.cover',
  'common.dictionary.ui.message'
]);
