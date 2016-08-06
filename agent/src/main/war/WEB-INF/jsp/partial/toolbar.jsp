<%@ page language="java" pageEncoding="utf-8" %>

<div class="navbar navbar-inverse navbar-fixed-top" ng-controller="ApplicationToolbar">
    <div class="navbar-collapse collapse">

        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li uib-dropdown>
                    <a href="#"
                       uib-dropdown-toggle
                       tooltip-placement="right"
                       uib-tooltip="Навигация">
                        <b class="fa fa-bars"></b>
                        <span class="caret"></span>
                    </a>

                    <ul class="uib-dropdown-menu x-app-menu" uib-dropdown-menu>
                        <li>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">
                                        <span>
                                            {{firstName}} {{secondName}} ({{position}})
                                        </span>
                                    </h3>
                                </div>
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

                                        <a href="#/knowledge"
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
                                            <i class="fa fa-left fa-group"></i> Котрагнеты
                                            <span class="pull-right small">
                                                <em>Управление контрагентами</em>
                                            </span>
                                        </a>
                                        <a href="#/service"
                                           class="list-group-item"
                                           ng-class="{active: selModule == 'service'}"
                                           ng-click="selModule = 'service'">
                                            <i class="fa fa-left fa-truck"></i> Услуги
                                            <span class="pull-right small">
                                                <em>Управление ИТ-услгами</em>
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
                       uib-tooltip="Конфигурирование"
                       ng-click="selModule = null"
                       ng-if="isAdmin()">
                        <b class="fa fa-cog"></b>
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right x-no-margin">
                <li tooltip-placement="left" uib-tooltip="Выйти из приложения">
                    <a href="/logout">
                        <b class="fa fa-sign-out"></b>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>