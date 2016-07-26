import angular from 'angular';

import enumerate from './directive/enum';

export default angular.module('common.ui.enum', [])
  .directive('enum', enumerate)
  .name;