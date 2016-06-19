angular.module("common.logged")
  .factory('logged', function (loggedData, loggedNormalization) {

    return new (function (loggedNormalData) {
      this.logged = loggedNormalData;

      this.getId = function () {
        return this.logged.account.id;
      };

      this.getAccount = function () {
        return this.logged.account;
      };

      // admin logic
      this.isAdmin = function () {
        return this.logged.agentAdmin.enable;
      };

      this.isOnlyAdmin = function () {
      };

      // performer logic
      this.isPerformer = function () {
        return this.logged.agentPerformer.enable;
      };

      this.isOnlyPerformer = function () {
        return this.logged.agentPerformer.enable &&
          !this.logged.agentOperator.enable &&
          !this.logged.agentManager.enable;
      };

      // operator logic
      this.isOperator = function () {
        return this.logged.agentOperator.enable;
      };

      this.isOnlyOperator = function () {
      };

      // manager logic
      this.isManager = function () {
        return this.logged.agentManager.enable;
      };

      // common logic
      this.isCanEscalation = function (ticket, direction, limitOfNumber) {
        if (!ticket.supportLevel) {
          return false;
        }
        if (direction > 0) {
          return (ticket.supportLevel.number < limitOfNumber) && this.isCanEditTicket();
        } else if (direction < 0) {
          return (ticket.supportLevel.number > 1) && this.isCanEditTicket();
        }
      };

      this.isCanAssignToMe = function (ticket) {
        return (this.logged.agentOperator.enable | this.logged.agentOperator.enable) &&
          this.logged.agentPerformer.enable;
      };

      this.isCanFilterByPerformer = function () {
        return this.isCanEditTicket();
      };

      this.isCanEditTicket = function () {
        return this.logged.agentOperator.enable || this.logged.agentManager.enable;
      };

      this.isCanSetTicketProgress = function (ticket) {
        if (!(ticket.performer && ticket.performer.id)) {
          return false;
        }
        return this.isPerformer() && (ticket.performer.id == this.getAccount().id);
      };

      this.isServiceDeskPersonal = function () {
        return this.logged.agentOperator.enable ||
          this.logged.agentManager.enable ||
          this.logged.agentPerformer.enable;
      };

      this.isCanFilterLine = function () {
        return this.logged.agentOperator.enable || this.logged.agentManager.enable;
      };
    })(loggedNormalization(loggedData));
  });