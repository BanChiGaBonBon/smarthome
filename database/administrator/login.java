package administrator;
import utils.jdbcUtils;
import utils.MD5Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login
{
    //log for the administrator,if successful, then return 1, else, return 0
    public static int loginin(int No,String psw)
    {


        Connection conn= null;
        Statement state= null;
        ResultSet set= null;

        int result =0;
        try {
            conn = jdbcUtils.getConnection();//获取数据库连接
            state = conn.createStatement();//获得SQL执行对象
            psw=psw.trim();
            String s=MD5Util.string2MD5(psw);
            s=s.trim();
            String sql = "SELECT `administrator_password` AS `password` FROM `administrator` WHERE `administrator_id`="+No;
            set = state.executeQuery(sql);

            while(set.next())
            {

                if(set.getString("password").trim().equalsIgnoreCase(s))
                {
                    result = 1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            jdbcUtils.release(conn,state,set);
        }
        return result;
    }
}
