import angular from 'angular';


import instructionWindowService from './service/instruction-window';


export default angular.module('customer.instruction', [])
  .factory('instructionWindowService', instructionWindowService)
  .name;
