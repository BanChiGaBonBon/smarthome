package mygui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import administrator.query;
import org.jfree.chart.ChartPanel;

import UIComponent.DynamicText;
import UIComponent.InputText;
import UIComponent.MyReminder;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TableList;
import UIComponent.TextButton;
import UIComponent.UIStyle;
import chart.ScopeChart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataScope
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
		
//		JLabel icon1 = new Picture("./imgs/bird.png", 2126,3189);
//		icon1.setBounds(UIStyle.width/2-300, UIStyle.height/2, 500, 300);
//		testPanel.add(icon1,new Integer(Integer.MAX_VALUE));

		
		jf.add(testPanel);
        //jf.add(testPanel);

        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        MyReminder remind = new MyReminder(tool);

        DynamicText top = new DynamicText(UIStyle.width / 2 / 2 + 50, UIStyle.height / 2 - 250, "mid", Color.decode("#58606A"), Color.BLACK, "Scope Statistics", 400, 100, BIG_FONT);
        testPanel.add(top);

        TextButton quit = new TextButton(UIStyle.width - 30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);

        TextButton mini = new TextButton(UIStyle.width - 70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);

        TextButton back = new TextButton(30, 30, Color.decode("#58606A"), Color.black, "BACK", 30, 30, "tiny", true);
        tool.add(back);

        DynamicText equID = new DynamicText(19, UIStyle.height / 2 - 183, "mid", Color.decode("#58606A"), Color.BLACK, "equipment ID : ", 113, 95, SMALL_FONT);
        testPanel.add(equID);
        DynamicText time = new DynamicText(20, UIStyle.height / 2 - 150, "mid", Color.decode("#58606A"), Color.BLACK, "search time : ", 120, 95, SMALL_FONT);
        testPanel.add(time);
        DynamicText type = new DynamicText(519, UIStyle.height / 2 - 183, "mid", Color.decode("#58606A"), Color.BLACK, "Data Type : ", 120, 95, SMALL_FONT);
        testPanel.add(type);
        DynamicText value = new DynamicText(517, UIStyle.height / 2 - 150, "mid", Color.decode("#58606A"), Color.BLACK, "Data Value : ", 120, 95, SMALL_FONT);
        testPanel.add(value);

        DynamicText from = new DynamicText(100, UIStyle.height / 2 - 150, "mid", Color.decode("#58606A"), Color.BLACK, "from : ", 100, 95, SMALL_FONT);
        testPanel.add(from);
        DynamicText to = new DynamicText(300, UIStyle.height / 2 - 150, "mid", Color.decode("#58606A"), Color.BLACK, "to : ", 100, 95, SMALL_FONT);
        testPanel.add(to);


        //InputText in=new InputText(420,UIStyle.height / 2/2,200,30, 11, false, "");


        InputText id = new InputText(180, UIStyle.height / 2 / 2 + 1, 150, 25, 11, false, "");
        testPanel.add(id);

        InputText infrom = new InputText(180, UIStyle.height / 2 / 2 + 35, 150, 25, 11, false, "");
        testPanel.add(infrom);

        InputText into = new InputText(370, UIStyle.height / 2 / 2 + 35, 150, 25, 11, false, "");
        testPanel.add(into);

        InputText val = new InputText(625, UIStyle.height / 2 / 2 + 35, 150, 25, 11, false, "");
        testPanel.add(val);

        TextButton gene = new TextButton(UIStyle.width / 2 + 390, UIStyle.height / 2 - 118, Color.decode("#6CA6CD"), Color.black, "Generated Graphic", 170, 45, "normal", true);
        testPanel.add(gene);

        String[] listData = new String[]{"", "Temperature", "Humidity", "Brightness", "State of Door&Window"};
        JComboBox<String> comboBox = new JComboBox<String>(listData);
        comboBox.setBounds(625, UIStyle.height / 2 - 147, 150, 25);
        testPanel.add(comboBox);


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

                // TODO Auto-generated method stub
                try
                {
                    Date from = sdf.parse(infrom.getText().trim());
                    Date to = sdf.parse(into.getText().trim());
                    Timestamp fromtime = new Timestamp(from.getTime());
                    Timestamp totime = new Timestamp(to.getTime());
                    if (id.getText().isEmpty() || infrom.getText().isEmpty() || into.getText().isEmpty() || val.getText().isEmpty())
                    {
                        remind.WRONG("Please fill in the blank.");
                    } else if (comboBox.getSelectedIndex() == 0)
                    {
                        remind.WRONG("Please choose a data type.");
                    } else if (from.after(to)||from==to)
                    {
                        remind.WRONG("Please choose a right period of time.");

                    } else
                    {
                        //get data from db:more than number in that period of this equipment
                        //test data
                        String type = comboBox.getSelectedItem().toString();
                        String value = val.getText();
                        int more = query.queryequipmentdatamore(Integer.parseInt(id.getText().trim()), fromtime, totime, Double.parseDouble(val.getText().trim()),type);

                        int equal = query.queryequipmentdataequal(Integer.parseInt(id.getText().trim()), fromtime, totime, Double.parseDouble(val.getText().trim()),type);

                        int less = query.queryequipmentdataless(Integer.parseInt(id.getText().trim()), fromtime, totime, Double.parseDouble(val.getText().trim()),type);


                        ScopeChart bar = new ScopeChart(type, value, more, equal, less);


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
        jf.add(testPanel);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);


    }

    public static void main(String[] args)
    {
        DataScope l = new DataScope();
        l.run();
    }

}
