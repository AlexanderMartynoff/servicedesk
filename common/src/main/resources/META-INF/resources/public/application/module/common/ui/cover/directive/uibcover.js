export default function () {
  return {
    compile: function (element, attrs) {
      attrs.trigger = attrs.trigger || 'covered';
      attrs.type = attrs.type || 'info';
      attrs.label = attrs.label || 'loading ...';

      var html = `
      <div class="cover" ng-if="${attrs.trigger}"></div>
      <div class="cover-progress" ng-if="${attrs.trigger}">
        <uib-progressbar class="progress-striped active" type="${attrs.type}">
          <b>${attrs.label}</b>
        </uib-progressbar>
      </div>`;

      element.css('position', 'relative')
        .css('display', 'block')
        .prepend(html);
    }
  }
}