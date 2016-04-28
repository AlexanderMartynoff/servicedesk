angular.module('backend.settings')
  .directive('toggle', function(){
    return {
      restrict: 'E',
      scope: {
        ref: '='
      },
      link: function(scope, element, attr){
        scope.ref = scope.ref || {};
        attr.flag = attr.flag || 'enable';

        element.on('click', function($event){
          $event.preventDefault();
          $event.stopPropagation();

          scope.ref[attr.flag] = !scope.ref[attr.flag];
          scope.$apply();
        });

        scope.$watch('ref', function(newValue){
          setToggleState(newValue);
        }, true);

        function setToggleState(ref){
          if(ref[attr.flag]){
            element.removeClass('fa-circle-o');
            element.addClass('fa-dot-circle-o');
          }else{
            element.removeClass('fa-dot-circle-o');
            element.addClass('fa-circle-o');
          }
        }

        element.addClass('pull-right').addClass('fa');
      }
    }
  });