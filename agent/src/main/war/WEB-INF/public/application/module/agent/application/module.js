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
  'common.ui.xinputfile',
  'common.ui.enum',
  'common.logged'
]);
