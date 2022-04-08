package administrator;

import utils.jdbcUtils;

import java.sql.*;

//管理员登录后才能使用的功能
public class query
{
    //管理员查看自己信息
    public static String queryAD(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        String result = "";

        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement();//获得SQL执行对象
            String sql = "SELECT `administrator_id`,`administrator_name`,`administrator_password`" +
                    "FROM `administrator` " +
                    "WHERE `administrator_id`=" + No;

            rs = st.executeQuery(sql);

            result += String.format("%-17s", "administrator_id");
            result += String.format("%-15s", "administrator_name");
            result += String.format("%-15s", "administrator_password");
            result += "\n";

            while (rs.next())
            {

                result += String.format("%-17s", rs.getInt("administrator_id"));
                result += String.format("%-15s", rs.getString("administrator_name"));
                result += String.format("%-15s", rs.getString("administrator_password"));
                result += "\n";
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

    //通过ID查询用户
    public static String[][] queryuserid(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT user_id,user_name,user_password,family_id " +
                    "FROM user " +
                    "WHERE user_id=" + No + " AND existed=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][4];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getInt("user_id"));
                    result[i][1] = String.format("%-15s", rs.getString("user_name"));
                    result[i][2] = String.format("%-16s", rs.getString("user_password"));
                    result[i][3] = String.format("%-8s", rs.getInt("family_id"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过名字查询用户
    public static String[][] queryusername(String Name)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT `user_id`,`user_name`,`user_password`,`family_id`" +
                    "FROM `user`" +
//                    "WHERE `user_name` LIKE '%"+Name+"%' AND `existed`=1";
                    "WHERE `user_name` = '" + Name + "' AND `existed`=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][4];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getInt("user_id"));
                    result[i][1] = String.format("%-15s", rs.getString("user_name"));
                    result[i][2] = String.format("%-16s", rs.getString("user_password"));
                    result[i][3] = String.format("%-8s", rs.getInt("family_id"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
    }

    //查询全部用户
    public static String[][] queryuser()
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT user_id,user_name,user_password,family_id " +
                    "FROM user " +
                    "WHERE existed=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][4];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getInt("user_id"));
                    result[i][1] = String.format("%-15s", rs.getString("user_name"));
                    result[i][2] = String.format("%-16s", rs.getString("user_password"));
                    result[i][3] = String.format("%-8s", rs.getInt("family_id"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过ID查询用户是存在
    public static int searchid(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT user_id " +
                    "FROM user " +
                    "WHERE user_id =" + No + " AND existed=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            if (m != 0)
            {
                return 1;
            } else
            {
                return 0;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return 1;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过familyID查询家庭是否存在
    public static int searchfamilyid(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT `family_id`" +
                    "FROM `family`" +
                    "WHERE `family_id`=" + No + " AND `existed`=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            if (m != 0)
            {
                return 1;
            } else
            {
                return 0;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return 1;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过ID查询家庭
    public static String[][] queryfamilyid(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT family_id,family_name , family_address " +
                    "FROM family " +
                    "WHERE family_id =" + No + " AND existed=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][3];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getInt("family_id"));
                    result[i][1] = String.format("%-15s", rs.getString("family_name"));
                    result[i][2] = String.format("%-16s", rs.getString("family_address"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过名字查询家庭
    public static String[][] queryfamilyname(String Name)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT family_id,family_name , family_address " +
                    "FROM family " +
                    "WHERE family_name = '" + Name + "' AND existed = 1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][3];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getInt("family_id"));
                    result[i][1] = String.format("%-15s", rs.getString("family_name"));
                    result[i][2] = String.format("%-16s", rs.getString("family_address"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
    }

    //查询全部家庭
    public static String[][] queryfamily()
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT family_id,family_name,family_address " +
                    "FROM family " +
                    "WHERE existed=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][3];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getInt("family_id"));
                    result[i][1] = String.format("%-15s", rs.getString("family_name"));
                    result[i][2] = String.format("%-16s", rs.getString("family_address"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //查询设备类别是否存在
    public static int searchtype(String Name)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT equipment_type " +
                    "FROM equipment_type " +
                    "WHERE equipment_type='" + Name + "' AND existed =1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            if (m != 0)
            {
                return 1;
            } else
            {
                return 0;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return 1;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过名字查询设备类别
    public static String[][] querytype(String Name)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT equipment_type " +
                    "FROM equipment_type " +
                    "WHERE equipment_type='" + Name + "' AND `existed`=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][1];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getString("equipment_type"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }
    }

    //查询全部设备类别
    public static String[][] querytypeall()
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT equipment_type " +
                    "FROM equipment_type " +
                    "WHERE  existed =1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][1];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getString("equipment_type"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }
    //----------------------------------------------


    //-----------------------------------------------
    //通过ID查询设备
    public static String[][] queryequipmentid(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT equipment_id,equipment_name,equipment_introduction,equipment_type,manufacturer_id,family_id " +
                    "FROM equipment " +
                    "WHERE equipment_id =" + No + " AND existed=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][6];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getInt("equipment_id"));
                    result[i][1] = String.format("%-15s", rs.getString("equipment_name"));
                    result[i][2] = String.format("%-16s", rs.getString("equipment_introduction"));
                    result[i][3] = String.format("%-8s", rs.getString("equipment_type"));
                    result[i][4] = String.format("%-8s", rs.getInt("manufacturer_id"));
                    result[i][5] = String.format("%-8s", rs.getInt("family_id"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过ID和时间查询设备数据个数(<)
    public static int queryequipmentdataless(int No, Timestamp fromdate, Timestamp todate, double data, String val)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT equipment_type " +
                    "FROM equipment " +
                    "WHERE equipment_id =" + No;

            rs = st.executeQuery(sql);
            while (rs.next())
            {
                String type = rs.getString("equipment_type");

                if (type.equals("sensor"))
                {
                    if (val.trim().equals("Humidity"))
                    {
                        String sql3 = "SELECT equipment_id,equipment_type " +
                                "FROM sensor " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                                + " '  ) AND sensor.humidity<" + data
                                + ")";
                        int m = 0;
                        rs = st.executeQuery(sql3);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    } else if (val.equals("Temperature"))
                    {
                        String sql3 = "SELECT equipment_id,equipment_type " +
                                "FROM sensor " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                                + " '  ) AND sensor.temperature <" + data;
                        int m = 0;
                        rs = st.executeQuery(sql3);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;

                    }
                } else if (type.equals("smart bulb"))
                {
                    if (val.trim().equals("Brightness"))
                    {
                        String sql1 = "SELECT equipment_id,equipment_type " +
                                "FROM bulb " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                                + "')  AND  bulb.brightness <" + data;
                        int m = 0;
                        rs = st.executeQuery(sql1);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    } else if (val.trim().equals("State of Door&Window"))
                    {
                        String sql1 = "SELECT equipment_id,equipment_type " +
                                "FROM bulb " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                                + "') AND bulb.Ifopen <" + data;
                        int m = 0;
                        rs = st.executeQuery(sql1);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    }

                } else if (type.equals("smartdoor & window"))
                {
                    String sql2 = "SELECT equipment_id,equipment_type " +
                            "FROM door_window " +
                            "WHERE equipment_id =" + No
                            + " AND existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                            + "  ') AND (Ifopen<" + data
                            + ")";
                    int m = 0;
                    rs = st.executeQuery(sql2);
                    while (rs.next())
                    {
                        m++;
                    }
                    return m;

                } else
                {
                    return 0;
                }
            }
            return 0;


        } catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过ID和时间查询设备数据个数(=)
    public static int queryequipmentdataequal(int No, Timestamp fromdate, Timestamp todate, double data, String val)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql4 = "SELECT equipment_type " +
                    "FROM equipment " +
                    "WHERE equipment_id =" + No;

            rs = st.executeQuery(sql4);
            while (rs.next())
            {
                String type = rs.getString("equipment_type");
                if (type.equals("sensor"))
                {
                    if (val.trim().equals("Humidity"))
                    {
                        String sql3 = "SELECT equipment_id,equipment_type " +
                                "FROM sensor " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                                + " '  ) AND sensor.humidity=" + data
                                + ")";
                        int m = 0;
                        rs = st.executeQuery(sql3);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    } else if (val.equals("Temperature"))
                    {
                        String sql3 = "SELECT equipment_id,equipment_type " +
                                "FROM sensor " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                                + " '  ) AND sensor.temperature =" + data;
                        int m = 0;
                        rs = st.executeQuery(sql3);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;

                    }

                } else if (type.equals("smart bulb"))
                {
                    if (val.trim().equals("Brightness"))
                    {
                        String sql1 = "SELECT equipment_id,equipment_type " +
                                "FROM bulb " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                                + "')  AND  bulb.brightness =" + data;
                        int m = 0;
                        rs = st.executeQuery(sql1);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    } else if (val.trim().equals("State of Door&Window"))
                    {
                        String sql1 = "SELECT equipment_id,equipment_type " +
                                "FROM bulb " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                                + "') AND bulb.Ifopen =" + data;
                        int m = 0;
                        rs = st.executeQuery(sql1);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    }
                } else if (type.equals("smartdoor & window"))
                {
                    String sql2 = "SELECT equipment_id,equipment_type " +
                            "FROM door_window " +
                            "WHERE equipment_id =" + No
                            + " AND existed=1  AND (measure_time between '" + fromdate + "' and '" + todate
                            + "  ') AND (Ifopen=" + data
                            + ")";
                    int m = 0;
                    rs = st.executeQuery(sql2);
                    while (rs.next())
                    {
                        m++;
                    }
                    return m;

                } else
                {
                    return 0;
                }
            }
            return 0;


        } catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过ID和时间查询设备数据个数(>)
    public static int queryequipmentdatamore(int No, Timestamp fromdate, Timestamp todate, double data, String val)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql5 = "SELECT equipment_type " +
                    "FROM equipment " +
                    "WHERE equipment_id =" + No;

            rs = st.executeQuery(sql5);
            while (rs.next())
            {
                String type = rs.getString("equipment_type");
                if (type.equals("sensor"))
                {
                    if (val.trim().equals("Humidity"))
                    {
                        String sql3 = "SELECT equipment_id,equipment_type " +
                                "FROM sensor " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                                + " '  ) AND sensor.humidity>" + data
                                + ")";
                        int m = 0;
                        rs = st.executeQuery(sql3);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    } else if (val.equals("Temperature"))
                    {
                        String sql3 = "SELECT equipment_id,equipment_type " +
                                "FROM sensor " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                                + " '  ) AND sensor.temperature >" + data;
                        int m = 0;
                        rs = st.executeQuery(sql3);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;

                    }


                } else if (type.equals("smart bulb"))
                {
                    if (val.trim().equals("Brightness"))
                    {
                        String sql1 = "SELECT equipment_id,equipment_type " +
                                "FROM bulb " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                                + "')  AND  bulb.brightness >" + data;
                        int m = 0;
                        rs = st.executeQuery(sql1);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    } else if (val.trim().equals("State of Door&Window"))
                    {
                        String sql1 = "SELECT equipment_id,equipment_type " +
                                "FROM bulb " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                                + "') AND bulb.Ifopen >" + data;
                        int m = 0;
                        rs = st.executeQuery(sql1);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    }
                } else if (type.equals("smartdoor & window"))
                {
                    String sql2 = "SELECT equipment_id,equipment_type " +
                            "FROM door_window " +
                            "WHERE equipment_id =" + No
                            + " AND existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                            + "  ') AND (Ifopen >" + data
                            + ")";
                    int m = 0;
                    rs = st.executeQuery(sql2);
                    while (rs.next())
                    {
                        m++;
                    }
                    return m;

                } else
                {
                    return 0;
                }
            }
            return 0;

        } catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }


    //通过时间查询全部设备数据个数(<一半)
    public static int[] queryequipmentdatalessall(Timestamp fromdate, Timestamp todate)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        int[] a = new int[4];


        try
        {

            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象

            String sql3 = "SELECT equipment_id,equipment_type " +
                    "FROM sensor " +
                    "WHERE existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                    + " '  ) AND sensor.temperature <" + 22.75f;
            int m = 0;
            rs = st.executeQuery(sql3);
            while (rs.next())
            {
                m++;
            }
            a[0] = m;

            String sql4 = "SELECT equipment_id,equipment_type " +
                    "FROM sensor " +
                    "WHERE  existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                    + " '  ) AND sensor.humidity<" + 50.0f;
            int m1 = 0;
            rs = st.executeQuery(sql4);
            while (rs.next())
            {
                m1++;
            }
            a[1] = m1;

            String sql5 = "SELECT equipment_id,equipment_type " +
                    "FROM bulb " +
                    "WHERE existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                    + "')  AND  bulb.brightness <" + 137.5f;
            int m2 = 0;
            rs = st.executeQuery(sql5);
            while (rs.next())
            {
                m2++;
            }
            a[2] = m2;

            String sql1 = "SELECT equipment_id,equipment_type " +
                    "FROM bulb " +
                    "WHERE  existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                    + "') AND bulb.Ifopen =" + 0.0f;
            int m3 = 0;
            rs = st.executeQuery(sql1);
            while (rs.next())
            {
                m3++;
            }
            a[3] = m3;


            String sql2 = "SELECT equipment_id,equipment_type " +
                    "FROM door_window " +
                    "WHERE  existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                    + "  ') AND Ifopen=" + 0.0f;
            int m4 = 0;
            rs = st.executeQuery(sql2);
            while (rs.next())
            {
                m4++;
            }
            a[3] = m4+m3;

            return a;


        } catch (SQLException e)
        {
            int[] b = {0, 0};
            e.printStackTrace();
            return b;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过时间查询全部设备数据个数(=一半)
    public static int[] queryequipmentdataequalall(Timestamp fromdate, Timestamp todate)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        int[] a = new int[4];


        try
        {

            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象

            String sql3 = "SELECT equipment_id,equipment_type " +
                    "FROM sensor " +
                    "WHERE existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                    + " '  ) AND sensor.temperature =" + 22.75f;
            int m = 0;
            rs = st.executeQuery(sql3);
            while (rs.next())
            {
                m++;
            }
            a[0] = m;

            String sql4 = "SELECT equipment_id,equipment_type " +
                    "FROM sensor " +
                    "WHERE  existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                    + " '  ) AND sensor.humidity=" + 50.0f;
            int m1 = 0;
            rs = st.executeQuery(sql4);
            while (rs.next())
            {
                m1++;
            }
            a[1] = m1;

            String sql5 = "SELECT equipment_id,equipment_type " +
                    "FROM bulb " +
                    "WHERE existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                    + "')  AND  bulb.brightness =" + 137.5f;
            int m2 = 0;
            rs = st.executeQuery(sql5);
            while (rs.next())
            {
                m2++;
            }
            a[2] = m2;

            String sql1 = "SELECT equipment_id,equipment_type " +
                    "FROM bulb " +
                    "WHERE  existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                    + "') AND bulb.Ifopen =" + 1.0f;
            int m3 = 0;
            rs = st.executeQuery(sql1);
            while (rs.next())
            {
                m3++;
            }
            a[3] = m3;


            String sql2 = "SELECT equipment_id,equipment_type " +
                    "FROM door_window " +
                    "WHERE  existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                    + "  ') AND Ifopen=" + 1.0f;
            int m4 = 0;
            rs = st.executeQuery(sql2);
            while (rs.next())
            {
                m4++;
            }
            a[3] = m4+m3;

            return a;


        } catch (SQLException e)
        {
            int[] b = {0, 0};
            e.printStackTrace();
            return b;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过时间查询设备数据个数(>一半)
    public static int[] queryequipmentdatamoreall(Timestamp fromdate, Timestamp todate)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        int[] a = new int[3];


        try
        {

            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象

            String sql3 = "SELECT equipment_id,equipment_type " +
                    "FROM sensor " +
                    "WHERE existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                    + " '  ) AND sensor.temperature >" + 22.75f;
            int m = 0;
            rs = st.executeQuery(sql3);
            while (rs.next())
            {
                m++;
            }
            a[0] = m;

            String sql4 = "SELECT equipment_id,equipment_type " +
                    "FROM sensor " +
                    "WHERE  existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                    + " '  ) AND sensor.humidity >" + 50.0f;
            int m1 = 0;
            rs = st.executeQuery(sql4);
            while (rs.next())
            {
                m1++;
            }
            a[1] = m1;

            String sql5 = "SELECT equipment_id,equipment_type " +
                    "FROM bulb " +
                    "WHERE existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                    + "')  AND  bulb.brightness >" + 137.5f;
            int m2 = 0;
            rs = st.executeQuery(sql5);
            while (rs.next())
            {
                m2++;
            }
            a[2] = m2;

            String sql1 = "SELECT equipment_id,equipment_type " +
                    "FROM bulb " +
                    "WHERE  existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                    + "') AND bulb.Ifopen =" + 0.0f;
            int m3 = 0;
            rs = st.executeQuery(sql1);
            while (rs.next())
            {
                m3++;
            }



            String sql2 = "SELECT equipment_id,equipment_type " +
                    "FROM door_window " +
                    "WHERE  existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                    + "  ') AND Ifopen=" + 0.0f;
            int m4 = 0;
            rs = st.executeQuery(sql2);
            while (rs.next())
            {
                m4++;
            }


            return a;


        } catch (SQLException e)
        {
            int[] b = {0, 0};
            e.printStackTrace();
            return b;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }


    //通过ID和时间查询设备数据个数(范围)
    public static int queryequipmentdatascope(int No, Timestamp fromdate, Timestamp todate, double data1, double data2, String val)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql5 = "SELECT equipment_type " +
                    "FROM equipment " +
                    "WHERE equipment_id =" + No;

            rs = st.executeQuery(sql5);
            while (rs.next())
            {
                String type = rs.getString("equipment_type");
                if (type.equals("sensor"))
                {
                    if (val.trim().equals("Humidity"))
                    {
                        String sql3 = "SELECT equipment_id,equipment_type " +
                                "FROM sensor " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                                + " '  ) AND (sensor.humidity between " + data1 + " and " + data2 + ")";
                        int m = 0;
                        rs = st.executeQuery(sql3);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    } else if (val.equals("Temperature"))
                    {
                        String sql3 = "SELECT equipment_id,equipment_type " +
                                "FROM sensor " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                                + " '  ) AND (sensor.temperature between " + data1 + " and " + data2 + ")";
                        int m = 0;
                        rs = st.executeQuery(sql3);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;

                    }


                } else if (type.equals("smart bulb"))
                {
                    if (val.trim().equals("Brightness"))
                    {
                        String sql1 = "SELECT equipment_id,equipment_type " +
                                "FROM bulb " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                                + "')  AND  (bulb.brightness between " + data1 + " and " + data2 + ")";
                        int m = 0;
                        rs = st.executeQuery(sql1);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    } else if (val.trim().equals("State of Door&Window"))
                    {
                        String sql1 = "SELECT equipment_id,equipment_type " +
                                "FROM bulb " +
                                "WHERE equipment_id =" + No
                                + " AND existed= '1'  AND (measure_time between '" + fromdate + "' and '" + todate
                                + "') AND (bulb.Ifopen between " + data1 + " and " + data2 + ")";
                        int m = 0;
                        rs = st.executeQuery(sql1);
                        while (rs.next())
                        {
                            m++;
                        }
                        return m;
                    }
                } else if (type.equals("smartdoor & window"))
                {
                    String sql2 = "SELECT equipment_id,equipment_type " +
                            "FROM door_window " +
                            "WHERE equipment_id =" + No
                            + " AND existed= '1' AND (measure_time between '" + fromdate + "' and '" + todate
                            + "  ') AND (Ifopen between " + data1 + " and " + data2 + ")";
                    int m = 0;
                    rs = st.executeQuery(sql2);
                    while (rs.next())
                    {
                        m++;
                    }
                    return m;

                } else
                {
                    return 0;
                }
            }
            return 0;

        } catch (SQLException e)
        {
            e.printStackTrace();
            return 0;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过名字查询设备
    public static String[][] queryequipmentname(String name)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT equipment_id,equipment_name,equipment_introduction,equipment_type,manufacturer_id,family_id " +
                    "FROM equipment " +
                    "WHERE equipment_name ='" + name + "' AND existed=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][6];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getInt("equipment_id"));
                    result[i][1] = String.format("%-15s", rs.getString("equipment_name"));
                    result[i][2] = String.format("%-16s", rs.getString("equipment_introduction"));
                    result[i][3] = String.format("%-8s", rs.getString("equipment_type"));
                    result[i][4] = String.format("%-8s", rs.getInt("manufacturer_id"));
                    result[i][5] = String.format("%-8s", rs.getInt("family_id"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //查询全部设备
    public static String[][] queryequipment()
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT equipment_id,equipment_name,equipment_introduction,equipment_type,manufacturer_id,family_id " +
                    "FROM equipment " +
                    "WHERE  existed=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            rs.beforeFirst();
            String[][] result = new String[m][6];
            if (m != 0 && rs.next())
            {
                for (int i = 0; i < m; i++)
                {
                    result[i][0] = String.format("%-12s", rs.getInt("equipment_id"));
                    result[i][1] = String.format("%-15s", rs.getString("equipment_name"));
                    result[i][2] = String.format("%-16s", rs.getString("equipment_introduction"));
                    result[i][3] = String.format("%-8s", rs.getString("equipment_type"));
                    result[i][4] = String.format("%-8s", rs.getInt("manufacturer_id"));
                    result[i][5] = String.format("%-8s", rs.getInt("family_id"));
                    rs.next();
                }
            }
            return result;

        } catch (SQLException e)
        {
            e.printStackTrace();
            String[][] as = new String[0][0];
            return as;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }

    //通过ID查询设备是存在
    public static int searchequipmentid(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT equipment_id " +
                    "FROM equipment " +
                    "WHERE equipment_id =" + No + " AND `existed`=1";

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            if (m != 0)
            {
                return 1;
            } else
            {
                return 0;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return 1;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }


    //----------------------------------------
    //通过ID查询manufacturer是存在
    public static int searchmanuid(int No)
    {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;


        try
        {
            conn = jdbcUtils.getConnection();//获取数据库连接
            //very importaamt the resultset is originally not able to go back
//            st = conn.createStatement();//获得SQL执行对象
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//获得SQL执行对象
            String sql = "SELECT manufacturer_id " +
                    "FROM manufacturer  " +
                    "WHERE manufacturer_id =" + No;

            int m = 0;
            rs = st.executeQuery(sql);
            while (rs.next())
            {
                m++;
            }
            if (m != 0)
            {
                return 1;
            } else
            {
                return 0;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            return 1;
        } finally
        {
            jdbcUtils.release(conn, st, rs);
        }

    }


}
