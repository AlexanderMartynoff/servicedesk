<%@ page language="java" pageEncoding="utf-8" %>

<!doctype html>
<html>
    <head>
        <jsp:include page="./partial/application-head.jsp"/>
    </head>
    <body>
        <div>
            <nav class="navbar navbar-default navbar-fixed-top" ng-controller="CustomerToolbar">
                <div class="container-fluid">
                    <div id="navbar" class="navbar-collapse">
                        <ul class="nav navbar-nav user-info">
                            <li>
                                <a href="#"
                                   popover-title="{{contractor.fullName || '---'}}"
                                   popover-placement="auto"
                                   uib-popover-template="infoPopoverTplUrl">
                                    <i class="fa fa-info"></i>
                                </a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="/logout"><b class="fa fa-sign-out"></b></a></li>
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