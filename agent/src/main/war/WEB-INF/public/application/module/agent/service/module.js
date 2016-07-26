import angular from 'angular';


import FormServiceController from './controller/form-service-controller'
import IndexServiceController from './controller/index-service-controller'
import serviceDetail from './service/service-detail'


export default angular.module("backend.service", [])
  .factory('serviceDetail', serviceDetail)
  .controller('FormServiceController', FormServiceController)
  .controller('IndexServiceController', IndexServiceController)
  .name;