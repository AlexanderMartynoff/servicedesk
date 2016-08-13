import angular from 'angular';


class Monitor {
  constructor($http, $timeout){
    // angular services
    this.$http = $http;
    this.$timeout = $timeout;

    this.defaultTimeout = 3000;
    this.isAlive = false;
    this.stopThis = false;
    this.currentPromise = null;
  }

  configure(props){
    this.props = props || {};
    this.props.successCallback = this.props.successCallback || angular.noop;
    this.props.errorCallback = this.props.errorCallback || angular.noop;

    if(angular.isFunction(this.props.service)){
      this.executor = this.doServiceRequest;
    } else if(angular.isString(this.props.url)){
      this.executor = this.doHttpRequest;
    } else {
      this.executor = null;
    }

    return this;
  }

  stop(){
    this.stopThis = true;
    return this.currentPromise;
  }

  start(){
    if(!this.isAlive) {
      this.step();
    } else {
      console.log('already in progress');
    }
  }

  /**
   * @protected
   * @returns {Promise}
   */
  step(){
    this.currentPromise = this.executor().then(response => {
      this.props.successCallback(response);
      if(this.stopThis){
        alert('stop');
        this.isAlive = false;
        this.stopThis = false;
      } else {
        // TODO - вот из-за этого мы получаем разрезолвенный (предыдущий) промис
        this.$timeout(() => {
          this.step();
        }, this.props.timeout || this.defaultTimeout);
      }
      return response;

    }, reason => {
      this.isAlive = false;
      this.stopThis = false;
      this.props.errorCallback(reason);
      return reason;
    });
  }

  /**
   * @protected
   * @returns {Promise}
   */
  doHttpRequest(){
    return this.$http({
      method: this.props.method,
      url: this.props.url
    });
  }

  /**
   * @protected
   * @returns {Promise}
   */
  doServiceRequest(){
    return this.props.service();
  }
}

export default angular.module('common.ui.monitor', [])
  .factory('monitor', ($http, $timeout) => {
    return new Monitor($http, $timeout);
  }).name;