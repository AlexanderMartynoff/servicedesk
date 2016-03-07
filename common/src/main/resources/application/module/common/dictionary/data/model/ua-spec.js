angular.module("common.dictionary.data")
    .factory("uaSpec", function () {
        return {
            uaGlobal: {
                type: "global",
                label: "Глобальная учетная запись"
            },
            uaContextBackend: {
                type: "context",
                label: "Агент"
            },
            uaContextFrontend: {
                type: "context",
                label: "Клиент"
            },
            uaGroupAdmin: {
                type: "group",
                label: "Администратор"
            },
            uaGroupManager: {
                type: "group",
                label: "Менеджер"
            },
            uaGroupOperator: {
                type: "group",
                label: "Оператор"
            },
            uaGroupPerformer: {
                type: "group",
                label: "Исполнитель"
            }
        };
    });