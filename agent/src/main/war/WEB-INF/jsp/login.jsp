<%@ page language="java" pageEncoding="utf-8" %>

<!doctype html>
<html>
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
            }
        </style>
    </head>
    <body>
        <form class="form-signin" ng-controller="AuthController">
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

                <div class="checkbox">
                    <div class="row">
                        <div class="col-xs-6">
                            <label>
                                <input type="checkbox" value="remember-me"> Запомнить меня
                            </label>
                        </div>
                        <div class="col-xs-6" style="text-align: right"><a href="#">Забыли пароль?</a></div>
                    </div>
                </div>

                <a class="btn btn-primary btn-block"
                   type="submit" ng-click="submit()">Войти</a>
            </cover>
        </form>
    </body>
</html>