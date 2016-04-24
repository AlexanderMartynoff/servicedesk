angular.module("common.dictionary.util")
  .factory('converter', function () {

    function Converter() {

      // for request
      this.out = function (ticket) {
        var clone = angular.copy(ticket);
        if (clone.dateOpen instanceof Date) {
          clone.dateOpen = clone.dateOpen.getTime();
        }
        if (clone.dateClose instanceof Date) {
          clone.dateClose = clone.dateClose.getTime();
        }

        clone.progress = clone.progress >= 0 && clone.progress <= 100 ? clone.progress : 100;
        return clone;
      };

      // from response
      this.in = function (data) {
        var isArray = true;

        if (!angular.isArray(data)) {
          data = [data];
          isArray = false;
        }

        data.forEach(function (i) {
          if (typeof i.dateOpen == 'number') {
            i.dateOpen = new Date(i.dateOpen);
          }
          if (typeof i.dateClose == 'number') {
            i.dateClose = new Date(i.dateClose);
          }
        });

        return isArray ? data : data[0];
      }
    }

    return new Converter();
  });