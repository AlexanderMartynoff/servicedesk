<%@ page language="java" pageEncoding="utf-8" %>

<!doctype html>
<html ng-app="customer.application">
    <head>
        <jsp:include page="partial/head.jsp"/>
        <style type="text/css">
            body {
                background: #f8f8f8;
            }

            textarea {
                resize: none;
            }

            .form-signin {
                width: 350px;
                height: 164px;
                position: absolute;
                top: 50%;
                left: 50%;
                margin-top: -82px;
                margin-left: -150px;
            }

            .form-control{
                padding: 12px;
                height: auto;
                position: relative;
                margin-bottom: 5px;
            }

        </style>
    </head>
    <body>
        <form class="form-signin" ng-controller="CustomerAuthController">
            <cover trigger="covered" classes="grey">

                <div ng-if="response.status !== 200" class="alert alert-small alert-danger">
                    <strong>Ответ сервера</strong>: {{response.statusText}}
                </div>

                <input name="username"
                       type="text"
                       id="inputEmail"
                       ng-model="username"
                       class="form-control"
                       placeholder="Почта">

                <input name="password"
                       type="password"
                       id="inputPassword"
                       ng-model="password"
                       class="form-control"
                       placeholder="Пароль">

                <a class="btn btn-primary btn-block"
                   type="submit" ng-click="submit()">Войти</a>
            </cover>
        </form>
    </body>
</html>