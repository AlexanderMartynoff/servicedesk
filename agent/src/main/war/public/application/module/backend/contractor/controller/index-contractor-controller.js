angular.module("backend.contractor")
  .controller("IndexContractorController", function ($scope, $http) {

    function inn() {
      var result = String(), max = 9, min = 0;
      for (var i = 0; i <= 17; i++) {
        result += Math.floor(Math.random() * (max - min + 1)) + min;
      }
      return result;
    }

    $scope.records = [
      {
        inn: inn(),
        name: "ООО \"Берег СВ\"",
        description: "-"
      },
      {
        inn: inn(),
        name: "Бумага-бланки, ООО",
        description: "-"
      },
      {
        inn: inn(),
        name: "Бумоптторг, ООО",
        description: "-"
      },
      {
        inn: inn(),
        name: "Бумсервис, ЗАО",
        description: "-"
      },
      {
        inn: inn(),
        name: "Гафуров А.Р., ИП",
        description: "-"
      },
      {
        inn: inn(),
        name: "ООО \"Рога и копыта\"",
        description: "-"
      },
      {
        inn: inn(),
        name: "Европапир, ООО ",
        description: "-"
      }
    ];
  });