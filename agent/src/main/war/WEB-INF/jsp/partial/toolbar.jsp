<%@ page language="java" pageEncoding="utf-8" %>

<div class="x-topbar navbar-default">
    <div class="row">
        <div class="col-xs-9">
            <ul class="x-topbar-menu" ng-controller="ApplicationMenu">
                <li uib-dropdown>
                    <a href="#" uib-dropdown-toggle>
                        <b class="fa fa-bars"></b>
                        <span class="caret"></span>
                    </a>

                    <ul class="uib-dropdown-menu x-app-menu" uib-dropdown-menu>
                        <li>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="list-group">
                                        <a href="#/ticket/list"
                                           class="list-group-item"
                                           ng-class="{active: selModule == 'ticket'}"
                                           ng-click="selModule = 'ticket'">
                                            <i class="fa fa-left fa-ticket"></i> Заявки
                                            <span class="pull-right small">
                                                <em>Управление заявками</em>
                                            </span>
                                        </a>

                                        <a href="#/problem/list"
                                           class="list-group-item"
                                           ng-class="{active: selModule == 'problem'}"
                                           ng-click="selModule = 'problem'">
                                            <i class="fa fa-left fa-medkit"></i> Проблемы
                                            <span class="pull-right small">
                                                <em>Управление проблемами</em>
                                            </span>
                                        </a>

                                        <a href="#/skillhub/list"
                                           class="list-group-item"
                                           ng-class="{active: selModule == 'db'}"
                                           ng-click="selModule = 'db'">
                                            <i class="fa fa-left fa-database"></i> База знаний
                                            <span class="pull-right small">
                                                <em>Управление знаниями</em>
                                            </span>
                                        </a>

                                        <a href="#/contractor"
                                           class="list-group-item"
                                           ng-class="{active: selModule == 'contractor'}"
                                           ng-click="selModule = 'contractor'">
                                            <i class="fa fa-left fa-medkit"></i> Котрагнеты
                                            <span class="pull-right small">
                                                <em>Управление контрагентами</em>
                                            </span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#/settings"
                       tooltip-placement="bottom"
                       uib-tooltip="Настройки"
                       ng-click="selModule = null">
                        <b class="fa fa-cog"></b>
                    </a>
                </li>
            </ul>
        </div>
        <div class="col-xs-3">
            <ul class="x-topbar-menu text-right">
                <li style="margin-right: 10px" tooltip-placement="left" uib-tooltip="Выйти из приложения">
                    <a href="/logout">
                        <b class="fa fa-sign-out"></b>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>