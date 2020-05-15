package library_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ContentPage extends JFrame {

    public static JPanel contentPane;

    public ContentPage() {
    	JButton bt1, bt2, bt3, bt4;
        setTitle("Content Page");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 800, 700);
        contentPane = new JPanel();// 버튼이나 라벨이 들어갈 화면을 만듬
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
    	JLabel name	= new JLabel("접속자 : " + LoginPage.user + "님");
        name.setBounds(600, 10, 200, 50);
        name.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
        contentPane.add(name);
        
        JButton logout = new JButton("로그아웃하기");
        logout.setBounds(620, 70, 170, 30);
        logout.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        contentPane.add(logout);
        
        bt1 = new JButton("도서검색");
        bt1.setBounds(500, 200, 200, 40);
        bt1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
    	bt1.setBorderPainted(false);
    	bt1.setBackground(Color.LIGHT_GRAY);
        contentPane.add(bt1);
        
        bt2 = new JButton("도서대출");
        bt2.setBounds(500, 300, 200, 40);
        bt2.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
    	bt2.setBorderPainted(false);
    	bt2.setBackground(Color.LIGHT_GRAY);
        contentPane.add(bt2);
        
        bt3 = new JButton("도서반납");
        bt3.setBounds(500, 400, 200, 40);
        bt3.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
    	bt3.setBorderPainted(false);
    	bt3.setBackground(Color.LIGHT_GRAY);
        contentPane.add(bt3);
       
        bt4 = new JButton("열람실 좌석 예약");
        bt4.setBounds(500, 500, 200, 40);
        bt4.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
    	bt4.setBorderPainted(false);
    	bt4.setBackground(Color.LIGHT_GRAY);
        contentPane.add(bt4);

        setVisible(true);
        
        bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.removeAll();
				contentPane.revalidate();
				contentPane.repaint();
				dispose();
				Select sb = new Select();
				
			}
		});;
       
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.removeAll();
				contentPane.revalidate();
				contentPane.repaint();
				dispose();
				Borrow b = new Borrow();
				
			}
		});;
		
        bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.removeAll();
				contentPane.revalidate();
				contentPane.repaint();
				dispose();
				Return r = new Return();
				
			}
		});;
		     
        bt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.removeAll();
				contentPane.revalidate();
				contentPane.repaint();
				//열람실 리스트 
				ChooseRoomNumber rm = new ChooseRoomNumber();
//                rm.Room_1열람실();
//                rm.Room_2열람실();
//                rm.Room_3열람실();
//                rm.Room_4열람실();
              
			
			}
		});    
        
        logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.removeAll();
				contentPane.revalidate();
				contentPane.repaint();
				dispose();
				LoginPage lp = new LoginPage();
			}
		});
             
        JLabel background = new JLabel("");//배경화면 설정
        background.setIcon(new ImageIcon("src\\images\\books.png"));
        background.setBounds(0, 0, 1262, 673);
        contentPane.add(background);
                
      
    }
}


