import angular from 'angular';

// models
import ContractorModel from './model/contractor-model';
import ItServiceModel from './model/it-service-model';
import TicketModel from './model/ticket-model';
import TicketSupportLevelModel from './model/ticket-support-level-model';
import TicketTypeModel from './model/ticket-type-model';
import UaCommonStub from './model/ua-common-stub';
import UaComplexModel from './model/ua-complex-model';
import UaGlobalModel from './model/ua-global-model';


// services
import contractorService from './service/contractor-service';
import knowledgeService from './service/knowledge-service';
import serviceService from './service/service-service';
import supportLevelService from './service/support-level-service';
import ticketCommentService from './service/ticket-comment-service';
import ticketPriorityService from './service/ticket-priority-service';
import ticketService from './service/ticket-service';
import ticketTypeService from './service/ticket-type-service';
import agentPerformerService from './service/ua-performer-service';
import uaService from './service/ua-service';
import uaSpecStore from './service/ua-spec-store';


export default angular.module("common.dictionary.data", [])
  // services
  .factory('ContractorModel', ContractorModel)
  .factory('ItServiceModel', ItServiceModel)
  .factory('TicketModel', TicketModel)
  .factory('TicketSupportLevelModel', TicketSupportLevelModel)
  .factory('TicketTypeModel', TicketTypeModel)
  .factory('UaCommonStub', UaCommonStub)
  .factory('UaComplexModel', UaComplexModel)
  .factory('UaGlobalModel', UaGlobalModel)
  // models
  .factory('contractorService', contractorService)
  .factory('knowledgeService', knowledgeService)
  .factory('serviceService', serviceService)
  .factory('supportLevelService', supportLevelService)
  .factory('ticketCommentService', ticketCommentService)
  .factory('ticketPriorityService', ticketPriorityService)
  .factory('ticketService', ticketService)
  .factory('ticketTypeService', ticketTypeService)
  .factory('agentPerformerService', agentPerformerService)
  .factory('uaService', uaService)
  .factory('uaSpecStore', uaSpecStore)
  .name;
