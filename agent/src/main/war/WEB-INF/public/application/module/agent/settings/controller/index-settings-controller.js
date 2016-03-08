angular.module("backend.settings")
  .controller("IndexSettingsController", function ($scope) {

    $scope.active = + localStorage.getItem("agent.settings.tab.index") || 0;

    $scope.tabs = [
      {
        id: 1,
        heading: "Пользователи",
        templateUrl: "/public/application/template/agent/settings/tab/users.html"
      },
      {
        id: 2,
        heading: "Приложения",
        templateUrl: "/public/application/template/agent/settings/tab/contexts.html"
      },
      {
        id: 3,
        heading: "Группы",
        templateUrl: "/public/application/template/agent/settings/tab/groups.html"
      },
      {
        id: 4,
        heading: "Внешний вид",
        templateUrl: "/public/application/template/agent/settings/tab/ui.html"
      }
    ];

    $scope.saveActiveTab = function ($index) {
      localStorage.setItem("agent.settings.tab.index", $index);
    };
  });