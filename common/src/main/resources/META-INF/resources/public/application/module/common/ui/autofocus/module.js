import angular from 'angular';

import autofocusDirective from './directive/autofocus';

export default angular.module('common.ui.autofocus', [])
  .directive('autofocus', autofocusDirective)
  .name;