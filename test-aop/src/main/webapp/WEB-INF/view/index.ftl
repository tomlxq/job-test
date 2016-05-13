<!DOCTYPE html>
<html>
<head>
    <title>welcome</title></head>
<link href="/webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
<body>
<div class="container">
    <div ng-controller="navigation as nav" class="container">
        <ul class="nav nav-pills" role="tablist">
            <li class="active"><a href="/">home</a></li>
            <li><a href="/login">login</a></li>
            <li><a href="/logout">logout</a></li>
        </ul>
    </div>
    <h1>Welcome to test access rights</h1>
    <span>login模拟登陆时授权</span>
    <span>logout模拟退出时清除授权</span>


    <h2>需要权限 page/ json</h2>
    <p><a href="/user">查询用户</a></p>
    <p><input type="button" value="AJAX查询用户">
    <div id="result"></div>

    </p>
</div>
<script src="/webjars/jquery/2.1.1/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("input").click(function () {
            $.get("/user2", null, function (data) {
                $("#result").html(JSON.stringify(data));
                console.debug(data);
            }, "json");
        });
    });
</script>
</body>
</html>