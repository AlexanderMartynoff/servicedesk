export default ($stateProvider, $compileProvider) => {
  const customerTemplateRootUrl = '/public/application/template/customer/';

  $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|data|mailto|chrome-extension):/);

  $stateProvider
    .state('home', {
      url: '',
      views: {
        index: {
          controller: 'TicketController',
          templateUrl: customerTemplateRootUrl + 'ticket/page/index.html'
        }
      }
    }).state('ticket', {
      url: '/ticket/list',
      views: {
        index: {
          controller: 'TicketController',
          templateUrl: customerTemplateRootUrl + 'ticket/page/index.html'
        }
      }
    });
}