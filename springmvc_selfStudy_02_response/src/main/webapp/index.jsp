<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2022/7/17
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.4.2.js"></script>
    <link href="css/index.css">
    <script>
        $(function(){
            $("#btn").click(function (){
                $.ajax({
                    url:"user/Ajax",
                    type:"POST",
                    contentType:"application/json;charset=UTF-8",
                    data:{"username":"linp","password":"123","age":"20"},
                    dataType:"json",
                    success:function (data){
                        //data是服务器端响应的json数据，进行解析

                    }
                });
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">testString....</a>
    <hr>
    <a href="user/testVoid">testVoid...</a>
    <hr>
    <a href="user/testModelAndView">testModelAndView...</a>
    <hr>
    <button id="btn">点击发送ajax请求</button>
</body>
</html>
