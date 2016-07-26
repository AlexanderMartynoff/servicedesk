/**
 * Created by alexander on 12.03.16.
 *
 * @example
 *
 * var paginator = new Paginator();
 * paginator.load(collection);
 */
export default function(){

  return function (){
    // constants
    this.PAGE_SIZE = 8;
    this.$$collection = [];
    /// First page index is 1
    this.$$index = 1;
    this.$$size = 0;
    this.$$pages = [];
    this.currents = [];

    this.load = function(collection, size){
      this.$$collection = collection;
      this.$$size = size || this.PAGE_SIZE;
      this.paging(this.$$collection, this.$$size);
      this.currents = this.getCurrentPage();
    };

    this.unshift = function(element){
      this.$$collection.unshift(element);
      this.paging(this.$$collection, this.$$size);
      this.currents = this.getCurrentPage();
    };

    this.getCurrentPage = function(){
      return this.getPageByIndex(this.$$index);
    };

    this.getPageByIndex = function(index){
      return this.$$pages[(this.$$index = index) - 1];
    };

    this.setPage = function(index){

      if(index < 0){
        index = this.$$pages.length - 1;
      }

      if(index > this.$$pages.length - 1){
        index = 0;
      }

      this.$$index = index;
      this.currents = this.getCurrentPage();
    };

    this.paging = function(collection, pageSize){
      pageSize = parseInt(pageSize);

      if(isNaN(pageSize) || pageSize < 1){
        pageSize = 1;
      }

      // reset for pages
      this.$$pages = [];
      var pageNumber = Math.ceil(collection.length / pageSize);

      for(var i = 0; i < pageNumber; i++){
        this.$$pages.push(collection.slice(i * pageSize, (i * pageSize) + pageSize));
      }
      return this.$$pages;
    };

    this.unpaging = function(){
      var collection = [];
      this.$$pages.forEach(function(e){
        collection = collection.concat(e);
      });
      return collection;
    }
  }
}