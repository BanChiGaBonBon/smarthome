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
import java.util.Random;

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
import manufacturer.query;
import chart.DistributionChart;

public class ManuDistribution
{
	public int manuid;
	public ManuDistribution(int manuid)
	{
		this.manuid=manuid;
	}
    public void run()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Random r = new Random();
        Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);
        Font SMALL_FONT = new Font("Arial", Font.PLAIN, 16);
        Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
        new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
		JLayeredPane testPanel=new JLayeredPane();
		testPanel.setLayout(null);
        
		JLabel picture = new Picture("./imgs/china5.jpg", UIStyle.width, UIStyle.height-UIStyle.barHeight);
		picture.setBounds(0, UIStyle.barHeight, UIStyle.width, UIStyle.height-UIStyle.barHeight);
		testPanel.add(picture,new Integer(Integer.MIN_VALUE));

		
		jf.add(testPanel);

        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        MyReminder remind = new MyReminder(tool);

        DynamicText top = new DynamicText(UIStyle.width / 2 / 2 + 50, UIStyle.height / 2 - 250, "mid", Color.decode("#58606A"), Color.BLACK, "Distribution Statistics", 400, 100, BIG_FONT);
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
        DynamicText type = new DynamicText(26, UIStyle.height / 2 - 117, "mid", Color.decode("#58606A"), Color.BLACK, "Data Type : ", 120, 95, SMALL_FONT);
        testPanel.add(type);


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


        TextButton gene = new TextButton(UIStyle.width / 2 + 250, UIStyle.height / 2 - 118, Color.decode("#6CA6CD"), Color.black, "Generated Graphic", 170, 45, "normal", true);
        testPanel.add(gene);

        String[] listData = new String[]{"", "Temperature", "Humidity", "Brightness", "State of Door&Window"};
        JComboBox<String> comboBox = new JComboBox<String>(listData);
        comboBox.setBounds(180, UIStyle.height / 2 - 83, 150, 25);
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
                ManuStatis l = new ManuStatis(manuid);
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
                    Timestamp totime = new Timestamp(to.getTime());
                    // TODO Auto-generated method stub
                    if (id.getText().isEmpty() || infrom.getText().isEmpty() || into.getText().isEmpty())
                    {
                        remind.WRONG("Please fill in the blank.");
                    } else if (comboBox.getSelectedIndex() == 0)
                    {
                        remind.WRONG("Please choose a data type.");
                    } else if (from.after(to) || from == to)
                    {
                        remind.WRONG("Please choose a right period of time.");

                    } else
                    {
                        //generate statistic graphic
                        //get the number in different interval from db
                        //test data
                        if (comboBox.getSelectedIndex() == 1)
                        {
                            float min = 0.0f, max = 45.5f;
                            int a = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 0.0f, 9.1f, "Temperature",manuid);
                            int b = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 9.1f, 18.2f, "Temperature",manuid);
                            int c = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 18.2f, 27.3f, "Temperature",manuid);
                            int d = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 27.3f, 36.4f, "Temperature",manuid);
                            int x = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 36.4f, 45.5f, "Temperature",manuid);
                            String type = comboBox.getSelectedItem().toString();

                            DistributionChart pie = new DistributionChart(type, min, max, a, b, c, d, x);
                            new UIStyle();
                            JFrame f = new JFrame();
                            f.setBounds((int) ((UIStyle.ScreenWidth - UIStyle.width) / 2 + 130), (int) (UIStyle.ScreenHeight - UIStyle.height) / 2 + 100, (int) UIStyle.width / 2, (int) UIStyle.height / 2);

                            f.add(pie.getChartPanel());
                            f.pack();
                            f.setVisible(true);

                        } else if (comboBox.getSelectedIndex() == 2)
                        {
                            float min = 0.0f, max = 100f;
                            int a = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 0.0f, 20.0f, "Humidity",manuid);
                            int b = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 20.0f, 40.0f, "Humidity",manuid);
                            int c = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 40.0f, 60.0f, "Humidity",manuid);
                            int d = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 60.0f, 80.0f, "Humidity",manuid);
                            int x = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 80.0f, 100.0f, "Humidity",manuid);
                            String type = comboBox.getSelectedItem().toString();

                            DistributionChart pie = new DistributionChart(type, min, max, a, b, c, d, x);
                            new UIStyle();
                            JFrame f = new JFrame();
                            f.setBounds((int) ((UIStyle.ScreenWidth - UIStyle.width) / 2 + 130), (int) (UIStyle.ScreenHeight - UIStyle.height) / 2 + 100, (int) UIStyle.width / 2, (int) UIStyle.height / 2);

                            f.add(pie.getChartPanel());
                            f.pack();
                            f.setVisible(true);

                        } else if (comboBox.getSelectedIndex() == 3)
                        {
                            float min = 25f, max = 300f;

                            String type = comboBox.getSelectedItem().toString();
                            int a = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 0.0f, 80.0f, "Brightness",manuid);
                            int b = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 80.0f, 135.0f, "Brightness",manuid);
                            int c = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 135.0f, 190.0f, "Brightness",manuid);
                            int d = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 190.0f, 245.0f, "Brightness",manuid);
                            int x = query.queryequipmentdatascope(Integer.parseInt(id.getText().trim()), fromtime, totime, 245.0f, 300.0f, "Brightness",manuid);

                            DistributionChart pie = new DistributionChart(type, min, max, a, b, c, d, x);
                            new UIStyle();
                            JFrame f = new JFrame();
                            f.setBounds((int) ((UIStyle.ScreenWidth - UIStyle.width) / 2 + 130), (int) (UIStyle.ScreenHeight - UIStyle.height) / 2 + 100, (int) UIStyle.width / 2, (int) UIStyle.height / 2);

                            f.add(pie.getChartPanel());
                            f.pack();
                            f.setVisible(true);

                        } else if (comboBox.getSelectedIndex() == 4)
                        {


                            String type = comboBox.getSelectedItem().toString();
                            int onvalue = query.queryequipmentdataequal(Integer.parseInt(id.getText().trim()), fromtime, totime, 0, "State of Door&Window",manuid);
                            int offvalue = query.queryequipmentdataequal(Integer.parseInt(id.getText().trim()), fromtime, totime, 1, "State of Door&Window",manuid);

                            DistributionChart pie = new DistributionChart(type, onvalue, offvalue);
                            new UIStyle();
                            JFrame f = new JFrame();
                            f.setBounds((int) ((UIStyle.ScreenWidth - UIStyle.width) / 2 + 130), (int) (UIStyle.ScreenHeight - UIStyle.height) / 2 + 100, (int) UIStyle.width / 2, (int) UIStyle.height / 2);

                            f.add(pie.getChartPanel());
                            f.pack();
                            f.setVisible(true);

                        }
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
        ManuDistribution l = new ManuDistribution(300001);
        l.run();
    }

}
