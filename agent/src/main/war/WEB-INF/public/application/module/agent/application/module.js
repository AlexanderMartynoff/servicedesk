const commonUrl = '../../../../../../../../../../common/src/main/resources/META-INF/resources/public/application/module/common/';

import {angular} from 'angular';
import {config} from './config';


import {service} from '../../../../../../../../../../common/src/main/resources/META-INF/resources/public/application/module/common/dictionary/data/service/service-service';


angular.module('backend.application', [
  // vendor modules
  'ui.router',
  'ui.bootstrap',
  // application modules
  'common.security',
  'backend.ticket',
  'backend.settings',
  'backend.service',
  'backend.contractor',
  'backend.knowledge',
  // commons modules
  'common.dictionary.data',
  'common.dictionary.util',
  'common.ui.cover',
  'common.ui.inputfile',
  'common.ui.enum',
  'common.logged',
  'common.ui.ticket-comments'
]);


angular.config(config);