angular.module('backend.application')
  // routing configuration

  .config(function ($compileProvider, $stateProvider, $urlRouterProvider) {
    var rootUrl = '/public/application/template/agent/';

    $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|data|mailto|chrome-extension):/);
    $urlRouterProvider.otherwise('/404');

    $stateProvider
      .state('root', {
        url: '',
        views: {
          index: {
            controller: 'IndexTicketController',
            templateUrl: rootUrl + 'ticket/page/index.html'
          }
        }
      })
      .state('ticket', {
        url: '/ticket/list',
        views: {
          index: {
            controller: 'IndexTicketController',
            templateUrl: rootUrl + 'ticket/page/index.html'
          }
        }
      })
      .state('settings', {
        url: '/settings',
        views: {
          index: {
            controller: 'IndexSettingsController',
            templateUrl: rootUrl + 'settings/page/index.html'
          }
        }
      })
      .state('help', {
        url: '/help/main',
        views: {
          index: {
            templateUrl: rootUrl + 'help/page/index.html'
          }
        }
      })
      .state('dashboard', {
        url: '/dashboard',
        views: {
          index: {
            templateUrl: rootUrl + 'dashboard/page/index.html'
          }
        }
      })
      .state('contractor', {
        url: '/contractor',
        views: {
          index: {
            controller: 'IndexContractorController',
            templateUrl: rootUrl + 'contractor/page/index.html'
          }
        }
      })
      .state('service', {
        url: '/service',
        views: {
          index: {
            controller: 'IndexServiceController',
            templateUrl: rootUrl + 'service/page/index.html'
          }
        }
      })
      .state('knowledge', {
        url: '/knowledge',
        views: {
          index: {
            controller: 'IndexKnowledgeController',
            templateUrl: rootUrl + 'knowledge/page/index.html'
          }
        }
      })
      .state('404', {
        url: '/404',
        views: {
          index: {
            templateUrl: rootUrl + 'error/404.html'
          }
        }
      });
  });


var e = 1;
var i = 1;


export {
  e as k, i
};

