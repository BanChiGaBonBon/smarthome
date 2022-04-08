package mygui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import UIComponent.DynamicText;
import UIComponent.InputText;
import UIComponent.MenuBar;
import UIComponent.MyLabelComponent;
import UIComponent.MyReminder;
import UIComponent.Password;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TextButton;
import UIComponent.UIStyle;

public class ManuOperation
{


    public int manuid;



    public ManuOperation(int manuid)
    {
        this.manuid = manuid;

    }

    public void run()
    {
    	new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
		JLayeredPane testPanel=new JLayeredPane();
		testPanel.setLayout(null);
        
		JLabel picture = new Picture("./imgs/china5.jpg", UIStyle.width, UIStyle.height-UIStyle.barHeight);
		picture.setBounds(0, UIStyle.barHeight, UIStyle.width, UIStyle.height-UIStyle.barHeight);
		testPanel.add(picture,new Integer(Integer.MIN_VALUE));

		
		jf.add(testPanel);
		
		JLabel icon3 = new Picture("./imgs/Desktop unlocked.png", 70,70);
		icon3.setBounds(210, UIStyle.height/2-80, 67, 67);
		testPanel.add(icon3,new Integer(Integer.MAX_VALUE));
		
		JLabel icon5 = new Picture("./imgs/Password check.png", 70,70);
		icon5.setBounds(705, UIStyle.height/2-84, 67, 72);
		testPanel.add(icon5,new Integer(Integer.MAX_VALUE));

        Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
        Font NORBIG_FONT = new Font("Arial", Font.PLAIN, 24);
        Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);

        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);

        TextButton quit = new TextButton(UIStyle.width - 30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);

        TextButton mini = new TextButton(UIStyle.width - 70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);

        DynamicText top = new DynamicText(UIStyle.width / 2 / 2 + 50, UIStyle.height / 2 - 200, "mid", Color.decode("#58606A"), Color.BLACK, "Manufacturer Operation", 400, 100, BIG_FONT);
        testPanel.add(top);

        TextButton a = new TextButton(UIStyle.width / 2 - 250, UIStyle.height / 2+50, Color.decode("#ACC7F1"), Color.black, "HardWare Management", 220, 120, "normal", true);
        TextButton b = new TextButton(UIStyle.width / 2 + 250, UIStyle.height / 2+50, Color.decode("#ACC7F1"), Color.black, "Data Management", 220, 120, "normal", true);

        testPanel.add(a);
        testPanel.add(b);


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

        a.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                // TODO Auto-generated method stub
                ManuEquip l = new ManuEquip(manuid);
                l.run();
                jf.setVisible(false);
            }

        });

        b.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {
                // TODO Auto-generated method stub
                ManuStatis l = new ManuStatis(manuid);
                l.run();
                jf.setVisible(false);
            }

        });


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);


    }

    public static void main(String[] args)
    {
        ManuOperation l = new ManuOperation(30001);
        l.run();
    }


}
