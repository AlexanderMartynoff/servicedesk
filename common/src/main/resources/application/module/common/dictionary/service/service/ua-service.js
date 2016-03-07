angular.module("common.dictionary.service")
    .factory("uaService", function ($http) {
        return {

            _uaLevelSpec: {
                uaGlobal: {type: "global", label: "Глобальная учетная запись"},
                uaContextBackend: {type: "context", label: "Агент"},
                uaContextFrontend: {type: "context", label: "Клиент"},
                uaGroupAdmin: {type: "group", label: "Администратор"},
                uaGroupManager: {type: "group", label: "Менеджер"},
                uaGroupOperator: {type: "group", label: "Оператор"},
                uaGroupPerformer: {type: "group", label: "Исполнитель"}
            },

            _getUaSpecByKey: function (key) {
                return this._uaLevelSpec[key];
            },

            listComplex: function (start, limit) {
                return $http.get('/ua/global', {})
                    .then(function (response) {
                        var record, records = [];

                        response.data.forEach(function (complexUa) {
                            record = {
                                contexts: [],
                                groups: []
                            };

                            Object.keys(complexUa).forEach(function (uaKey) {
                                var ua = complexUa[uaKey],
                                    uaSpec = this._getUaSpecByKey(uaKey);

                                if (!ua) return;

                                ua.label = uaSpec.label;
                                switch (uaSpec.type) {
                                    case "global":
                                        angular.extend(record, ua);
                                        break;
                                    case "group":
                                        record.groups.push(ua);
                                        break;
                                    case "context":
                                        record.contexts.push(ua);
                                }
                            }, this);

                            records.push(record);

                        }, this);

                        return records;

                    }.bind(this));
            }
        }
    });