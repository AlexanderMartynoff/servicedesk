export default ($compileProvider, $stateProvider, $urlRouterProvider, $httpProvider) => {

  const root = '/public/application/template/agent/';

  $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|data|mailto|chrome-extension):/);
  $urlRouterProvider.otherwise('/404');

  $stateProvider.state('root', {
      url: '',
      views: {
        index: {
          controller: 'IndexTicketController',
          templateUrl: `${root}ticket/page/index.html`
        }
      }
    })
    .state('ticket', {
      url: '/ticket/list',
      views: {
        index: {
          controller: 'IndexTicketController',
          templateUrl: `${root}ticket/page/index.html`
        }
      }
    })
    .state('settings', {
      url: '/settings',
      views: {
        index: {
          controller: 'IndexSettingsController',
          templateUrl: `${root}settings/page/index.html`
        }
      }
    })
    .state('help', {
      url: '/help/main',
      views: {
        index: {
          templateUrl: `${root}help/page/index.html`
        }
      }
    })
    .state('dashboard', {
      url: '/dashboard',
      views: {
        index: {
          templateUrl: `${root}dashboard/page/index.html`
        }
      }
    })
    .state('contractor', {
      url: '/contractor',
      views: {
        index: {
          controller: 'IndexContractorController',
          templateUrl: `${root}contractor/page/index.html`
        }
      }
    })
    .state('service', {
      url: '/service',
      views: {
        index: {
          controller: 'IndexServiceController',
          templateUrl: `${root}service/page/index.html`
        }
      }
    })
    .state('knowledge', {
      url: '/knowledge',
      views: {
        index: {
          controller: 'IndexKnowledgeController',
          templateUrl: `${root}knowledge/page/index.html`
        }
      }
    })
    .state('404', {
      url: '/404',
      views: {
        index: {
          templateUrl: `${root}error/404.html`
        }
      }
    });

  $httpProvider.interceptors.push('httpInterceptor');
};