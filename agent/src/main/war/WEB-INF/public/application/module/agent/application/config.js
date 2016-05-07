angular.module('backend.application')
  // routing configuration

  .config(function ($stateProvider, $urlRouterProvider) {

    var rootUrl = '/public/application/template/agent/';

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
      .state('404', {
        url: '/404',
        views: {
          index: {
            templateUrl: rootUrl + 'error/404.html'
          }
        }
      });

    $urlRouterProvider.otherwise('/404');
  });