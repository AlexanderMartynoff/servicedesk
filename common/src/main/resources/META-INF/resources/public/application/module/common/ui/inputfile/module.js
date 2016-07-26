import angular from 'angular';

import inputfile from './directive/inputfile';

export default angular.module('common.ui.inputfile', [])
  .directive('inputfile', inputfile)
  .name;