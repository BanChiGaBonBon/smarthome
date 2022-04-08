package mygui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import UIComponent.DynamicText;
import UIComponent.InputText;
import UIComponent.MyReminder;
import UIComponent.Password;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TextButton;
import UIComponent.UIStyle;
import administrator.login;

public class AdminLogin
{


    public void run()
    {
    	new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
		JLayeredPane testPanel=new JLayeredPane();
		testPanel.setLayout(null);
        
		JLabel picture = new Picture("./imgs/china2.jpg", UIStyle.width, UIStyle.height-UIStyle.barHeight);
		picture.setBounds(0, UIStyle.barHeight, UIStyle.width, UIStyle.height-UIStyle.barHeight);
		testPanel.add(picture,new Integer(Integer.MIN_VALUE));
		
		JLabel icon1 = new Picture("./imgs/User locked.png", 30,30);
		icon1.setBounds(UIStyle.width/2-175, UIStyle.height/2-66, 25, 25);
		testPanel.add(icon1,new Integer(Integer.MAX_VALUE));
		
		JLabel icon2 = new Picture("./imgs/Lock.png", 30,30);
		icon2.setBounds(UIStyle.width/2-175, UIStyle.height/2+15, 25, 25);
		testPanel.add(icon2,new Integer(Integer.MAX_VALUE));
		
		jf.add(testPanel);

        //MyLabelComponent id =new MyLabelComponent(100,100,100,100,"ID",Color.decode("#58606A"),Color.decode("#58606A"),"mid");
        Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
        Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);
        DynamicText id = new DynamicText(UIStyle.width / 2 - 160, UIStyle.height / 2 - 100, "right", Color.decode("#58606A"), Color.BLACK, "Admin ID:", 100, 100, NORMAL_FONT);
        testPanel.add(id);
        DynamicText pass = new DynamicText(UIStyle.width / 2 - 160, UIStyle.height / 2 - 20, "right", Color.decode("#58606A"), Color.BLACK, "Password:", 100, 100, NORMAL_FONT);
        testPanel.add(pass);

        DynamicText top = new DynamicText(UIStyle.width / 2 / 2 + 50, UIStyle.height / 2 - 200, "mid", Color.decode("#58606A"), Color.BLACK, "Administator Login", 400, 100, BIG_FONT);
        testPanel.add(top);

        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        MyReminder remind = new MyReminder(tool);

        Password ps = new Password(UIStyle.width / 2 + 45, UIStyle.height / 2 + 30, 200, 30);
        testPanel.add(ps);

        InputText in = new InputText(UIStyle.width / 2 - 55, UIStyle.height / 2 - 65, 200, 30, 11, false, "");
        testPanel.add(in);

        TextButton quit = new TextButton(UIStyle.width - 30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);

        TextButton mini = new TextButton(UIStyle.width - 70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);

        TextButton back = new TextButton(30, 30, Color.decode("#58606A"), Color.black, "BACK", 30, 30, "tiny", true);
        tool.add(back);

        TextButton log = new TextButton(UIStyle.width / 2, UIStyle.height / 2 + 120, Color.decode("#6CA6CD"), Color.black, "Login", 100, 40, "normal", true);
        testPanel.add(log);

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
                mygui.Login l = new mygui.Login();
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

        log.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                // TODO Auto-generated method stub
                //remind.OK("Login");

                if (ps.getText().isEmpty() || ps.getText().equals("Password") || in.getText().equals(""))
                {
                    remind.WRONG("Please fill in the blank");
                } else
                {

                    if (login.loginin(Integer.parseInt(in.getText()), ps.getText()) == 1)
                    {
                        remind.OK("Login");
                        mygui.AdminOperation l = new mygui.AdminOperation();
                        l.run();
                        jf.setVisible(false);
                    } else
                    {
                        remind.WRONG("login failed");
                        ps.setText("Password");
                        in.setText("");

                    }
                }
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


            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                // TODO Auto-generated method stub
                //if (match db)
                //ReminderPanel suc=new ReminderPanel(testPanel);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                // TODO Auto-generated method stub

            }


        });


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);


    }

    public static void main(String[] args)
    {
        AdminLogin l = new AdminLogin();
        l.run();
    }


}
