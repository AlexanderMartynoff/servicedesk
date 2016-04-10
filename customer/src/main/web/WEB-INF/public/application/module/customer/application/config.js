angular.module('customer.application')

  .constant('customerTemplateRootUrl', '/public/application/template/customer/')

  .config(function ($stateProvider, customerTemplateRootUrl) {

    $stateProvider.state('home', {
        url: '',
        views: {
          index: {
            templateUrl: customerTemplateRootUrl + 'application/page/index.html'
          }
        }
      })
      .state('ticket', {
        url: '/ticket/list',
        views: {
          index: {
            controller: 'CustomerTicketCtrl',
            templateUrl: customerTemplateRootUrl + 'ticket/page/index.html'
          }
        }
      });
  });