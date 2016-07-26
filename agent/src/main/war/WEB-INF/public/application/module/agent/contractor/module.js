import angular from 'angular';


import FormContractorController from './controller/form-contractor-controller';
import IndexContractorController from './controller/index-contractor-controller';
import contractorForm from './service/contractor-form';


export default angular.module("backend.contractor", [])
  .controller('IndexContractorController', IndexContractorController)
  .controller('FormContractorController', FormContractorController)
  .factory('contractorForm', contractorForm)
  .name;