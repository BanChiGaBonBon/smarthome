package mygui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import UIComponent.DynamicText;
import UIComponent.InputText;
import UIComponent.MyReminder;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TableList;
import UIComponent.TextButton;
import UIComponent.UIStyle;
import administrator.query;
import chart.DistributionChart;
import chart.ScopeChart;

public class FamilySum
{
    public void run()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);
        Font SMALL_FONT = new Font("Arial", Font.PLAIN, 16);
        Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
        new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
		JLayeredPane testPanel=new JLayeredPane();
		testPanel.setLayout(null);
        
		JLabel picture = new Picture("./imgs/china2.jpg", UIStyle.width, UIStyle.height-UIStyle.barHeight);
		picture.setBounds(0, UIStyle.barHeight, UIStyle.width, UIStyle.height-UIStyle.barHeight);
		testPanel.add(picture,new Integer(Integer.MIN_VALUE));

		
		jf.add(testPanel);

        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        MyReminder remind = new MyReminder(tool);

        DynamicText top = new DynamicText(UIStyle.width / 2 / 2 + 50, UIStyle.height / 2 - 250, "mid", Color.decode("#58606A"), Color.BLACK, "Family Sum", 400, 100, BIG_FONT);
        testPanel.add(top);

        TextButton quit = new TextButton(UIStyle.width - 30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);

        TextButton mini = new TextButton(UIStyle.width - 70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);

        TextButton back = new TextButton(30, 30, Color.decode("#58606A"), Color.black, "BACK", 30, 30, "tiny", true);
        tool.add(back);


        DynamicText time = new DynamicText(20, UIStyle.height / 2 - 150, "mid", Color.decode("#58606A"), Color.BLACK, "search time : ", 120, 95, SMALL_FONT);
        testPanel.add(time);


        DynamicText from = new DynamicText(100, UIStyle.height / 2 - 150, "mid", Color.decode("#58606A"), Color.BLACK, "from : ", 100, 95, SMALL_FONT);
        testPanel.add(from);
        DynamicText to = new DynamicText(300, UIStyle.height / 2 - 150, "mid", Color.decode("#58606A"), Color.BLACK, "to : ", 100, 95, SMALL_FONT);
        testPanel.add(to);


        //InputText in=new InputText(420,UIStyle.height / 2/2,200,30, 11, false, "");


        InputText infrom = new InputText(180, UIStyle.height / 2 / 2 + 35, 150, 25, 11, false, "");
        testPanel.add(infrom);
        InputText into = new InputText(370, UIStyle.height / 2 / 2 + 35, 150, 25, 11, false, "");
        testPanel.add(into);


        TextButton gene = new TextButton(UIStyle.width / 2 + 250, UIStyle.height / 2 - 105, Color.decode("#6CA6CD"), Color.black, "Generated Graphic", 170, 30, "normal", true);
        testPanel.add(gene);


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
                DataStatis l = new DataStatis();
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

        gene.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {

                try
                {
                    Date from = sdf.parse(infrom.getText().trim());
                    Date to = sdf.parse(into.getText().trim());
                    Timestamp fromtime = new Timestamp(from.getTime());
                    Timestamp totime = new Timestamp(to.getTime()); // TODO Auto-generated method stub
                    if (infrom.getText().isEmpty() || into.getText().isEmpty())
                    {
                        remind.WRONG("Please fill in the blank.");
                    } else if (from.after(to) || from == to)
                    {
                        remind.WRONG("Please choose a right period of time.");

                    } else
                    {
                        int []a= query.queryequipmentdatalessall(fromtime,totime);
                        int []b= query.queryequipmentdataequalall(fromtime,totime);
                        int []c= query.queryequipmentdatamoreall(fromtime,totime);
                        int data[] = {a[0], b[0], c[0], a[1], b[1], c[1], a[2], b[2], c[2], a[3], b[3]};//data from mysql

                        ScopeChart bar = new ScopeChart(data);


                        new UIStyle();

                        JFrame f = new JFrame();
                        f.setBounds((int) ((UIStyle.ScreenWidth - UIStyle.width) / 2 + 130), (int) (UIStyle.ScreenHeight - UIStyle.height) / 2 + 100, (int) UIStyle.width / 2, (int) UIStyle.height / 2);


                        f.add(bar.getChartPanel());
                        f.pack();
                        f.setVisible(true);


                    }
                } catch (ParseException parseException)
                {
                    parseException.printStackTrace();
                }

            }
        });

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);


    }

    public static void main(String[] args)
    {
        FamilySum l = new FamilySum();
        l.run();
    }

}

