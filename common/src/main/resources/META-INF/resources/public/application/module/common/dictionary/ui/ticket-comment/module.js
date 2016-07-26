import angular from 'angular';

import ticketComments from './directive/ticket-comments'

export default angular.module('common.ui.ticket-comments', [])
  .directive('ticketComments', ticketComments)
  .name;