angular.module('backend.application', [
  // vendor modules
  'ui.router',
  'ui.bootstrap',
  // application modules
  'common.security',
  'backend.auth',
  'backend.ticket',
  'backend.settings',
  'backend.service',
  'backend.contractor',
  // commons modules
  'common.dictionary.data',
  'common.dictionary.util',
  'common.ui.cover',
  'common.ui.xinputfile',
  'common.ui.enum'
]);
