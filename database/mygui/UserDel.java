package mygui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import UIComponent.DynamicText;
import UIComponent.InputText;
import UIComponent.MyReminder;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TableList;
import UIComponent.TextButton;
import UIComponent.UIStyle;
import administrator.query;
import administrator.update;

public class UserDel
{


    public void run()
    {
    	new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
		JLayeredPane testPanel=new JLayeredPane();
		testPanel.setLayout(null);
        
		JLabel picture = new Picture("./imgs/blue.jpg", UIStyle.width, UIStyle.height-UIStyle.barHeight);
		picture.setBounds(0, UIStyle.barHeight, UIStyle.width, UIStyle.height-UIStyle.barHeight);
		testPanel.add(picture,new Integer(Integer.MIN_VALUE));

		
		jf.add(testPanel);

        Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
        Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);
        Font SMALL_FONT = new Font("Arial", Font.PLAIN, 16);

        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        MyReminder remind = new MyReminder(tool);

        TextButton quit = new TextButton(UIStyle.width - 30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);

        TextButton mini = new TextButton(UIStyle.width - 70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);

        TextButton back = new TextButton(30, 30, Color.decode("#58606A"), Color.black, "BACK", 30, 30, "tiny", true);
        tool.add(back);

        DynamicText top = new DynamicText(UIStyle.width / 2 / 2 + 50, UIStyle.height / 2 - 250, "mid", Color.decode("#58606A"), Color.BLACK, "Delete User", 400, 100, BIG_FONT);
        testPanel.add(top);

        DynamicText type = new DynamicText(120, UIStyle.height / 2 - 183, "mid", Color.decode("#58606A"), Color.BLACK, "Search type : ", 150, 95, SMALL_FONT);
        testPanel.add(type);

        InputText in = new InputText(397, UIStyle.height / 2 / 2, 200, 30, 11, false, "");
        testPanel.add(in);


        TextButton find = new TextButton(UIStyle.width / 2 + 200, UIStyle.height / 2 - 136, Color.decode("#6CA6CD"), Color.black, "Search", 100, 30, "normal", true);
        testPanel.add(find);

        TextButton del = new TextButton(UIStyle.width / 2 + 330, UIStyle.height / 2 - 136, Color.decode("#EE6363"), Color.black, "Delete", 100, 30, "normal", true);
        testPanel.add(del);

        JRadioButton a = new JRadioButton("ID");
        a.setBounds(250, 155, 50, 20);
        a.setContentAreaFilled(false);
        a.setFocusPainted(false);
        JRadioButton b = new JRadioButton("Name");
        b.setBounds(300, 155, 70, 20);
        b.setContentAreaFilled(false);
        b.setFocusPainted(false);
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(a);
        btnGroup.add(b);
        testPanel.add(a);
        testPanel.add(b);


        String[] attribute = {"User ID", "User Name", "Password", "Family ID"};
        // String[][] value= new String[][]{{"0001","Joy","0003","@123"},{"0002","Joe","0002","@143"}};
        String[][] value = new String[][]{{"", "", "", ""}};
        TableList table = new TableList(attribute, value, Color.BLACK, Color.WHITE, Color.decode("#F0F8FF"), UIStyle.width / 2 - 485, UIStyle.height / 2 / 2, UIStyle.width - 10, UIStyle.height / 2);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(0, 350));

        scrollPane.setViewportView(table);
        jf.getContentPane().setLayout(new BorderLayout());
        jf.getContentPane().add(scrollPane, BorderLayout.SOUTH);
        jf.getContentPane().add(testPanel);

