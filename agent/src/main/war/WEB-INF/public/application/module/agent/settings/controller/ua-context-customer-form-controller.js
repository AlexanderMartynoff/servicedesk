angular.module("backend.settings")
  .controller("UaContextCustomerFormController", function ($scope) {
    $scope.contractors = [
      {name: "ООО \"Берег СВ\""},
      {name: "Бумага-бланки, ООО"},
      {name: "Бумоптторг, ООО"},
      {name: "Бумсервис, ЗАО"},
      {name: "Гафуров А.Р., ИП"},
      {name: "ООО \"Рога и копыта\""},
      {name: "Европапир, ООО"}
    ];
  });