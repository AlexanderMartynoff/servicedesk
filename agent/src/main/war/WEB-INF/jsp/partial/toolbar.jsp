<%@ page language="java" pageEncoding="utf-8" %>

<div class="x-topbar navbar-default">
    <div class="row">
        <div class="col-xs-9">
            <ul class="x-topbar-menu">

                <li uib-dropdown>
                    <a href="#" uib-dropdown-toggle uib-tooltip="Меню приложения" tooltip-placement="right">
                        <b class="fa fa-bars"></b>
                        <span class="caret"></span>
                    </a>
                    <ul class="uib-dropdown-menu" uib-dropdown-menu>
                        <li>
                            <a href="#/ticket/list"><b class="fa fa-left fa-ticket"></b>Заявки</a>
                        </li>
                        <li>
                            <a href="#/problem/list"><b class="fa fa-left fa-medkit"></b>Проблемы</a>
                        </li>
                        <li>
                            <a href="#/skillhub/list"><b class="fa fa-left fa-database"></b>База знаний</a>
                        </li>
                        <li>
                            <a href="#/contractor"><b class="fa fa-left fa-user-secret"></b>Котрагнеты</a>
                        </li>
                        <li>
                            <a href="#/partner"><b class="fa fa-left fa-medkit"></b>Услуги</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#/settings" tooltip-placement="bottom" uib-tooltip="Настройки">
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