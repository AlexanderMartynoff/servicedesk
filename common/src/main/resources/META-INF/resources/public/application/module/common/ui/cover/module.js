import angular from 'angular';

import coverDirective from './directive/сover';
import uibcoverDirective from './directive/uibcover';

export default angular.module('common.ui.cover', [])
  .directive('cover', coverDirective)
  .directive('uibcover', uibcoverDirective)
  .name;