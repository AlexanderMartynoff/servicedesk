import angular from 'angular';


class Monitor {
  constructor($http, $timeout, $log){
    // inject angular services
    this.$http = $http;
    this.$timeout = $timeout;
    this.$log = $log;
    // set params
    this.isAlive = false;
    this.stopAfterComplete = null;
  }

  setProperties(props){
    this.props = props || {};
    this.props.successCallback = this.props.successCallback || angular.noop;
    this.props.errorCallback = this.props.errorCallback || angular.noop;
  }

  start(){
    if(!this.isAlive){
      this.isAlive = true;
      this.doRequest().then(response => {
        this.props.successCallback(response);
        if(this.stopAfterComplete === true){
          this.isAlive = false;
          this.stopAfterComplete = null;
        } else {
          $timeout(() => this.start(), this.props.timeout || 0);
        }
      }, reason => {
        this.isAlive = false;
        this.props.errorCallback(reason);
      })
    }
  }

  /**
   * @protected
   * @returns {Promise}
   */
  doRequest(){
    return this.$http({
      method: this.props.method,
      url: this.props.url
    });
  }

  stop(){
    this.stopAfterComplete = true;
  }
}


export default angular.module('common.ui.cover', [])
  .factory('monitor', ($http, $timeout, $log) => {
    return new Monitor($http, $timeout, $log);
  }).name;