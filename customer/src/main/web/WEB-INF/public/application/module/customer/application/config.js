export default ($stateProvider, $compileProvider, $httpProvider) => {
  const url = '/public/application/template/customer/';

  $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|data|mailto|chrome-extension):/);

  $stateProvider
    .state('home', {
      url: '',
      views: {
        index: {
          controller: 'TicketController',
          templateUrl: `${url}ticket/page/index.html`
        }
      }
    });

  $httpProvider.interceptors.push('httpInterceptor');
}