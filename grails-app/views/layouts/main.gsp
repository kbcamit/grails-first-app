<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
    <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>

    <style>
    .custom-logout-btn {
        color: #007bff;
        text-decoration: none;
        background-color: transparent;
        padding: 0px;
        border: none;
    }
    </style>
</head>

<body>

<header>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark rounded">
        <a class="navbar-brand" href="#">Grails CRUD</a>
        <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse"
                data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
</header>

<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
            <ul class="list-group">
                <UIHelper:leftNavigation/>
                <li class="list-group-item">
                    <g:form controller="logout">
                        <g:submitButton class="custom-logout-btn" name="Submit" value="Logout" />
                    </g:form>
                </li>
            </ul>
        </nav>
        <main role="main" class="col-sm-9 ml-sm-auto col-md-10 pt-3">
            <g:layoutBody/>
        </main>
    </div>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
