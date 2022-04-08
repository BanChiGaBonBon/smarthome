package mygui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import UIComponent.*;

public class Login
{

    public void run()
    {
        Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);
        new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
		JLayeredPane testPanel=new JLayeredPane();
		testPanel.setLayout(null);
        
		JLabel picture = new Picture("./imgs/china10.jpg", UIStyle.width, UIStyle.height-UIStyle.barHeight);
		picture.setBounds(0, UIStyle.barHeight, UIStyle.width, UIStyle.height-UIStyle.barHeight);
		testPanel.add(picture,new Integer(Integer.MIN_VALUE));
		
		jf.add(testPanel);

        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);

        DynamicText top = new DynamicText(UIStyle.width / 2 / 2 + 50, UIStyle.height / 2 - 200, "mid", Color.decode("#58606A"), Color.BLACK, "Choose Your Identity", 400, 100, BIG_FONT);
        testPanel.add(top);

        TextButton manager = new TextButton(UIStyle.width / 2 - 150, UIStyle.height / 2, Color.decode("#6CA6CD"), Color.black, "Administrator", 200, 150, "big", true);
        TextButton enterprise = new TextButton(UIStyle.width / 2 + 150, UIStyle.height / 2, Color.decode("#6CA6CD"), Color.black, "Manufacturer", 200, 150, "big", true);
        testPanel.add(manager);
        testPanel.add(enterprise);

        TextButton quit = new TextButton(UIStyle.width - 30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);

        TextButton mini = new TextButton(UIStyle.width - 70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);
        manager.addMouseListener(new MouseListener()
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
                AdminLogin l = new AdminLogin();
                jf.setVisible(false);
                l.run();
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

        enterprise.addMouseListener(new MouseListener()
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
                mygui.ManuLogin l = new mygui.ManuLogin();
                jf.setVisible(false);
                l.run();
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


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);


    }

    public static void main(String[] args)
    {
        Login l = new Login();
        l.run();
    }


}
