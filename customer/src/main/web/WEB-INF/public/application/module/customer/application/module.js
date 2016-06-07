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
  'common.ui.xinputfile',
  // customer modules
  'customer.ticket',
  'common.ui.ticket-comments'
]);