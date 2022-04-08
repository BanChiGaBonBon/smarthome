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
import javax.swing.JScrollPane;

import UIComponent.DynamicText;
import UIComponent.InputArea;
import UIComponent.InputText;
import UIComponent.MyReminder;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TextButton;
import UIComponent.UIStyle;
import administrator.query;
import administrator.update;

public class TypeAdd {
	

	public void run() {
		new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2), (int)(UIStyle.ScreenHeight - UIStyle.height)/2, (int) UIStyle.width, (int) UIStyle.height);
		JLayeredPane testPanel=new JLayeredPane();
		testPanel.setLayout(null);
        
		JLabel picture = new Picture("./imgs/china2.jpg", UIStyle.width, UIStyle.height-UIStyle.barHeight);
		picture.setBounds(0, UIStyle.barHeight, UIStyle.width, UIStyle.height-UIStyle.barHeight);
		testPanel.add(picture,new Integer(Integer.MIN_VALUE));

		
		jf.add(testPanel);
      
        Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
        Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);
        
        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        MyReminder remind=new MyReminder(tool);
        
        TextButton quit = new TextButton(UIStyle.width -30, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);
        
        TextButton mini = new TextButton(UIStyle.width -70, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);
        
        TextButton back = new TextButton(30, 30, Color.decode("#58606A"), Color.black, "BACK", 30, 30, "tiny", true);
        tool.add(back);
        
        DynamicText top=new DynamicText(UIStyle.width / 2/2+50,UIStyle.height / 2-250,"mid",Color.decode("#58606A"),Color.BLACK,"Add Family", 400,100, BIG_FONT);
        testPanel.add(top);	
        
        DynamicText type=new DynamicText(10,UIStyle.height / 2/2+80,"right",Color.decode("#58606A"),Color.BLACK,"Equipment Type:", 150,100, NORMAL_FONT);
        testPanel.add(type);
        //InputText in=new InputText(80,UIStyle.height / 2/2+10,200,25, 11, false, "");
        InputText a=new InputText(200,25,11,true,UIStyle.width/2/2+40,UIStyle.height / 2/2+130,  "",true);
        testPanel.add(a);
        

        
        
        
        TextButton ok = new TextButton(UIStyle.width / 2-80, UIStyle.height -70, Color.decode("#6CA6CD"), Color.black, "Confirm", 100, 40, "normal", true);
        testPanel.add(ok);
        
        TextButton reset = new TextButton(UIStyle.width / 2+80, UIStyle.height -70, Color.decode("#6CA6CD"), Color.black, "Clear", 100, 40, "normal", true);
        testPanel.add(reset);
        
        
	      InputArea demo=new InputArea(UIStyle.width/2-100,330,true,UIStyle.width / 2+250,UIStyle.height / 2+18,"	        Demonstrate Area", true);
	      testPanel.add(demo);
	      JScrollPane roll=new JScrollPane(demo);
	      roll.setBounds(UIStyle.width / 2-20,UIStyle.height/2-140, UIStyle.width/2,UIStyle.height/2+18);
                jf.getContentPane().add(roll);
                jf.getContentPane().add(testPanel);
	      demo.setEditable(false);
	      demo.setLineWrap(true);
        reset.addMouseListener(new MouseAdapter() {

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				// TODO Auto-generated method stub
 				a.setText("");		
 				
 				}
});
        
        ok.addMouseListener(new MouseAdapter() {

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				// TODO Auto-generated method stub
 				if (a.getText().trim().isEmpty()) {
 					remind.WRONG("Please fill in the blank.");
 				}
 				else if (query.searchtype(a.getText().trim())==1)//check if there's duplicate ID in db
 				{
 					remind.WRONG("Duplicate equipment_type");
 				}
 				else
 				{
					int i = update.inserttype(a.getText().trim());

					if (i == 1)
					{
						remind.OK("Successfully added!");
						demo.append("\n\n");
						demo.append("          equipment_type: " + a.getText().trim() + "\n");

					} else
					{
						remind.WRONG("add user failed");
						a.setText("");

					}
 	
 					
 				}
 				
 				}
});
        
        
        
        



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
				TypeMag l = new TypeMag();
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
        

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		TypeAdd l = new TypeAdd();
		l.run();
	}
	

	

}


