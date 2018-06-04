<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<#--put-->
<form action="/user" method="post">
    <input TYPE="hidden" name="_method" value="PUT">
    <input type="text" name = "id" value="${user.id}">
    <br>
    name:<input name="name" value="${user.name}">
    <br>
    age:<input name="age" value="${user.age}">
    <br>
    <input type="submit">
</form>
</body>
</html>