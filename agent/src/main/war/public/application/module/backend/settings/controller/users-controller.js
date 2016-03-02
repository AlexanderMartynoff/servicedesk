angular.module("backend.settings")
  .controller("UsersController", function ($scope) {
    $scope.users = [
      {
        uaGlobalName: "Ramses",
        uaContext: [
          {label: "backend"},
          {label: "frontend"}
        ],
        uaGroup: [
          {label: "manager"}

        ]
      },
      {
        uaGlobalName: "Jesus",
        uaContext: [
          {label: "frontend"}
        ],
        uaGroup: [
          {label: "performer"},
          {label: "customer"}

        ]
      },
      {
        uaGlobalName: "Mariya",
        uaContext: [
          {label: "backend"},
          {label: "frontend"}
        ],
        uaGroup: [
          {label: "performer"},
          {label: "customer"},
          {label: "manager"}

        ]
      },
      {
        uaGlobalName: "Anna",
        uaContext: [
          {label: "backend"}
        ],
        uaGroup: [
          {label: "customer"},
          {label: "manager"}

        ]
      },
      {
        uaGlobalName: "Alexander",
        uaContext: [
          {label: "backend"},
          {label: "frontend"}
        ],
        uaGroup: [
          {label: "performer"},
          {label: "manager"}

        ]
      },
      {
        uaGlobalName: "Wiki",
        uaContext: [
          {label: "backend"},
          {label: "frontend"}
        ],
        uaGroup: [
          {label: "performer"},
          {label: "customer"}

        ]
      }
    ];
  });