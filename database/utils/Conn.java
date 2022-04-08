package utils;//导入包
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * database connection test code
 */
public class Conn {
    public static void main(String[] args) {
        Connection con;
        //jdbc driver驱动
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/smarthome?&useSSL=false&serverTimezone=UTC";
        String user="root";
        String password="220016";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            System.out.println("数据库驱动加载成功");
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动尚未安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }

}
