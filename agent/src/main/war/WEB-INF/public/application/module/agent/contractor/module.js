import angular from 'angular';


import FormContractorController from './controller/form-contractor-controller';
import IndexContractorController from './controller/index-contractor-controller';
import contractorForm from './service/contractor-form';


export default angular.module("backend.contractor", [])
  .controller('FormContractorController', FormContractorController)
  .controller('IndexContractorController', IndexContractorController)
  .factory('contractorForm', contractorForm)
  .name;