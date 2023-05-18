<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div style="text-align: center">
    <form action="login" method="post" id="loginForm">
        姓名：<input type="text" name="uname" id="uname" value="${messageMode.object.userName}"> <br>
        密码：<input type="password" name="upwd" id="upwd" value="${messageMode.object.userPwd}"> <br>
        <span id="msg" style="font-size: 12px;color: red">${messageMode.msg}</span><br>
        <button type="button" id="loginBtn">登录</button>
        <button type="button">注册</button>
    </form>
</div>
</body>
<%-- 引入jQuery的js文件 --%>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    /**
     * 登录表单验证
     1. 给登录按钮绑定点击事件
     2.获取用户名姓名和密码的值
     3. 判断姓名是否为空
        如果姓名为空，提示用户（span标签赋值），并且return
     4. 判断密码是否为空
        如果密码为空，提示用户（span标签赋值），并且return
     5. 如果都不为空，则手动提交表单
     */
    $("#loginBtn").click(function () {
        //获取用户名的姓名和密码
        var uname = $("#uname").val();
        var upwd = $("#upwd").val();
        //判断姓名是否为空
        if(ifEmpty(uname)){
          //如果姓名为空，提示用户（span标签赋值），并且return
          $("#msg").html("用户姓名不可为空！");
          return;
        }
        //判断密码是否为空
        if(ifEmpty(upwd)){
          //如果密码为空，提示用户（span标签赋值），并且return
          $("#msg").html("用户密码不可为空！");
          return;
        }
        //如果都不为空，则手动提交表单
        $("#loginForm").submit();
    });

    /**
     * 判断字符串是否为空
     *    如果为空，发返回true
     *    如果不为空，返回false
     * @param str
     * @returns {boolean}
     */
    function ifEmpty(str){
      return str == null || str.trim() === "";

    }
</script>
</html>
