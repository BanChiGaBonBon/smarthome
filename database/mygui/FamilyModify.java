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
import UIComponent.MyReminder;
import UIComponent.Picture;
import UIComponent.ReminderTool;
import UIComponent.TextButton;
import UIComponent.UIStyle;
import administrator.update;

public class FamilyModify {
	
	public FamilyModify(String a,String b, String c)
	{
		run(a,b,c);
	}
	

	public void run(String column1,String column2,String column3) {
		new UIStyle();
		JFrame jf = new JFrame();
		jf.setBounds((int)((UIStyle.ScreenWidth - UIStyle.width)/2+50), (int)(UIStyle.ScreenHeight - UIStyle.height)/2+70, (int) UIStyle.width-100, (int) UIStyle.height-100);
		JLayeredPane testPanel=new JLayeredPane();
		testPanel.setLayout(null);
        
		JLabel picture = new Picture("./imgs/china2.jpg", UIStyle.width, UIStyle.height-UIStyle.barHeight);
		picture.setBounds(0, UIStyle.barHeight, UIStyle.width, UIStyle.height-UIStyle.barHeight);
		testPanel.add(picture,new Integer(Integer.MIN_VALUE));

		
		jf.add(testPanel);
      
        Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 18);
        Font BIG_FONT = new Font("Arial", Font.PLAIN, 34);
        Font SMALL_FONT = new Font("Arial", Font.PLAIN, 16);
        
        ReminderTool tool = new ReminderTool();
        testPanel.add(tool);
        MyReminder remind=new MyReminder(tool);
        
        TextButton quit = new TextButton(UIStyle.width -130, 30, Color.decode("#58606A"), Color.black, "QUIT", 30, 30, "tiny", true);
        tool.add(quit);
        
        TextButton mini = new TextButton(UIStyle.width -170, 30, Color.decode("#58606A"), Color.black, "MINI", 30, 30, "tiny", true);
        tool.add(mini);
        
        TextButton back = new TextButton(30, 30, Color.decode("#58606A"), Color.black, "BACK", 30, 30, "tiny", true);
        tool.add(back);
        
        DynamicText top=new DynamicText(UIStyle.width / 2/2-2,UIStyle.height / 2-250,"mid",Color.decode("#58606A"),Color.BLACK,"Modify Family", 400,100, BIG_FONT);
        testPanel.add(top);	
        
        DynamicText before=new DynamicText(UIStyle.width / 2/2-220,UIStyle.height / 2-200,"mid",Color.decode("#58606A"),Color.BLACK,"Prime Information", 400,100, NORMAL_FONT);
        testPanel.add(before);	
        
        DynamicText after=new DynamicText(UIStyle.width / 2/2+220,UIStyle.height / 2-200,"mid",Color.decode("#58606A"),Color.BLACK,"New Information", 400,100, NORMAL_FONT);
        testPanel.add(after);	
        
        DynamicText id=new DynamicText(10,UIStyle.height / 2/2,"right",Color.decode("#58606A"),Color.BLACK,"Family ID:", 100,100, SMALL_FONT);
        testPanel.add(id);
        //InputText in=new InputText(80,UIStyle.height / 2/2+10,200,25, 11, false, "");
        InputText a=new InputText(200,25,11,true,UIStyle.width/2/2-20,UIStyle.height / 2/2+50,  "",true);
        a.setText(column1);
        a.setEditable(false);
        testPanel.add(a);
        
        DynamicText name=new DynamicText(10,UIStyle.height / 2/2+60,"right",Color.decode("#58606A"),Color.BLACK,"Family Name:", 100,100, SMALL_FONT);
        testPanel.add(name);
        InputText b=new InputText(200,25,11,true,UIStyle.width/2/2-20,UIStyle.height / 2/2+110,  "",true);
        b.setText(column2);
        b.setEditable(false);
        testPanel.add(b);
        
        DynamicText pass=new DynamicText(10,UIStyle.height / 2/2+120,"right",Color.decode("#58606A"),Color.BLACK,"Address:", 100,100, SMALL_FONT);
        testPanel.add(pass);
        InputText c=new InputText(200,25,11,true,UIStyle.width/2/2-20,UIStyle.height / 2/2+170,  "",true);
        c.setText(column3);
        c.setEditable(false);
        testPanel.add(c);
        
        
        InputText x=new InputText(200,25,11,true,UIStyle.width-310,UIStyle.height / 2/2+50,  "",true);
        testPanel.add(x);
        InputText f=new InputText(200,25,11,true,UIStyle.width-310,UIStyle.height / 2/2+110,  "",true);
        testPanel.add(f);
        InputText g=new InputText(200,25,11,true,UIStyle.width-310,UIStyle.height / 2/2+170,  "",true);
        testPanel.add(g);

            
        
        
        TextButton confirm = new TextButton(UIStyle.width/2-50, UIStyle.height / 2+150, Color.decode("#6CA6CD"), Color.black, "Confirm", 100, 30, "normal", true);
        testPanel.add(confirm);
        
        
        

        
        
        
        
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
        
        confirm.addMouseListener(new MouseAdapter() {

	 			@Override
	 			public void mouseClicked(MouseEvent e) {

					// TODO Auto-generated method stub
					if (x.getText().trim().isEmpty() || f.getText().trim().isEmpty() || g.getText().trim().isEmpty() )
					{
						remind.WRONG("Please fill in the blank.");
					} else if (!x.getText().trim().equalsIgnoreCase(column1.trim()))//check if there's duplicate ID in db
					{
						remind.WRONG("family ID can not be changed");
					}  else
					{
						int i = update.updatefamily(Integer.parseInt(column1.trim()), f.getText().trim(), g.getText().trim());
						if (i == 1)
						{
							remind.OK("Successfully changed!");
						} else
						{
							remind.WRONG("change failed");
						}

						//change the data in db

					}
	 				
	 				
	 				}
	});
  			 			        
  			 			        
  			 					
  			 						
  			 					
  			 
        
                

        
        
        

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setUndecorated(true);
        jf.setVisible(true);
		
		
	}
	
	


	

	

}



