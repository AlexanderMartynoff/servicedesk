import angular from 'angular';

import ticketComments from './directive/ticket-comments'
import monitorModule from 'util/monitor/module';

export default angular.module('common.ui.ticket-comments', [monitorModule])
  .directive('ticketComments', ticketComments)
  .name;