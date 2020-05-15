package library_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ChooseRoomNumber implements ActionListener{
	JButton [] jb = new JButton[4]; 
	JButton back = new JButton("뒤로가기");
	
	public ChooseRoomNumber() {
		// TODO Auto-generated constructor stub

		back.setBounds(10, 10, 75, 65);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setIcon(new ImageIcon("src\\images\\bback.png"));
		ContentPage.contentPane.add(back);
		back.addActionListener(this);
		
		JLabel name	= new JLabel("접속자 : " + LoginPage.user + "님");
        name.setBounds(600, 10, 200, 50);
        name.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
        ContentPage.contentPane.add(name);
		
		JLabel reserve = new JLabel("열람실 명 : 제 1열람실"); 
        reserve.setBounds(200, 150, 400, 40);  
        reserve.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
        ContentPage.contentPane.add(reserve);
        
        JLabel reserve1 = new JLabel("열람실 명 : 제 2열람실"); 
        reserve1.setBounds(200, 260, 400, 40);  
        reserve1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
        ContentPage.contentPane.add(reserve1);
        
        JLabel reserve2 = new JLabel("열람실 명 : 제 3열람실"); 
        reserve2.setBounds(200, 370, 400, 40);  
        reserve2.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
        ContentPage.contentPane.add(reserve2);
        
        JLabel reserve3 = new JLabel("열람실 명 : 제 4열람실"); 
        reserve3.setBounds(200, 480, 400, 40);  
        reserve3.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
        ContentPage.contentPane.add(reserve3);
        
        for(int i=0; i<jb.length; i++) {
        	jb[i] = new JButton("예약하기");
        	ContentPage.contentPane.add(jb[i]);
        	jb[i].addActionListener(this);
        	jb[i].setBorderPainted(false);
        	jb[i].setBackground(Color.WHITE);
        	jb[i].setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
        }
        
        jb[0].setBounds(530, 150, 130, 40);
        jb[1].setBounds(530, 260, 130, 40);
        jb[2].setBounds(530, 370, 130, 40);
        jb[3].setBounds(530, 480, 130, 40);
        
        JLabel background = new JLabel("");//배경화면 설정
        background.setIcon(new ImageIcon("src\\images\\colorful.png"));
        background.setBounds(0, 0, 1262, 673);
        ContentPage.contentPane.add(background);
        
//        setVisible(true);
	}//생성자 end

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==back) {
			ContentPage.contentPane.removeAll();
    		ContentPage.contentPane.revalidate();
    		ContentPage.contentPane.repaint();
    		ContentPage cp = new ContentPage();
		}else if(obj==jb[0]) {
			for(int i=0; i<jb.length; i++) {
				ContentPage.contentPane.removeAll();
	    		ContentPage.contentPane.revalidate();
	    		ContentPage.contentPane.repaint();
	    		Reservation Re = new Reservation();
	    		Re.book();

				}
		}else if(obj==jb[1]) {
				ContentPage.contentPane.removeAll();
	    		ContentPage.contentPane.revalidate();
	    		ContentPage.contentPane.repaint();
	    		Reservation Re = new Reservation();
	    		Re.book();

		}else if(obj==jb[2]) {
				ContentPage.contentPane.removeAll();
	    		ContentPage.contentPane.revalidate();
	    		ContentPage.contentPane.repaint();
	    		Reservation Re = new Reservation();
	    		Re.book();

		}else if(obj==jb[3]) {
				ContentPage.contentPane.removeAll();
	    		ContentPage.contentPane.revalidate();
	    		ContentPage.contentPane.repaint();
	    		Reservation Re = new Reservation();
	    		Re.book();
		}

	}//actionlistener end
	


	
}
