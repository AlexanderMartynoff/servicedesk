export default function () {
  return {
    account: {
      type: "account",
      label: "Глобальная учетная запись"
    },
    agent: {
      type: "application",
      label: "Агент"
    },
    customer: {
      type: "application",
      label: "Клиент"
    },
    agentAdmin: {
      type: "group",
      label: "Администратор"
    },
    agentManager: {
      type: "group",
      label: "Менеджер"
    },
    agentOperator: {
      type: "group",
      label: "Оператор"
    },
    agentPerformer: {
      type: "group",
      label: "Исполнитель"
    },
    customerCustomer: {
      type: "group",
      label: "Клиент"
    }
  };
}