//	        MyTable mt = new MyTable();
//	        
//	        JTable t = new JTable(mt);
//	        JCheckBox jc1 = new JCheckBox();
//	        t.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(jc1));
//	        t.setPreferredScrollableViewportSize(new Dimension(0, 350));
//	        JScrollPane s = new JScrollPane(t);
//	        jf.getContentPane().setLayout(new BorderLayout());
//	        jf.getContentPane().add(s, BorderLayout.SOUTH);
//	        jf.getContentPane().add(testPanel);
//	        t.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        quit.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                // TODO Auto-generated method stub
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }


        });

        mini.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                // TODO Auto-generated method stub
                jf.setExtendedState(JFrame.ICONIFIED);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }


        });

        back.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                // TODO Auto-generated method stub
                UserMag l = new UserMag();
                l.run();
                jf.setVisible(false);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }


        });

        find.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {

                // TODO Auto-generated method stub
                if (in.getText().isEmpty())
                {
                    remind.WRONG("Please fill in the blank.");
                } else if (a.isSelected())//check if there's duplicate ID in db
                {
                    //search by ID in db
                    String[][] v = query.queryuserid(Integer.parseInt(in.getText().trim()));
                    //TableList t= new TableList(attribute,v, Color.BLACK, Color.WHITE, Color.decode("#F0F8FF"), UIStyle.width/2-485, UIStyle.height/2/2, UIStyle.width-10,UIStyle.height/2);

                    DefaultTableModel model = new DefaultTableModel(v, attribute);
                    TableList t = new TableList(model, Color.BLACK, Color.WHITE, Color.decode("#F0F8FF"), UIStyle.width / 2 - 485, UIStyle.height / 2 / 2, UIStyle.width - 10, UIStyle.height / 2);
                    //table.setModel(model);
                    t.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    JScrollPane s = new JScrollPane();
                    scrollPane.setPreferredSize(new Dimension(0, 350));

                    scrollPane.setViewportView(t);
                    jf.getContentPane().add(s, BorderLayout.SOUTH);

                    del.addMouseListener(new MouseAdapter()
                    {

                        @Override
                        public void mouseClicked(MouseEvent e)
                        {

                            // TODO Auto-generated method stub


                            int[] rowIndex = t.getSelectedRows();
                            //System.out.println("length:"+rowIndex.length);
                            for (int i = 0; i < rowIndex.length; i++)
                            {


                                if (rowIndex[i] == -1)
                                {
                                    remind.WRONG("Please choose an object.");
                                } else
                                {


                                    int getid = Integer.parseInt(t.getValueAt(rowIndex[i], 0).toString().trim());
                                    update.deleteuser(getid);

                                }

                            }
                            for (int i = 0; i < rowIndex.length; i++)
                            {

                                int j=0;

                                if (rowIndex[j] == -1)
                                {
                                    remind.WRONG("Please choose an object.");
                                    j++;
                                } else
                                {
                                    model.removeRow(rowIndex[j]);
                                }

                            }


                        }
                    });


                } else if (b.isSelected())
                {
                    //search by name in db

                    String[][] v = query.queryusername(in.getText().trim());
                    //TableList t= new TableList(attribute,v, Color.BLACK, Color.WHITE, Color.decode("#F0F8FF"), UIStyle.width/2-485, UIStyle.height/2/2, UIStyle.width-10,UIStyle.height/2);

                    DefaultTableModel model = new DefaultTableModel(v, attribute);
                    TableList t = new TableList(model, Color.BLACK, Color.WHITE, Color.decode("#F0F8FF"), UIStyle.width / 2 - 485, UIStyle.height / 2 / 2, UIStyle.width - 10, UIStyle.height / 2);
                    //table.setModel(model);
                    t.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    JScrollPane s = new JScrollPane();
                    scrollPane.setPreferredSize(new Dimension(0, 350));

                    scrollPane.setViewportView(t);
                    jf.getContentPane().add(s, BorderLayout.SOUTH);

                    del.addMouseListener(new MouseAdapter()
                    {

                        @Override
                        public void mouseClicked(MouseEvent e)
                        {

                            // TODO Auto-generated method stub


                                int[] rowIndex = t.getSelectedRows();
                                //System.out.println("length:"+rowIndex.length);
                                for (int i = 0; i < rowIndex.length; i++)
                                {


                                    if (rowIndex[i] == -1)
                                    {
                                        remind.WRONG("Please choose an object.");
                                    } else
                                    {


                                        int getid = Integer.parseInt(t.getValueAt(rowIndex[i], 0).toString().trim());
                                        update.deleteuser(getid);

                                    }

                                }
                                for (int i = 0; i < rowIndex.length; i++)
                                {

                                    int j=0;

                                    if (rowIndex[j] == -1)
                                    {
                                        remind.WRONG("Please choose an object.");
                                        j++;
                                    } else
                                    {
                                        model.removeRow(rowIndex[j]);
                                    }

                                }


                            }
                        });

                    }

                }
            });


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);


        }


        public static void main (String[]args)
        {
            UserDel l = new UserDel();
            l.run();
        }

        //CheckBox
//	class MyTable extends AbstractTableModel {
//
//	    Object[][] p = {
//	            { "qw", new Integer(66), new Integer(32), new Integer(98), false },
//	            { "er", new Integer(85), new Integer(69), new Integer(154), true }, };//data from db
//
//	    String[] n = { "User ID", "User Name", "Family ID", "Password","Delet or not"};
//
//	    @Override
//	    public int getRowCount() {
//	        return p.length;
//	    }
//
//	    @Override
//	    public int getColumnCount() {
//	        return n.length;
//	    }
//
//	    @Override
//	    public Object getValueAt(int rowIndex, int columnIndex) {
//	        return p[rowIndex][columnIndex];
//	    }
//
//	    @Override
//	    public String getColumnName(int column) {
//	        return n[column];
//	    }
//
//	    @Override
//	    public Class<?> getColumnClass(int columnIndex) {
//	        return getValueAt(0, columnIndex).getClass();
//	    }
//
//	    @Override
//	    public boolean isCellEditable(int rowIndex, int columnIndex) {
//	        return true;
//	    }
//
//	    @Override
//	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//	        p[rowIndex][columnIndex] = aValue;
//	        fireTableCellUpdated(rowIndex, columnIndex);
//	    }
//	}


    }
