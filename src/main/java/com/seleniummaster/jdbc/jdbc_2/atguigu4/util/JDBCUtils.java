package com.seleniummaster.jdbc.jdbc_2.atguigu4.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    /**
     * @return
     * @throws Exception
     * @Description 获取数据库的连接
     * @author shkstart
     * @date 上午9:11:23
     */
    public static Connection getConnection() throws Exception {
        // 1.读取配置文件中的4个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        // 2.加载驱动
        Class.forName(driverClass);

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * @Description 使用C3P0的数据库连接池技术
     * @author shkstart
     * @date 下午3:01:25
     * @return
     * @throws SQLException
     */
    //数据库连接池只需提供一个即可。
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");

    public static Connection getConnection1() throws SQLException {
        Connection conn = cpds.getConnection();

        return conn;
    }

    /**
     * @Description 使用DBCP数据库连接池技术获取数据库连接
     * @author shkstart
     * @date 下午3:35:25
     * @return
     * @throws Exception
     */
    //创建一个DBCP数据库连接池
    private static DataSource source;

    static {
        try {
            Properties pros = new Properties();
            FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection2() throws Exception {

        Connection conn = source.getConnection();

        return conn;
    }

    /**
     * 使用Druid数据库连接池技术
     */
    private static DataSource source1;

    static {
        try {
            Properties pros = new Properties();

            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");

            pros.load(is);

            source1 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection3() throws SQLException {

        Connection conn = source1.getConnection();
        return conn;
    }


    /**
     * @param conn
     * @param ps
     * @Description 关闭连接和Statement的操作
     * @author shkstart
     * @date 上午9:12:40
     */
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param conn
     * @param ps
     * @param rs
     * @Description 关闭资源操作
     * @author shkstart
     * @date 上午10:21:15
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param conn
     * @param ps
     * @param rs
     * @Description 使用dbutils.jar中提供的DbUtils工具类，实现资源的关闭
     * @author shkstart
     * @date 下午4:53:09
     */
    public static void closeResource1(Connection conn, Statement ps, ResultSet rs) {
//		try {
//			DbUtils.close(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(ps);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(rs);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(rs);
    }
}
