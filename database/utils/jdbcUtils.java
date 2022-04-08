package utils;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcUtils {
//
//    private static String driver= null;
//    private static String url= null;
//    private static String user= null;
//    private static String password= null;
    public static String driver="com.mysql.cj.jdbc.Driver";
    public static String url="jdbc:mysql://localhost:3306/smarthome?&useSSL=false&serverTimezone=UTC";
    public static String user="root";
    public static String password="220016";
    static {

        try{
//            InputStream in = jdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
//            Properties properties = new Properties();
//            properties.load(in);
//
//
//
//            driver=properties.getProperty("driver");
//            url=properties.getProperty("url");
//            user=properties.getProperty("user");
//            password=properties.getProperty("password");;
//            driver="com.mysql.cj.jdbc.Driver";
//            url="jdbc:mysql://localhost:3306/smarthome?&useSSL=false&serverTimezone=UTC";
//            user="root";
//            password="220016";

            //驱动加载一次
            Class.forName(driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    //释放连接资源
    public static void release(Connection connection, Statement statement,ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
