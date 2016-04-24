<%@ page language="java" pageEncoding="utf-8" %>

<!doctype html>
<html ng-app="customer.application">
    <head>
        <jsp:include page="./partial/head.jsp"/>
    </head>
    <body>
        <div>
            <nav class="navbar navbar-default navbar-fixed-top" ng-controller="CustomerNavMenu">
                <div class="container-fluid">
                    <div id="navbar" class="navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li ng-class="{active: activeItem == 'profile'}"
                                ng-click="activeItem = 'profile'">
                                <a href="#/profile"><i class="fa fa-left fa-info"></i></a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="/logout">Выход</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="container-fluid customer-container">
                <div ui-view="index"></div>
            </div>
        </div>
    </body>
</html>