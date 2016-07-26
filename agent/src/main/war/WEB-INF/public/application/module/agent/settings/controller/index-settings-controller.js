export default $scope => {

  $scope.active = +localStorage.getItem("agent.settings.tab.index") || 0;

  $scope.tabs = [
    {
      id: 1,
      heading: "Пользователи",
      templateUrl: "/public/application/template/agent/settings/tab/users.html"
    },
    {
      id: 2,
      heading: "Общие",
      templateUrl: "/public/application/template/agent/settings/tab/contexts.html"
    }
  ];

  $scope.saveActiveTab = function ($index) {
    localStorage.setItem("agent.settings.tab.index", $index);
  };
}