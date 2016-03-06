<%--@elvariable id="principal" type="com.itsmtools.common.service.security.Principal"--%>

<%@ page language="java" pageEncoding="utf-8" %>

<div class="x-sidebar navbar-default">
    <div class="user-face">
        <b class="fa fa-user"></b><br/>
        <span>${principal.ua.uaGlobal.firstName} ${principal.ua.uaGlobal.secondName}</span>
    </div>
    <ul class="x-menu-sidebar">
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
</div>
