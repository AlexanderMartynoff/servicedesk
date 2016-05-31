<%@ page language="java" pageEncoding="utf-8" %>

<!doctype html>
<html ng-app="backend.authentication">
    <head>
        <jsp:include page="./partial/authentication-head.jsp"/>

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

            .form-control[type=text], .form-control[type=password] {
                padding: 12px;
                height: auto;
                position: relative;
            }

            .form-control[type=text] {
                border-bottom-left-radius: 0;
                border-bottom-right-radius: 0;
                margin-bottom: -2px;
            }

            .form-control[type=text]:focus {
                z-index: 1;
            }

            .form-control[type="password"] {
                border-top-left-radius: 0;
                border-top-right-radius: 0;
                margin-bottom: 5px;
            }
        </style>
    </head>
    <body>
        <form class="form-signin" ng-controller="AuthenticationController">
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