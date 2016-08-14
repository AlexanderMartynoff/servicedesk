import angular from 'angular';


class Monitor {
  constructor($http, $timeout, $q, $log){
    // angular services
    this.$http = $http;
    this.$timeout = $timeout;
    this.$q = $q;
    this.$log = $log;

    this.defaultTimeout = 3000;
    this.isAlive = false;
    this.stopThis = false;
    this.stopDefer = null;
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
    this.stopDefer = this.$q.defer();
    return this.stopDefer.promise;
  }

  start(){
    if(!this.isAlive) {
      this.step();
    } else {
      this.$log.info('already in progress');
    }
  }

  /**
   * @protected
   * @returns {Promise}
   */
  step(){
    this.executor().then(response => {
      this.props.successCallback(response);
      if(this.stopThis){
        this.isAlive = false;
        this.stopThis = false;
        this.stopDefer.$$resolve(response);
        this.stopDefer = null;
      } else {
        this.$timeout(() => {
          this.step();
        }, this.props.timeout || this.defaultTimeout);
      }
      return response;

    }, reason => {
      this.isAlive = false;
      this.stopThis = false;
      this.stopDefer = null;
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
  .factory('monitor', ($http, $timeout, $q, $log) => {
    return new Monitor($http, $timeout, $q, $log);
  }).name;