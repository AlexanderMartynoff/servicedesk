export default (loggedData, loggedNormalization) => {

  class Logged {
    constructor(loggedNormalData) {
      this.logged = loggedNormalData;
    }

    getId() {
      return this.logged.account.id;
    }

    getAccount() {
      return this.logged.account;
    }

    // admin logic
    isAdmin() {
      return this.logged.agentAdmin.enable;
    }

    isOnlyAdmin() {
    }

    // performer logic
    isPerformer() {
      return this.logged.agentPerformer.enable;
    }

    isOnlyPerformer() {
      return this.logged.agentPerformer.enable &&
        !this.logged.agentOperator.enable &&
        !this.logged.agentManager.enable;
    }

    // operator logic
    isOperator() {
      return this.logged.agentOperator.enable;
    }

    isOnlyOperator() {}

    // manager logic
    isManager() {
      return this.logged.agentManager.enable;
    }

    // common logic
    isCanEscalation(ticket, direction, limitOfNumber) {
      if (!ticket.supportLevel) {
        return false;
      }

      if (direction > 0) {
        return (ticket.supportLevel.number < limitOfNumber) && this.isCanEditTicket();
      } else if (direction < 0) {
        return (ticket.supportLevel.number > 1) && this.isCanEditTicket();
      }
    }

    isCanAssignToMe(ticket) {
      return (this.logged.agentOperator.enable | this.logged.agentOperator.enable) &&
        this.logged.agentPerformer.enable;
    }

    isCanFilterByPerformer() {
      return this.isCanEditTicket();
    }

    isCanEditTicket() {
      return this.logged.agentOperator.enable || this.logged.agentManager.enable;
    }

    isCanSetTicketProgress(ticket) {
      if (!(ticket.performer && ticket.performer.id)) {
        return false;
      }
      return this.isPerformer() && (ticket.performer.id == this.getAccount().id);
    }

    isServiceDeskPersonal() {
      return this.logged.agentOperator.enable ||
        this.logged.agentManager.enable ||
        this.logged.agentPerformer.enable;
    }

    isCanFilterLine() {
      return this.logged.agentOperator.enable || this.logged.agentManager.enable;
    }

  }

  return new Logged(loggedNormalization(loggedData));
}