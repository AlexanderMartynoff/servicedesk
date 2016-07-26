export default function () {
  return {
    compile: function (element, attrs) {
      attrs.trigger = attrs.trigger || 'covered';
      attrs.classes = attrs.classes || 'white';

      var html = `
          <div ng-if="${attrs.trigger}" class="data-loader-wrap ${attrs.classes}">
            <div data-loader="circle"></div>
          </div>
        `;


      element.css('position', 'relative')
        .css('display', 'block')
        .prepend(html);
    }
  }
}