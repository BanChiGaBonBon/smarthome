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
import UIComponent.InputArea;
import UIComponent.InputText;
import UIComponent.MyReminder;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TextButton;
import UIComponent.UIStyle;
import administrator.update;

public class Resetpass
{

    public Resetpass(String a, String b, String c, String d)
    {
        run(a, b, c, d);
    }


    public void run(String column1, String column2, String column3, String column4)
    {
    	new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2+50), (int)(UIStyle.ScreenHeight - UIStyle.height)/2+70, (int) UIStyle.width-100, (int) UIStyle.height-100);

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

        DynamicText top = new DynamicText(UIStyle.width / 2 / 2 - 2, UIStyle.height / 2 - 250, "mid", Color.decode("#58606A"), Color.BLACK, "Reset Password", 400, 100, BIG_FONT);
        testPanel.add(top);

        DynamicText before = new DynamicText(UIStyle.width / 2 / 2 - 220, UIStyle.height / 2 - 200, "mid", Color.decode("#58606A"), Color.BLACK, "Prime Information", 400, 100, NORMAL_FONT);
        testPanel.add(before);

        DynamicText after = new DynamicText(UIStyle.width / 2 / 2 + 220, UIStyle.height / 2 - 200, "mid", Color.decode("#58606A"), Color.BLACK, "New Password", 400, 100, NORMAL_FONT);
        testPanel.add(after);

        DynamicText id = new DynamicText(10, UIStyle.height / 2 / 2, "right", Color.decode("#58606A"), Color.BLACK, "User ID:", 100, 100, SMALL_FONT);
        testPanel.add(id);
        //InputText in=new InputText(80,UIStyle.height / 2/2+10,200,25, 11, false, "");
        InputText a = new InputText(200, 25, 11, true, UIStyle.width / 2 / 2 - 20, UIStyle.height / 2 / 2 + 50, "", true);
        a.setText(column1);
        a.setEditable(false);
        testPanel.add(a);

        DynamicText name = new DynamicText(10, UIStyle.height / 2 / 2 + 60, "right", Color.decode("#58606A"), Color.BLACK, "User Name:", 100, 100, SMALL_FONT);
        testPanel.add(name);
        InputText b = new InputText(200, 25, 11, true, UIStyle.width / 2 / 2 - 20, UIStyle.height / 2 / 2 + 110, "", true);
        b.setText(column2);
        b.setEditable(false);
        testPanel.add(b);

        DynamicText pass = new DynamicText(10, UIStyle.height / 2 / 2 + 120, "right", Color.decode("#58606A"), Color.BLACK, "Password:", 100, 100, SMALL_FONT);
        testPanel.add(pass);
        InputText c = new InputText(200, 25, 11, true, UIStyle.width / 2 / 2 - 20, UIStyle.height / 2 / 2 + 170, "", true);
        c.setText(column3);
        c.setEditable(false);
        testPanel.add(c);

        DynamicText family = new DynamicText(10, UIStyle.height / 2 / 2 + 180, "right", Color.decode("#58606A"), Color.BLACK, "Family ID:", 100, 100, SMALL_FONT);
        testPanel.add(family);
        InputText d = new InputText(200, 25, 11, true, UIStyle.width / 2 / 2 - 20, UIStyle.height / 2 / 2 + 230, "", true);
        d.setText(column4);
        d.setEditable(false);
        testPanel.add(d);

        InputArea demo = new InputArea(UIStyle.width / 2 - 150, 210, true, UIStyle.width / 2 + 180, UIStyle.height / 2 - 10, "                    Demonstrate Area", true);
        testPanel.add(demo);
//	      JScrollPane roll=new JScrollPane(demo);
//	      roll.setBounds(UIStyle.width / 2-20,UIStyle.height/2-140, UIStyle.width/2,UIStyle.height/2+18);
        //jf.getContentPane().add(roll);
        // jf.getContentPane().add(testPanel);
        demo.setEditable(false);
        demo.setLineWrap(true);


        TextButton reset = new TextButton(UIStyle.width / 2 - 50, UIStyle.height / 2 + 150, Color.decode("#6CA6CD"), Color.black, "Reset", 100, 30, "normal", true);
        testPanel.add(reset);


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

        reset.addMouseListener(new MouseAdapter()
        {

            @Override
            public void mouseClicked(MouseEvent e)
            {


				String s=update.resetuserpassword(Integer.parseInt(column1.trim()));
                remind.OK("Successfully Reset");
                //change the data in db
                demo.setText("New Password:"+s+"(which will be encoded in the database)");

            }
        });


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);


    }


}



