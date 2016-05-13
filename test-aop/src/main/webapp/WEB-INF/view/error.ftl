<!DOCTYPE html>
<html>
<head>
    <title>error</title></head>
<link href="/webjars/bootstrap/3.2.0/css/bootstrap.css" rel="stylesheet">
<body>
<div class="container">
<#if oprst?? && !oprst>
  <div class="alert alert-danger">${opmsg!}</div>
</#if>
</div>
</body>
</html>