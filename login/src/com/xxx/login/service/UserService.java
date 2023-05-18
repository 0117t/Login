package com.xxx.login.service;

import com.xxx.login.Dao.UserDao;
import com.xxx.login.entity.MessageMode;
import com.xxx.login.entity.User;
import com.xxx.login.util.StringUtil;

/**
 * 业务逻辑
 */
public class UserService {
    /**
     * 用户登录
     * 1. 参数的非空判断
     * 如果参数为空
     * 将状态码，提示信息，回显数据设置到消息模型对象中，返回消息模式对象
     * 2. 调用Dao层的查询方法，通过用户名查询用户对象
     * 3. 判断用户对象是否为空
     * 如果为空，将状态码，提示信息，回显数据设置到消息模型对象中，返回消息模式对象
     * 4. 判断数据库中查询到的密码与前台传递的密码作比较
     * 如果不相等，将状态码，提示信息，回显数据设置到消息模型对象中，返回消息模式对象
     * 5. 登录成功，将成功状态，提示信息，用户对象设置消息模型对象。并return
     */
    public static MessageMode userLogin(String uname, String upwd) throws Exception {
        MessageMode messageMode = new MessageMode();
        System.out.println("111111");
        //回显数据
        User u = new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        messageMode.setObject(u);
        //1. 参数的非空判断
        if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)) {
            //将状态码，提示信息，回显数据设置到消息模型对象中，返回消息模式对象
            messageMode.setCode(0);
            messageMode.setMsg("用户姓名和密码不能为空！");
            return messageMode;
        }
        System.out.println("333");
        //2. 调用Dao层的查询方法，通过用户名查询用户对象
        UserDao userDao = new UserDao();
        User user = userDao.login(uname);
        System.out.println("2222");
        //3. 判断用户对象是否为空
        if (user == null) {
            //如果为空，将状态码，提示信息，回显数据设置到消息模型对象中，返回消息模式对象
            messageMode.setCode(0);
            messageMode.setMsg("用户不存在！");
            return messageMode;
        }
        //4. 判断数据库中查询到的密码与前台传递的密码作比较
        if (!upwd.equals(user.getUserPwd())) {
            //如果不相等，将状态码，提示信息，回显数据设置到消息模型对象中，返回消息模式对象
            messageMode.setCode(0);
            messageMode.setMsg("用户密码不正确！");
            return messageMode;
        }

        //5. 登录成功，将用户信息设置到消息模型中
        messageMode.setObject(user);


        return messageMode;
    }
}
