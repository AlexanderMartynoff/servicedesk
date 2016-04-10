angular.module('common.ui.cover', [])
  .directive('cover', function () {
    return {
      compile: function (element, attrs) {
        var html = sprintf(
          '<div ng-if="%s" class="data-loader-wrap %s">' +
            '<div data-loader="circle"></div>' +
          '</div>',
          attrs.trigger || 'covered', attrs.classes || 'white'
        );

        element.css('position', 'relative')
          .css('display', 'block')
          .prepend(html);
      },

      controller: function ($scope, $element, $attrs, $transclude) {
      }
    }
  });