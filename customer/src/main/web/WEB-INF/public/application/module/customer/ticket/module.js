import angular from 'angular';


import TicketController from './controller/ticket-controller';
import TicketFormController from './controller/ticket-form-controller';
import ticketForm from './service/ticket-form';


export default angular.module('customer.ticket', [])
  .controller('TicketController', TicketController)
  .controller('TicketFormController', TicketFormController)
  .factory('ticketForm', ticketForm)
  .name;