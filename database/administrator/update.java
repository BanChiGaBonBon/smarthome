package administrator;

import utils.MD5Util;
import utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * @author Aaaazdy
 */
public class update
{
    //插入用户
    public static int insertuser(int userid, String username, String userpassword, int familyid)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "INSERT INTO `user` (`user_id`,`user_name`,`user_password`,`family_id`,`existed`)\n" +
                    "VALUES ('" + userid + "','" + username + "','" + MD5Util.string2MD5(userpassword) + "','" + familyid + "',1)";

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //修改用户信息1
    public static int updateuser(int No,int newno,String username,String password,int familyid)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE `user` SET `user_id`= '" + newno+ "',`user_name`= '" + username + "','user_password'='"+MD5Util.string2MD5(password)+"','family_id'='"+familyid+"' WHERE `user_id`=" + No;

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //修改用户信息2
    public static int updateuser(int No,String username,String password,int familyid)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE user SET user_name= '" + username + "',user_password='"+MD5Util.string2MD5(password)+"',family_id="+familyid+" WHERE user_id=" + No;

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //修改用户信息3
    public static int updateuser(int No,int newno)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE `user` SET `user_id`= '" + newno + "' WHERE `user_id`=" + No;

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //删除用户信息
    public static int deleteuser(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE `user` SET `existed`= 0 WHERE `user_id`=" + No;

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //重置用户密码
    public static String resetuserpassword(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String result = null;

        //生成6位随机数作为密码
        Random random = new Random();
        String psw = "";
        for (int i = 0; i < 6; i++)
        {
            psw += random.nextInt(10);
        }


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE user SET user_password = '" + MD5Util.string2MD5(psw) + "'" +
                    "WHERE user_id =" + No;

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = psw;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //插入家庭
    public static int insertfamily(int familyid, String familyname, String address)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "INSERT INTO family (family_id ,family_name ,family_address,existed)\n" +
                    "VALUES (" + familyid + " ,'" + familyname + "','" +address + "', 1)";

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //修改家庭信息
    public static int updatefamily(int No,String familyname,String address)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE family SET family_name= '" + familyname + "',family_address='"+ address +"' WHERE family_id=" + No;

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //删除家庭信息
    public static int deletefamily(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE family SET `existed`= 0 WHERE family_id =" + No;

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //-----------------------------------------------------------
    //-----------------------------------------------------------
    //插入设备信息
    public static int inserttype(String name)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "INSERT INTO equipment_type (equipment_type,existed)\n" +
                    "VALUES ('" + name + "', 1)";

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //修改设备信息
    public static int updatetype(String origin,String name)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE equipment_type SET equipment_type= '" + name +"' WHERE equipment_type='" + origin+"'";

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //删除设备信息
    public static int deletetype(String name)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE equipment_type SET existed= 0 WHERE equipment_type ='" +name+"'";

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //----------------------------------------------------------
    //----------------------------------------------------------
    //插入设备
    public static int insertequipment(int id, String name, String introduction,String type,int manuid, int familyid)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "INSERT INTO `equipment` (equipment_id,equipment_name,equipment_introduction,equipment_type ,manufacturer_id,family_id ,existed )\n" +
                    "VALUES (" +id + ",'" + name + "','" +introduction + "','" + type + "',"+manuid+","+familyid+", 1)";

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //修改设备
    public static int updateequipment(int id,String name,String introduction,String type,int manuid, int familyid)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE equipment SET equipment_name = '" + name + "',equipment_introduction='"+introduction+"',equipment_type ='"+type+"',manufacturer_id="+manuid+",family_id="+familyid+" WHERE equipment_id=" + id;

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }
    //删除设备
    public static int deleteequipment(int id)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        int result = 0;

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "UPDATE equipment SET `existed`= 0 WHERE equipment_id=" + id;

            int i = st.executeUpdate(sql);
            if (i > 0)
            {
                result = 1;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
        return result;
    }




}
