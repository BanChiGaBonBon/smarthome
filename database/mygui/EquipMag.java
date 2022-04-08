package mygui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import UIComponent.DynamicText;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TableList;
import UIComponent.TextButton;
import UIComponent.UIStyle;
import administrator.query;

public class EquipMag {
	

	public void run() {
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
        
        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        
        TextButton quit = new TextButton(UIStyle.width -30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);
        
        TextButton mini = new TextButton(UIStyle.width -70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);
        
        TextButton back = new TextButton(30, 30, Color.decode("#58606A"), Color.black, "BACK", 30, 30, "tiny", true);
        tool.add(back);
        
        DynamicText top=new DynamicText(UIStyle.width / 2/2+50,UIStyle.height / 2-250,"mid",Color.decode("#58606A"),Color.BLACK,"HardWare Management", 400,100, BIG_FONT);
        testPanel.add(top);	
        
        TextButton a = new TextButton(UIStyle.width / 2-360, UIStyle.height / 2-130, Color.decode("#ACC7F1"), Color.black, "Add Information", 170, 50, "mid", true);
        TextButton b = new TextButton(UIStyle.width / 2-120, UIStyle.height / 2-130, Color.decode("#ACC7F1"), Color.black, "Search Information", 170, 50, "mid", true);
        TextButton c = new TextButton(UIStyle.width / 2+120, UIStyle.height / 2-130, Color.decode("#ACC7F1"), Color.black, "Delete Information", 170, 50, "mid", true);
        TextButton d = new TextButton(UIStyle.width / 2+360, UIStyle.height / 2-130, Color.decode("#ACC7F1"), Color.black, "Modify Information", 170, 50, "mid", true);
        testPanel.add(a);
        testPanel.add(b);
        testPanel.add(c);
        testPanel.add(d);
        
//        InputArea demo=new InputArea(UIStyle.width-100,330,true,UIStyle.width / 2,UIStyle.height / 2+100,"No User", false);
//        JScrollPane roll=new JScrollPane(demo);
//        roll.setBounds(UIStyle.width / 2-485,UIStyle.height / 2-70, UIStyle.width-10,350);
//        jf.getContentPane().add(roll);
        
        String[] attribute={"Equipment ID", "Equipment Name", "Equipment introduction", "Equipment type","Manufacturer id","Family id"};
        String[][] value= query.queryequipment();

        TableList table= new TableList(attribute,value, Color.BLACK, Color.WHITE, Color.decode("#F0F8FF"), UIStyle.width/2-485, UIStyle.height/2/2, UIStyle.width-10,UIStyle.height/2);
        JScrollPane scrollPane = new JScrollPane();   
        scrollPane.setPreferredSize(new Dimension(0, 350));
        
        scrollPane.setViewportView(table);
        jf.getContentPane().setLayout(new BorderLayout());
        jf.getContentPane().add(scrollPane,BorderLayout.SOUTH);
        jf.getContentPane().add(testPanel);
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
        
        back.addMouseListener(new MouseListener() {

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
				AdminOperation l=new AdminOperation();
				l.run();
				jf.setVisible(false);
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
				EquipAdd l = new EquipAdd();
				l.run();
				jf.setVisible(false);
			}

        	
        });
        
        b.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				EquipFind l = new EquipFind();
				l.run();
				jf.setVisible(false);
			}

        	
        });
        
        c.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				EquipDel l = new EquipDel();
				l.run();
				jf.setVisible(false);
			}

        	
        });
        
        d.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				EquipMod l = new EquipMod();
				l.run();
				jf.setVisible(false);
			}

        	
        });
        

        
        
        

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		EquipMag l = new EquipMag();
		l.run();
	}
	

	

}

