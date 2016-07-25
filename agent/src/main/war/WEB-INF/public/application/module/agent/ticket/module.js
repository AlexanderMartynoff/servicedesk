'use strict';

import angular from 'angular';

import ticketForm from './service/ticket-form.js';

import DateTicketController from './controller/date-ticket-controller.js';
import IndexTicketController from './controller/index-ticket-controller.js';
import TicketFormController from './controller/ticket-form-controller.js';


export default angular.module("backend.ticket", [])
  .factory(ticketForm)
  .controller('DateTicketController', DateTicketController)
  .controller('IndexTicketController', IndexTicketController)
  .controller('TicketFormController', TicketFormController)
  .name;