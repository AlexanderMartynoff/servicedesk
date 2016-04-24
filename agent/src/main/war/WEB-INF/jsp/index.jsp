<%@ page language="java" pageEncoding="utf-8" %>
<%--@elvariable id="principal" type="com.itsmtools.common.service.security.Principal"--%>

<!doctype html>
<html ng-app="backend.application" ng-controller="RootController" ng-cloak>
    <head>
        <jsp:include page="./partial/head.jsp"/>
    </head>
    <body>
        <div class="x-layout">
            <jsp:include  page="./partial/toolbar.jsp">
                <jsp:param name="principal" value="${principal}"/>
            </jsp:include>
            <div class="container-fluid">
                <div class="x-content" ui-view="index"></div>
            </div>
        </div>
    </body>
</html>