package library_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Return extends JFrame implements ActionListener{
	JScrollPane jp;
	JLabel jl1, jl2, jl3, jl4;
	JButton jb1, jb2, back, logout;
	static JTextField jt1;
	
	
	public Return() {
		// TODO Auto-generated constructor stub
		super("Return book");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 800, 700);
		setLayout(null);
		
		jl1 = new JLabel("도서명");
		jl1.setBounds(100, 100, 100, 40);
		jl1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
		add(jl1); 
		
		JLabel name	= new JLabel("접속자 : " + LoginPage.user + "님");
        name.setBounds(600, 10, 200, 50);
        name.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
        add(name);
		
		jb1 = new JButton("반납하기");
		jb1.setBounds(320, 600, 150, 40);
		jb1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
		jb1.setBorderPainted(false);
		jb1.setBackground(Color.WHITE);
		add(jb1);
		
		jb2 = new JButton("도서 리스트 보기");
		jb2.setBounds(550, 600, 200, 40);
		jb2.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
		jb2.setBorderPainted(false);
		jb2.setBackground(Color.WHITE);
		add(jb2);
		
		back = new JButton("뒤로가기");
		back.setBounds(10, 10, 75, 65);
		back.setContentAreaFilled(false);
		back.setIcon(new ImageIcon("src\\images\\bback.png"));
		back.setBorderPainted(false);
		add(back);
		
		 logout = new JButton("로그아웃하기");
	     logout.setBounds(620, 70, 170, 30);
	     logout.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
	     logout.setBorderPainted(false);
	     logout.setContentAreaFilled(false);
	     add(logout);
		
	
		jt1 = new JTextField(30);
		
		jt1.setBounds(280, 100, 150, 40);
		jt1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		add(jt1); 
//		add(jt2); add(jt3); add(jt4);
		
        JLabel background = new JLabel("");//배경화면 설정
        background.setIcon(new ImageIcon("src\\images\\peoplebook.png"));
        background.setBounds(0, 0, 1262, 673);
        add(background);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		back.addActionListener(this);
		logout.addActionListener(this);
		
		setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//0. 변수 설정
				//사용자 입력 받아오기
				Object obj = e.getSource();
				if(obj==jb1) {
					
				//dbms 연결
				Connection conn = MakeConnection.getConnection();		

				String bookname = jt1.getText();
//				String author = jt2.getText();
//				String publisher = jt3.getText();
//				String genre = jt4.getText();
				
			
				StringBuffer sb = new StringBuffer();
				sb.append("update book ");
				sb.append("set stock = stock+1 ");
				sb.append("where bookname = ? ");
//				sb.append("values (?, ?, ?, ?) ");
				
				PreparedStatement pstmt = null;
//				ResultSet rs = null;
				
				try {
					pstmt = conn.prepareStatement(sb.toString());
					pstmt.setString(1, bookname);
//					pstmt.setString(2, author);
//					pstmt.setString(3, publisher);
//					pstmt.setString(4, genre);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, LoginPage.user+"님 " + bookname + "이(가) 반납되었습니다. \n 이용해주셔서 감사합니다.");
//					JOptionPane.showMessageDialog(null, "반납이 완료되었습니다. \n 이용해주셔서 감사합니다.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				
				}finally {
					try {
						pstmt.close();
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				}else if(obj==jb2){
					SelectList sl = new SelectList();
				}else if(obj==back) {
					dispose();
					ContentPage cp = new ContentPage();
				}else if(obj==logout) {
					dispose();
					LoginPage lp = new LoginPage();
				}
	}
	
}
