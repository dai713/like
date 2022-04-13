package com.tl;/*
 * ━━━━━━如来保佑━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━永无BUG━━━━━━
 * 图灵学院-悟空老师
 * www.jiagouedu.com
 * 悟空老师QQ：245553999
 */

import org.apache.commons.dbcp.BasicDataSource;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbBatchInsert {

    static String s[]={"北京","河北","河南","湖南","湖北","山西","山东","海南","海口",
            "深圳","广州","广西","东莞"};//地方
    static String s1[]={"京东","耐克","阿达","腾讯 ","统一","百度","360"
            ,"阿里巴巴","钢铁","小米","锤子","苹果","图灵"};//公司
    static String s2[]={"科技有限公司","科技有限公司","科技有限公司","技术有限公司","技术有限公司",
            "技术有限公司","责任有限公司","责任有限公司","责任有限公司","责任有限公司"};

    public static void main(String[] args) throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/likeseach?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        Connection conn = dataSource.getConnection();
        Statement statement = conn.createStatement();

        for(int i=0;i<80000;i++) {
            int random = new SecureRandom().nextInt(10);
            int random2 = new SecureRandom().nextInt(10);
            int random3 = new SecureRandom().nextInt(10);
            String sql="insert INTO  tl_index(company_name,city,status) VALUES ('" + s[random] + s1[random2] + s2[random3] +"','"+s[random]+"',1)";
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        }

    }
}
