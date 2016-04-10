angular.module('common.ui.cover', [])
  .directive('uibcover', function () {
    return {
      compile: function (element, attrs) {
        var html = sprintf(
          '<div class="cover" ng-if="%s"></div>' +
          '<div class="cover-progress" ng-if="%s">' +
          '<uib-progressbar class="progress-striped active" type="%s"><b>%s</b></uib-progressbar>' +
          '</div>',


          attrs.trigger || 'covered',
          attrs.trigger || 'covered',
          attrs.type || 'info',
          attrs.label || 'loading ...');

        element.css('position', 'relative')
          .css('display', 'block')
          .prepend(html);
      },

      controller: function ($scope, $element, $attrs, $transclude) {
      }
    }
  });