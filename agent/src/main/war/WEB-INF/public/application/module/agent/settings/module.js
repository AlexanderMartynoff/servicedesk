'use strict';

import angular from 'angular';


import userEditWindow from './service/user-edit-window';
import toggle from './directive/toggle';
import IndexSettingsController from './controller/index-settings-controller';
import UaContextAgentFormController from './controller/ua-context-agent-form-controller';
import UaContextCustomerFormController from './controller/ua-context-customer-form-controller';
import UaGlobalFormController from './controller/ua-global-form-controller';
import UserEditWindowController from './controller/user-edit-window-controller';
import UsersController from './controller/users-controller';


export default angular.module("backend.settings", [])
  .factory('userEditWindow', userEditWindow)
  .directive('toggle', toggle)
  .controller('IndexSettingsController', IndexSettingsController)
  .controller('UaContextAgentFormController', UaContextAgentFormController)
  .controller('UaContextCustomerFormController', UaContextCustomerFormController)
  .controller('UaGlobalFormController', UaGlobalFormController)
  .controller('UsersController', UsersController)
  .controller('UserEditWindowController', UserEditWindowController)
  .name;