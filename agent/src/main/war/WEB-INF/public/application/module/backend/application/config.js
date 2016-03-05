angular.module('backend.application')
  // routing configuration

  .config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('root', {
        url: '',
        views: {
          index: {
            controller: 'IndexTicketController',
            templateUrl: '/public/application/view/backend/ticket/index.html'
          }
        }
      })
      .state('ticket', {
        url: '/ticket/list',
        views: {
          index: {
            controller: 'IndexTicketController',
            templateUrl: '/public/application/view/backend/ticket/index.html'
          }
        }
      })
      .state('settings', {
        url: '/settings',
        views: {
          index: {
            controller: 'IndexSettingsController',
            templateUrl: '/public/application/view/backend/settings/index.html'
          }
        }
      })
      .state('help', {
        url: '/help/main',
        views: {
          index: {
            templateUrl: '/public/application/view/backend/help/index.html'
          }
        }
      })
      .state('dashboard', {
        url: '/dashboard',
        views: {
          index: {
            templateUrl: '/public/application/view/backend/dashboard/index.html'
          }
        }
      })
      .state('contractor', {
        url: '/contractor',
        views: {
          index: {
            controller: 'IndexContractorController',
            templateUrl: '/public/application/view/backend/contractor/index.html'
          }
        }
      })
      .state('404', {
        url: '/404',
        views: {
          index: {
            templateUrl: '/public/application/view/common/404.html'
          }
        }
      });

    $urlRouterProvider.otherwise('/404');
  });