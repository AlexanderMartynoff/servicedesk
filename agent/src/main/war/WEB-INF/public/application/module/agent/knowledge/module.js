import angular from 'angular';

import FormKnowledgeController from './controller/form-knowledge-controller';
import IndexKnowledgeController from './controller/index-knowledge-controller';
import knowledgeDetail from './service/knowledge-detail';

export default angular.module("backend.knowledge", [])
  .controller('FormKnowledgeController', FormKnowledgeController)
  .controller('IndexKnowledgeController', IndexKnowledgeController)
  .factory('knowledgeDetail', knowledgeDetail)
  .name;