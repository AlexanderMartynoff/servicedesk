<%@ page language="java" pageEncoding="utf-8" %>

<div class="x-topbar navbar-default">
    <div class="row">
        <div class="col-xs-9">
            <ul class="x-topbar-menu">
                <li uib-dropdown>
                    <a href="#" uib-dropdown-toggle tooltip-placement="bottom" uib-tooltip="Меню пользователя">
                        <b class="fa fa-user"></b>
                        <span class="caret"></span>
                    </a>
                    <ul class="uib-dropdown-menu" uib-dropdown-menu>
                        <li><a href="#"><b class="fa fa-user fa-left"></b>Профиль</a></li>
                        <li class="divider"></li>
                        <li><a href="/login"><b class="fa fa-sign-out fa-left"></b>Выйти</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#/settings" tooltip-placement="bottom" uib-tooltip="Настройки">
                        <b class="fa fa-cog"></b>
                    </a>
                </li>
                <li>
                    <a href="" tooltip-placement="bottom" uib-tooltip="Написать сообщение">
                        <b class="fa fa-envelope-o"></b>
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