package mygui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import UIComponent.DynamicText;
import UIComponent.InputText;
import UIComponent.MyReminder;
import UIComponent.ReminderTool;
import UIComponent.TableList;
import UIComponent.TextButton;
import UIComponent.UIStyle;

public class DataQuery {
	public void run() {
		new UIStyle();
		Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);
        Font SMALL_FONT = new Font("Arial", Font.PLAIN, 16);
        Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
		JPanel testPanel = new JPanel();
        testPanel.setLayout(null);
        jf.add(testPanel);
        
        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        MyReminder remind=new MyReminder(tool);
        
        DynamicText top=new DynamicText(UIStyle.width / 2/2+50,UIStyle.height / 2-250,"mid",Color.decode("#58606A"),Color.BLACK,"Query Data", 400,100, BIG_FONT);
        testPanel.add(top);	
        
        TextButton quit = new TextButton(UIStyle.width -30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);
        
        TextButton mini = new TextButton(UIStyle.width -70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);
        
        TextButton back = new TextButton(30, 30, Color.decode("#58606A"), Color.black, "BACK", 30, 30, "tiny", true);
        tool.add(back);
        
        DynamicText type=new DynamicText(20,UIStyle.height / 2-183,"mid",Color.decode("#58606A"),Color.BLACK,"search type : ", 100,95, SMALL_FONT);
        testPanel.add(type);	
        DynamicText time=new DynamicText(20,UIStyle.height / 2-150,"mid",Color.decode("#58606A"),Color.BLACK,"search time : ", 100,95, SMALL_FONT);
        testPanel.add(time);
        
        DynamicText from=new DynamicText(100,UIStyle.height / 2-150,"mid",Color.decode("#58606A"),Color.BLACK,"from : ", 100,95, SMALL_FONT);
        testPanel.add(from);
        DynamicText to=new DynamicText(300,UIStyle.height / 2-150,"mid",Color.decode("#58606A"),Color.BLACK,"to : ", 100,95, SMALL_FONT);
        testPanel.add(to);
        
        //InputText in=new InputText(420,UIStyle.height / 2/2,200,30, 11, false, "");
        InputText in=new InputText(200,50, 11,false,UIStyle.width-300,UIStyle.height / 2-115,"", true);
        testPanel.add(in);
        
        InputText infrom=new InputText(180,UIStyle.height / 2/2+35,150,25, 11, false, "");
        testPanel.add(infrom);
        InputText into=new InputText(370,UIStyle.height / 2/2+35,150,25, 11, false, "");
        testPanel.add(into);
        
        TextButton find = new TextButton(UIStyle.width/2+380, UIStyle.height / 2-118, Color.decode("#6CA6CD"), Color.black, "Search", 100, 45, "normal", true);
        testPanel.add(find);
        
        JRadioButton a = new JRadioButton("Equipment ID");
        a.setBounds(120, 155, 130, 20);
        a.setContentAreaFilled(false); 
        a.setFocusPainted(false);
        JRadioButton b = new JRadioButton("Equipment Type");
        b.setBounds(270, 155, 130, 20);
        b.setContentAreaFilled(false); 
        b.setFocusPainted(false);
        JRadioButton c = new JRadioButton("Family ID");
        c.setBounds(440, 155, 130, 20);
        c.setContentAreaFilled(false); 
        c.setFocusPainted(false);
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(a);
        btnGroup.add(b);
        btnGroup.add(c);
        testPanel.add(a);
        testPanel.add(b);
        testPanel.add(c);
        
        String[] attribute={"Temperature", "Humidity", "Brightness", "State of Door&Window","Measuring Time"};
        // String[][] value= new String[][]{{"0001","Joy","0003","@123"},{"0002","Joe","0002","@143"}};
         String[][] value= new String[][] {{"","","","",""}};
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
				DataMag l=new DataMag();
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
        
        find.addMouseListener(new MouseAdapter() {

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				
				// TODO Auto-generated method stub
 				if (in.getText().isEmpty()||infrom.getText().isEmpty()||into.getText().isEmpty()) {
 					remind.WRONG("Please fill in the blank.");
 				}
 				else if(!a.isSelected()&&!b.isSelected()&&!c.isSelected())
 				{
 					remind.WRONG("Please choose a search type.");
 				}
 				else if (a.isSelected())
 				{
 					//search by ID and time in db
 					String[][] v= new String[][] {{"321","321","321","321","666"},{"321","321","321","777","888"}};//change to set in db
 			        TableList t= new TableList(attribute,v, Color.BLACK, Color.WHITE, Color.decode("#F0F8FF"), UIStyle.width/2-485, UIStyle.height/2/2, UIStyle.width-10,UIStyle.height/2);
 			        JScrollPane s = new JScrollPane();   
 			        scrollPane.setPreferredSize(new Dimension(0, 350));
 			        
 			        scrollPane.setViewportView(t);
 			        jf.getContentPane().add(s,BorderLayout.SOUTH);
 					
 				}
 				else if (b.isSelected())
 				{
 					//search by type and time in db
 					String[][] v= new String[][] {{"321","321","321","321","888"},{"321","321","321","777","000"}};
 			        TableList t= new TableList(attribute,v, Color.BLACK, Color.WHITE, Color.decode("#F0F8FF"), UIStyle.width/2-485, UIStyle.height/2/2, UIStyle.width-10,UIStyle.height/2);
 			        JScrollPane s = new JScrollPane();   
 			        scrollPane.setPreferredSize(new Dimension(0, 350));
 			        
 			        scrollPane.setViewportView(t);
 			        jf.getContentPane().add(s,BorderLayout.SOUTH);
 					
 				}
 				else if (c.isSelected())
 				{
 					//search by family id and time in db
 					String[][] v= new String[][] {{"321","321","321","666","212"},{"321","321","321","777","231"}};
 			        TableList t= new TableList(attribute,v, Color.BLACK, Color.WHITE, Color.decode("#F0F8FF"), UIStyle.width/2-485, UIStyle.height/2/2, UIStyle.width-10,UIStyle.height/2);
 			        JScrollPane s = new JScrollPane();   
 			        scrollPane.setPreferredSize(new Dimension(0, 350));
 			        
 			        scrollPane.setViewportView(t);
 			        jf.getContentPane().add(s,BorderLayout.SOUTH);
 					
 				}
 				
 				}
});
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		DataQuery l = new DataQuery();
		l.run();
	}
	
}
