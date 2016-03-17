<%@ page language="java" pageEncoding="utf-8" %>
<%--@elvariable id="principal" type="com.itsmtools.common.service.security.Principal"--%>

<!doctype html>
<html ng-app="backend.application" ng-controller="RootController" ng-cloak>
    <head>
        <jsp:include page="./partial/head.jsp"/>
    </head>
    <body>
        <div class="x-layout">
            <div class="container-fluid">
                <jsp:include  page="./partial/toolbar.jsp"/>
                <div class="x-sidebar navbar-default">
                    <jsp:include page="./partial/sidebar.jsp">
                        <jsp:param name="principal" value="${principal}"/>
                    </jsp:include>
                </div>
                <div class="x-content">
                    <cover trigger="indexViewCovered">
                        <div ui-view="index"></div>
                    </cover>
                </div>
            </div>
        </div>
    </body>
</html>