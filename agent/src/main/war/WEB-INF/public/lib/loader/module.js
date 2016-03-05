angular.module('shared.loader', ["ng"])

    .constant("moduleRootUrl", "/static/application/module/")

    .directive("load", function (Loader, $compile, $log, $timeout) {
        return {
            scope: true,

            compile: function (templateElement, templateAttributes) {
                return {
                    pre: function (scope, element, attrs) {

                        if (!attrs.module) {
                            throw "Module attribute must be exists";
                        }

                        var loader = new Loader();

                        var template = element.html();
                        console.log($compile());

                        loader.load(attrs.module.split(/\s/))
                            .then(function () {
                                $log.info(element);
                            }, function (reason) {
                                element.html(reason.toString());
                                throw reason;
                            });
                    }
                }
            }
        }
    })


    // Constructor for loader service.
    // For use you need instance this service.
    .provider("Loader", function ($controllerProvider, $provide, $compileProvider, $filterProvider, $injector) {
        this.$get = function ($http, $q, moduleRootUrl) {

            // Constructor for loader service.
            return function () {
                this.$providers = {
                    $controllerProvider: $controllerProvider,
                    $compileProvider: $compileProvider,
                    $filterProvider: $filterProvider,
                    $provide: $provide,
                    $injector: $injector
                };

                /**
                 * Регистр процессов загрузки, которые
                 * выполняются на данный момент.
                 *
                 * @type {Object}
                 * @private
                 */
                this._loadProcessRegistry = {};


                /**
                 * История процессов загрузки.
                 *
                 * @type {Object}
                 * @private
                 */
                this._loadProcessResultRegister = {};


                this._defer = null;


                /**
                 * Публичный метод для запуска
                 * процеса загрузки модулей.
                 *
                 * @public
                 * @param modules {Array}
                 * @returns {Object}
                 */
                this.load = function (modules) {
                    if (!Array.isArray(modules)) {
                        throw "modules must be Array";
                    }
                    this._defer = $q.defer();
                    this._load(modules);
                    return this._defer.promise;
                };


                /**
                 * Выполняет загрузку модулей.
                 *
                 * @param modules
                 * @private
                 */
                this._load = function (modules) {
                    var me = this;
                    angular.forEach(modules, function (moduleName) {
                        if (this._existsModule(moduleName)) {
                            return;
                        }
                        this._registerLoadProcess(moduleName);
                        $http.get(me._makeModuleUrl(moduleName))
                            .then(function (response) {
                                var requires;
                                try {
                                    eval(response.data);
                                    requires = me._getModuleRequires(moduleName);
                                    if (requires.length > 0) {
                                        me._load(requires);
                                        me._unregisterLoadProcess(moduleName);
                                    } else {
                                        me._unregisterLoadProcess(moduleName);
                                        me._iAmLastInTheLine(moduleName);
                                    }
                                } catch (e) {
                                    me._defer.reject(e);
                                }
                            },
                            function (reason) {
                                me._defer.reject(reason);
                            });
                    }, this);

                    if (Object.keys(this._loadProcessRegistry).length === 0) {
                        this._defer.resolve();
                    }
                };


                /**
                 * Добавляет новый процесс в регистр процессов.
                 *
                 * @param moduleName
                 * @private
                 */
                this._registerLoadProcess = function (moduleName) {
                    this._loadProcessResultRegister[moduleName] = moduleName;
                    this._loadProcessRegistry[moduleName] = moduleName;
                };


                /**
                 * Снимает процесс загрузки с регистрации.
                 *
                 * @param moduleName
                 * @private
                 */
                this._unregisterLoadProcess = function (moduleName) {
                    delete this._loadProcessRegistry[moduleName];
                };


                /**
                 * Проверяет есть ли на данный
                 * момент активные заггрузки.
                 *
                 * @returns {boolean}
                 * @private
                 */
                this._isComplete = function () {
                    return Object.keys(this._loadProcessRegistry).length === 0;
                };


                this._iAmLastInTheLine = function (moduleName) {
                    if (this._isComplete()) {
                        this._registerModulesInvoke(this._loadProcessResultRegister);
                        this._defer.resolve();
                        console.info("Load process was complete by module: " + moduleName);
                    }
                };


                this._existsModule = function (moduleName) {
                    try {
                        angular.module(moduleName);
                    } catch (e) {
                        return false;
                    }
                    return true;
                };


                this._getAlreadyRegisterModules = function () {

                };


                this._getModuleInvokeQueue = function (moduleName) {
                    return angular.module(moduleName)._invokeQueue;
                };


                this._registerModulesInvoke = function (moduleNameList) {
                    angular.forEach(moduleNameList, function (moduleName) {
                        this._registerModuleInvoke(moduleName);
                        this._initRunBlock(moduleName);
                    }, this);
                };


                this._registerModuleInvoke = function (moduleName) {
                    var providerName, provider,
                        invokeType, invokeArgs,
                        moduleRef = angular.module(moduleName);

                    angular.forEach(moduleRef._invokeQueue, function (invoke) {
                        providerName = invoke[0];
                        invokeType = invoke[1];
                        invokeArgs = invoke[2];
                        provider = this.$providers[providerName];

                        provider[invokeType].apply(provider, invokeArgs);
                    }, this);

                };


                this._initRunBlock = function (moduleName) {

                };


                this._getModuleRequires = function (moduleName) {
                    return angular.module(moduleName).requires;
                };


                this._makeModuleUrl = function (moduleName) {
                    return moduleRootUrl + moduleName.split(".").join("/") + ".js";
                };
            };
        }
    });