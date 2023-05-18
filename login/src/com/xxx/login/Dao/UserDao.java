package com.xxx.login.Dao;

import com.xxx.login.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    static {
        //注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Exception exception;
        }
    }

    public  User login(String userName) throws Exception {
        System.out.println("22222");
        User user = new User();

        //获得连接
        String url = "jdbc:mysql://localhost:3306/java_text";
        String username = "root";
        String password = "20030117";
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("7777");
        //预编译，定义sql语句
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM tb_user WHERE userName=?");
        //设置?的值
        ps.setString(1, userName);
        //执行sql
        ResultSet rs = ps.executeQuery();  //sql执行完之后，会将信息返回到rs中，可以通过rs的next()方法，获取用户名和密码，设置到User类中，
        System.out.println("5555");
        if (rs.next()) {
            user.setUserName(rs.getString("username"));
            user.setUserPwd(rs.getString("userpwd"));
        } else {
            System.out.println("数据库为空!");
        }
        System.out.println("4444");
        //释放资源
        rs.close();
        ps.close();
        connection.close();
        return user;
    }

}
