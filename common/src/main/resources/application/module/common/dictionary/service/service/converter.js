// todo - move this service to utils ...
angular.module("common.dictionary.service")
  .factory('converter', function () {

    function Converter() {

      // for request
      this.out = function (ticket) {
        var clone = angular.copy(ticket);
        if (clone.dateOpen instanceof Date) {
          clone.dateOpen = clone.dateOpen.getTime() / 1000;
        }
        if (clone.dateClose instanceof Date) {
          clone.dateClose = clone.dateClose.getTime() / 1000;
        }

        clone.progress = clone.progress >= 0 && clone.progress <= 100 ? clone.progress : 100;
        return clone;
      };

      // from response
      this.in = function (data) {
        var isArray = true;

        if(!angular.isArray(data)){
          data = [data];
          isArray = false;
        }

        data.forEach(function (i) {
          if (typeof i.dateOpen == 'number') {
            i.dateOpen = new Date(i.dateOpen * 1000);
          }
          if (typeof i.dateClose == 'number') {
            i.dateClose = new Date(i.dateClose * 1000);
          }
        });

        return isArray ? data : data[0];
      }
    }

    return new Converter();
  });