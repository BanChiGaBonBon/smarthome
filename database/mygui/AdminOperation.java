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
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TextButton;
import UIComponent.UIStyle;

public class AdminOperation {
	

	public void run() {
		new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
		JLayeredPane testPanel=new JLayeredPane();
		testPanel.setLayout(null);
        
		JLabel picture = new Picture("./imgs/china2.jpg", UIStyle.width, UIStyle.height-UIStyle.barHeight);
		picture.setBounds(0, UIStyle.barHeight, UIStyle.width, UIStyle.height-UIStyle.barHeight);
		testPanel.add(picture,new Integer(Integer.MIN_VALUE));
		
		JLabel icon1 = new Picture("./imgs/ID Card_2.png", 70,70);
		icon1.setBounds(55, UIStyle.height/2-80, 70, 70);
		testPanel.add(icon1,new Integer(Integer.MAX_VALUE));
		
		JLabel icon2 = new Picture("./imgs/Home.png", 70,70);
		icon2.setBounds(255, UIStyle.height/2-80, 67, 67);
		testPanel.add(icon2,new Integer(Integer.MAX_VALUE));
		
		JLabel icon3 = new Picture("./imgs/Desktop unlocked.png", 70,70);
		icon3.setBounds(460, UIStyle.height/2-80, 67, 67);
		testPanel.add(icon3,new Integer(Integer.MAX_VALUE));
		
		JLabel icon4 = new Picture("./imgs/Password enter.png", 70,70);
		icon4.setBounds(655, UIStyle.height/2-77, 65, 65);
		testPanel.add(icon4,new Integer(Integer.MAX_VALUE));
		
		JLabel icon5 = new Picture("./imgs/Password check.png", 70,70);
		icon5.setBounds(855, UIStyle.height/2-84, 67, 72);
		testPanel.add(icon5,new Integer(Integer.MAX_VALUE));

		
		jf.add(testPanel);
      
		Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
        Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);
        
        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        
        TextButton quit = new TextButton(UIStyle.width -30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);
        
        TextButton mini = new TextButton(UIStyle.width -70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);
        
        DynamicText top=new DynamicText(UIStyle.width / 2/2+50,UIStyle.height / 2-200,"mid",Color.decode("#58606A"),Color.BLACK,"Administrator Operation", 400,100, BIG_FONT);
        testPanel.add(top);	
        
        TextButton a = new TextButton(UIStyle.width / 2-400, UIStyle.height / 2+50, Color.decode("#ACC7F1"), Color.black, "User Management", 170, 120, "mid", true);
        TextButton b = new TextButton(UIStyle.width / 2-200, UIStyle.height / 2+50, Color.decode("#ACC7F1"), Color.black, "Family Management", 170, 120, "mid", true);
        TextButton c = new TextButton(UIStyle.width / 2, UIStyle.height / 2+50, Color.decode("#ACC7F1"), Color.black, "Hardware Management", 170, 120, "mid", true);
        TextButton d = new TextButton(UIStyle.width / 2+200, UIStyle.height / 2+50, Color.decode("#ACC7F1"), Color.black, "Category Management", 170, 120, "mid", true);
        TextButton e = new TextButton(UIStyle.width / 2+400, UIStyle.height / 2+50, Color.decode("#ACC7F1"), Color.black, "Data Management", 170, 120, "mid", true);
        testPanel.add(a);
        testPanel.add(b);
        testPanel.add(c);
        testPanel.add(d);
        testPanel.add(e);
        
        quit.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        	
        });
        
        mini.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				jf.setExtendedState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        	
        });
        
        a.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				mygui.UserMag l = new mygui.UserMag();
				l.run();
				jf.setVisible(false);
			}
        	
        });
		b.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				FamilyMag l = new FamilyMag();
				l.run();
				jf.setVisible(false);
			}

		});

		c.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				EquipMag l = new EquipMag();
				l.run();
				jf.setVisible(false);
			}

		});

		d.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				TypeMag l = new TypeMag();
				l.run();
				jf.setVisible(false);
			}

		});

		e.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				DataStatis l = new DataStatis();
				l.run();
				jf.setVisible(false);
			}

		});
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		AdminOperation l = new AdminOperation();
		l.run();
	}
	

	

}
