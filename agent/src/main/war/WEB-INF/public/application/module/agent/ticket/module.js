'use strict';

import angular from 'angular';

import ticketForm from './service/ticket-form';
import DateTicketController from './controller/date-ticket-controller';
import IndexTicketController from './controller/index-ticket-controller';
import TicketFormController from './controller/ticket-form-controller';


export default angular.module("backend.ticket", [])
  .factory('ticketForm', ticketForm)
  .controller('DateTicketController', DateTicketController)
  .controller('IndexTicketController', IndexTicketController)
  .controller('TicketFormController', TicketFormController)
  .name;