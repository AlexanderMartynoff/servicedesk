<%@ page language="java" pageEncoding="utf-8" %>

<!doctype html>
<html ng-app="backend.application" ng-controller="RootController" ng-cloak>
<head>
    <jsp:include page="./partial/head.jsp"/>
</head>
<body>
<div class="x-layout">
    <div class="container-fluid">
        <jsp:include page="./partial/toolbar.jsp"/>
        <div class="x-sidebar navbar-default">
            <jsp:include page="./partial/sidebar.jsp"/>
        </div>
        <div class="x-content">
            <div ui-view="index"></div>
        </div>
    </div>
</div>
</body>
</html>