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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import UIComponent.DynamicText;
import UIComponent.InputText;
import UIComponent.MyReminder;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TableList;
import UIComponent.TextButton;
import UIComponent.UIStyle;
import administrator.query;

public class TypeMod {
	

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
        Font SMALL_FONT = new Font("Arial", Font.PLAIN, 16);
        
        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        MyReminder remind=new MyReminder(tool);
        
        TextButton quit = new TextButton(UIStyle.width -30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);
        
        TextButton mini = new TextButton(UIStyle.width -70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);
        
        TextButton back = new TextButton(30, 30, Color.decode("#58606A"), Color.black, "BACK", 30, 30, "tiny", true);
        tool.add(back);
        
        DynamicText top=new DynamicText(UIStyle.width / 2/2+50,UIStyle.height / 2-250,"mid",Color.decode("#58606A"),Color.BLACK,"Modify Category", 400,100, BIG_FONT);
        testPanel.add(top);	
        

        
        DynamicText type=new DynamicText(160,UIStyle.height / 2-183,"mid",Color.decode("#58606A"),Color.BLACK,"Please enter type name : ", 250,95, SMALL_FONT);
        testPanel.add(type);	
        
        InputText in=new InputText(397,UIStyle.height / 2/2,200,30, 11, false, "");
        testPanel.add(in);
        
        
        TextButton find = new TextButton(UIStyle.width/2+200, UIStyle.height / 2-136, Color.decode("#6CA6CD"), Color.black, "Search", 100, 30, "normal", true);
        testPanel.add(find);
        
        TextButton mod = new TextButton(UIStyle.width/2+330, UIStyle.height / 2-136, Color.decode("#EE6363"), Color.black, "Modify", 100, 30, "normal", true);
        testPanel.add(mod);
        
        
        
        
        
        String[] attribute={"Equipment Type"};
       // String[][] value= new String[][]{{"0001","Joy","0003","@123"},{"0002","Joe","0002","@143"}};
        String[][] value= new String[][] {{""}};
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
				TypeMag l=new TypeMag();
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
 				if (in.getText().isEmpty()) {
 					remind.WRONG("Please fill in the blank.");
 				}
 				else 
 				{
 					//search by ID in db
 					String[][] v= query.querytype(in.getText().trim());
 			        DefaultTableModel model = new DefaultTableModel(v,attribute);
 			       TableList t= new TableList(model, Color.BLACK, Color.WHITE, Color.decode("#F0F8FF"), UIStyle.width/2-485, UIStyle.height/2/2, UIStyle.width-10,UIStyle.height/2);
 			        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 			        JScrollPane s = new JScrollPane();   
 			        scrollPane.setPreferredSize(new Dimension(0, 350));
 			        
 			        scrollPane.setViewportView(t);
 			        jf.getContentPane().add(s,BorderLayout.SOUTH);
 			        
  			       mod.addMouseListener(new MouseAdapter() {

  			 			@Override
  			 			public void mouseClicked(MouseEvent e) {
  			 				
  							// TODO Auto-generated method stub
  			 				int rowIndex=t.getSelectedRow();

  			 				
  			 				if (rowIndex==-1) {
  			 					remind.WRONG("Please choose an object.");
  			 				}
  			 				else 
  			 				{
  	  			 				String getid=t.getValueAt(rowIndex, 0).toString();
  			 						TypeModify u=new TypeModify(getid); 					
  			 			   			 					
			
  			 				}
  			 				
  			 				
  			 				}
  			});
 			        
 			        
 					
 				}
 				

 				
 				
 				}
});
        
                

        
        
        

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		TypeMod l = new TypeMod();
		l.run();
	}

	

	

}


