package mygui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import UIComponent.DynamicText;
import UIComponent.FilterBox;
import UIComponent.InputArea;
import UIComponent.InputText;
import UIComponent.MenuBar;
import UIComponent.MyLabelComponent;
import UIComponent.MyReminder;
import UIComponent.Password;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TableList;
import UIComponent.TableTool;
import UIComponent.TextButton;
import UIComponent.UIStyle;
import administrator.query;
import administrator.update;

public class EquipModify
{

    public EquipModify(String a, String b, String c, String d, String x, String f)
    {
        run(a, b, c, d, x, f);
    }


    public void run(String column1, String column2, String column3, String column4, String column5, String column6)
    {
    	new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2+50), (int)(UIStyle.ScreenHeight - UIStyle.height)/2+70, (int) UIStyle.width-100, (int) UIStyle.height-100);
		JLayeredPane testPanel=new JLayeredPane();
		testPanel.setLayout(null);
        
		JLabel picture = new Picture("./imgs/china2.jpg", UIStyle.width, UIStyle.height-UIStyle.barHeight);
		picture.setBounds(0, UIStyle.barHeight, UIStyle.width, UIStyle.height-UIStyle.barHeight);
		testPanel.add(picture,new Integer(Integer.MIN_VALUE));

		
		jf.add(testPanel);

        Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
        Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);
        Font SMALL_FONT = new Font("Arial", Font.PLAIN, 16);

        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        MyReminder remind = new MyReminder(tool);

        TextButton quit = new TextButton(UIStyle.width - 130, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);

        TextButton mini = new TextButton(UIStyle.width - 170, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);

        TextButton back = new TextButton(30, 30, Color.decode("#58606A"), Color.black, "BACK", 30, 30, "tiny", true);
        tool.add(back);

        DynamicText top = new DynamicText(UIStyle.width / 2 / 2 - 2, UIStyle.height / 2 - 250, "mid", Color.decode("#58606A"), Color.BLACK, "Modify Equipment", 400, 100, BIG_FONT);
        testPanel.add(top);

        DynamicText before = new DynamicText(UIStyle.width / 2 / 2 - 220, UIStyle.height / 2 - 200, "mid", Color.decode("#58606A"), Color.BLACK, "Prime Information", 400, 100, NORMAL_FONT);
        testPanel.add(before);

        DynamicText after = new DynamicText(UIStyle.width / 2 / 2 + 220, UIStyle.height / 2 - 200, "mid", Color.decode("#58606A"), Color.BLACK, "New Information", 400, 100, NORMAL_FONT);
        testPanel.add(after);

        DynamicText id = new DynamicText(10, UIStyle.height / 2 / 2, "right", Color.decode("#58606A"), Color.BLACK, "Equipment ID:", 150, 100, SMALL_FONT);
        testPanel.add(id);
        //InputText in=new InputText(80,UIStyle.height / 2/2+10,200,25, 11, false, "");
        InputText a = new InputText(200, 25, 11, true, UIStyle.width / 2 / 2 + 20, UIStyle.height / 2 / 2 + 50, "", true);
        a.setText(column1);
        a.setEditable(false);
        testPanel.add(a);

        DynamicText name = new DynamicText(10, UIStyle.height / 2 / 2 + 50, "right", Color.decode("#58606A"), Color.BLACK, "Equipment Name:", 150, 100, SMALL_FONT);
        testPanel.add(name);
        InputText b = new InputText(200, 25, 11, true, UIStyle.width / 2 / 2 + 20, UIStyle.height / 2 / 2 + 100, "", true);
        b.setText(column2);
        b.setEditable(false);
        testPanel.add(b);

        DynamicText pass = new DynamicText(10, UIStyle.height / 2 / 2 + 100, "right", Color.decode("#58606A"), Color.BLACK, "Introduction:", 150, 100, SMALL_FONT);
        testPanel.add(pass);
        InputText c = new InputText(200, 25, 11, true, UIStyle.width / 2 / 2 + 20, UIStyle.height / 2 / 2 + 150, "", true);
        c.setText(column3);
        c.setEditable(false);
        testPanel.add(c);

        DynamicText type = new DynamicText(10, UIStyle.height / 2 / 2 + 150, "right", Color.decode("#58606A"), Color.BLACK, "Equipment Type:", 150, 100, SMALL_FONT);
        testPanel.add(type);
        InputText d = new InputText(200, 25, 11, true, UIStyle.width / 2 / 2 + 20, UIStyle.height / 2 / 2 + 200, "", true);
        d.setText(column4);
        d.setEditable(false);
        testPanel.add(d);

        DynamicText manu = new DynamicText(10, UIStyle.height / 2 / 2 + 200, "right", Color.decode("#58606A"), Color.BLACK, "Manufacturer ID:", 150, 100, SMALL_FONT);
        testPanel.add(manu);
        InputText y = new InputText(200, 25, 11, true, UIStyle.width / 2 / 2 + 20, UIStyle.height / 2 / 2 + 250, "", true);
        y.setText(column5);
        y.setEditable(false);
        testPanel.add(y);

        DynamicText family = new DynamicText(10, UIStyle.height / 2 / 2 + 250, "right", Color.decode("#58606A"), Color.BLACK, "Family ID:", 150, 100, SMALL_FONT);
        testPanel.add(family);
        InputText z = new InputText(200, 25, 11, true, UIStyle.width / 2 / 2 + 20, UIStyle.height / 2 / 2 + 300, "", true);
        z.setText(column6);
        z.setEditable(false);
        testPanel.add(z);

        InputText x = new InputText(200, 25, 11, true, UIStyle.width - 310, UIStyle.height / 2 / 2 + 50, "", true);
        testPanel.add(x);
        InputText f = new InputText(200, 25, 11, true, UIStyle.width - 310, UIStyle.height / 2 / 2 + 100, "", true);
        testPanel.add(f);
        InputText g = new InputText(200, 25, 11, true, UIStyle.width - 310, UIStyle.height / 2 / 2 + 150, "", true);
        testPanel.add(g);
        InputText h = new InputText(200, 25, 11, true, UIStyle.width - 310, UIStyle.height / 2 / 2 + 200, "", true);
        testPanel.add(h);
        InputText j = new InputText(200, 25, 11, true, UIStyle.width - 310, UIStyle.height / 2 / 2 + 250, "", true);
        testPanel.add(j);
        InputText k = new InputText(200, 25, 11, true, UIStyle.width - 310, UIStyle.height / 2 / 2 + 300, "", true);
        testPanel.add(k);


        TextButton confirm = new TextButton(UIStyle.width / 2 - 50, UIStyle.height / 2 + 180, Color.decode("#6CA6CD"), Color.black, "Confirm", 100, 30, "normal", true);
        testPanel.add(confirm);


        jf.getContentPane().add(testPanel);


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

        confirm.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {

                // TODO Auto-generated method stub
                if (x.getText().isEmpty() || f.getText().isEmpty() || g.getText().isEmpty() || h.getText().isEmpty() || j.getText().isEmpty() || k.getText().isEmpty())
                {
                    remind.WRONG("Please fill in the blank.");
                } else if (!x.getText().trim().equalsIgnoreCase(column1.trim()))
                {
                    remind.WRONG("equipment ID can not be changed");
                } else if (!j.getText().trim().equalsIgnoreCase(column5.trim()))
                {
                    remind.WRONG("manufacturer ID can not be changed");
                } else if (!k.getText().trim().equalsIgnoreCase(column6.trim()))
                {
                    remind.WRONG("family ID can not be changed");
                } else if (!h.getText().trim().equalsIgnoreCase(column4.trim()))
                {
                    remind.WRONG("equipment type can not be changed");
                }  else
                {
                    int i = update.updateequipment(Integer.parseInt(column1.trim()), f.getText().trim(), g.getText().trim(), h.getText().trim(), Integer.parseInt(j.getText().trim()), Integer.parseInt(k.getText().trim()));
                    if (i == 1)
                    {
                        remind.OK("Successfully changed!");
                    } else
                    {
                        remind.WRONG("change failed");
                    }

                    //change the data in db

                }


            }
        });


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);


    }


}



