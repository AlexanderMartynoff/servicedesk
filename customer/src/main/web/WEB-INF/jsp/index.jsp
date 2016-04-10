<%@ page language="java" pageEncoding="utf-8" %>

<!doctype html>
<html ng-app="customer.application">
    <head>
        <jsp:include page="./partial/head.jsp"/>
    </head>
    <body>
        <div>
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <div id="navbar" class="navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#/ticket/list">Заявки</a></li>
                            <li><a href="#/profile">Профиль</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#/logout">Выход</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="container customer-container">
                <div ui-view="index"></div>
            </div>
        </div>
    </body>
</html>