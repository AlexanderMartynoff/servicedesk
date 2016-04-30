angular.module('backend.settings')
  .directive('toggle', function(){
    return {
      restrict: 'E',
      scope: {
        model: '=ref'
      },
      link: function(scope, element, attr){
        scope.model = scope.model || {};
        attr.flag = attr.flag || 'enable';

        element.on('click', function($event){
          scope.model[attr.flag] = !scope.model[attr.flag];

          scope.$apply();
          $event.preventDefault();
          $event.stopPropagation();
        });

        scope.$watch('model', function(newValue){
          if(newValue && newValue[attr.flag]){
            element.removeClass('fa-circle-o');
            element.addClass('fa-dot-circle-o');
          }else{
            element.removeClass('fa-dot-circle-o');
            element.addClass('fa-circle-o');
          }
        }, true);

        element.addClass('pull-right').addClass('fa');
      }
    }
  });