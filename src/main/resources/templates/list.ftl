<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>list</title>
</head>
<body>
    <a href="/addUser">增加</a>
    <table border="1">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>age</td>
            <td>操作</td>
        </tr>
        <#list  list  as  user>
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>
                    <a href="javascript:del(${user.id})">删除</a>
                    <a href="/updatePage/${user.id}">修改</a>
                </td>
            </tr>
        </#list>
    </table>

    <#--
        发送一个delete请求的规范
            1：method = "post"
            2：传递一个参数 _method delete put
    -->
    <form method="post" id="delForm">
        <input type="hidden" name="_method" value="DELETE">
    </form>
<script>
    function del(id){
        var form = document.getElementById("delForm");
        form.setAttribute("action","/user/"+id)
        form.submit();
    }

</script>
</body>
</html>