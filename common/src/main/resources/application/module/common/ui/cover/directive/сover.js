angular.module('common.ui.cover', [])
  .directive('cover', function () {
    return {
      compile: function (element, attrs) {
        element.css('position', 'relative')
          .css('display', 'block')
          .prepend(
            sprintf('<div class="cover" ng-if="%s"></div>', attrs.trigger || 'covered') +
            sprintf('<div class="cover-progress" ng-if="%s">', attrs.trigger) +
            sprintf('<uib-progressbar class="progress-striped active" type="%s"><b>%s</b></uib-progressbar>',
              attrs.type || 'info', attrs.label || 'loading ...') + '</div>');
      },

      controller: function($scope, $element, $attrs, $transclude){
      }
    }
  });