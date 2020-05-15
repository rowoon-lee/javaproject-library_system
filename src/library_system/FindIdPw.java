package library_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FindIdPw extends JFrame implements ActionListener{
	JLabel id, pw, nl, el, il1, nl1, el1;
	JTextField nt, et, it1, nt1, et1;
	JButton ib, pb, back;
	
	public FindIdPw() {
		// TODO Auto-generated constructor stub
		
		setTitle("ID/PW FIND");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		setBounds(500, 200, 800, 700);
		
		id = new JLabel("아이디 찾기");
		pw = new JLabel("비밀번호 찾기");
		id.setBounds(100, 60, 150, 40);
		pw.setBounds(100, 360, 150, 40);
		id.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
		pw.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
		add(id); add(pw);
		
		nl = new JLabel("이름");
		el = new JLabel("이메일");
		nl.setBounds(100, 120, 150, 40);
		el.setBounds(100, 170, 150, 40);
		nl.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		el.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		add(nl); add(el);
		
		il1 = new JLabel("아이디");
		nl1 = new JLabel("이름");
		el1 = new JLabel("이메일");
		il1.setBounds(100, 410, 150, 40);
		nl1.setBounds(100, 460, 150, 40);
		el1.setBounds(100, 510, 150, 40);
		il1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		nl1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		el1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		add(il1); add(nl1); add(el1); 
		
		nt = new JTextField(30);
		et = new JTextField(30);
		nt.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		et.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		nt.setBounds(300, 120, 100, 35);
		et.setBounds(300, 170, 150, 35);
		add(nt); add(et);
		
		it1 = new JTextField(30);
		nt1 = new JTextField(30);
		et1 = new JTextField(30);
		it1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		nt1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		et1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		it1.setBounds(300, 410, 100, 35);
		nt1.setBounds(300, 460, 100, 35);
		et1.setBounds(300, 510, 150, 35);
		add(it1); add(nt1); add(et1); 
		
		ib = new JButton("찾기");
		pb = new JButton("찾기");
		ib.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		pb.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		ib.setBorderPainted(false);
		pb.setBorderPainted(false);
		ib.setBackground(Color.WHITE);
		pb.setBackground(Color.WHITE);
		ib.setBounds(530, 140, 100, 40);
		pb.setBounds(530, 460, 100, 40);
		add(ib); add(pb);
		
		back = new JButton("뒤로가기");
		back.setBounds(10, 10, 75, 65);
		back.setContentAreaFilled(false);
		back.setIcon(new ImageIcon("src\\images\\bback.png"));
		back.setBorderPainted(false);
		add(back);
		
		JLabel background = new JLabel("");//배경화면 설정
        background.setIcon(new ImageIcon("src\\images\\colorful.png"));
        background.setBounds(0, 0, 1262, 673);
        add(background);
		
		ib.addActionListener(this);
		pb.addActionListener(this);
		back.addActionListener(this);
		
		setVisible(true);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj = e.getSource();
			if(obj==ib) {
				String name = nt.getText();
				String email = et.getText();
				
				Connection conn = MakeConnection.getConnection();
				
				StringBuffer sb = new StringBuffer();
				sb.append("select * from login ");
				sb.append("where name = ? and email = ? ");
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					pstmt = conn.prepareStatement(sb.toString());
					pstmt.setString(1, name);
					pstmt.setString(2, email);

					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						System.out.println("회원님의 아이디는 " + rs.getString("id") + "입니다.");
						JOptionPane.showMessageDialog(null, "회원님의 아이디는 " + rs.getString("id") + "입니다.");
					}else {
						System.out.println("존재하지 않습니다.");
						JOptionPane.showMessageDialog(null, "회원정보가 존재하지 않습니다.");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						rs.close();
						pstmt.close();
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	
			}else if(obj==pb) {
				String id = it1.getText();
				String name = nt1.getText();
				String email = et1.getText();
				
				Connection conn = MakeConnection.getConnection();
				
				StringBuffer sb = new StringBuffer();
				sb.append("select * from login ");
				sb.append("where id = ? and name = ? and email = ? ");
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				try {
					pstmt = conn.prepareStatement(sb.toString());
					pstmt.setString(1, id);
					pstmt.setString(2, name);
					pstmt.setString(3, email);

					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						System.out.println("회원님의 비밀번호는 " + rs.getString("pw") + "입니다.");
						JOptionPane.showMessageDialog(null, "회원님의 비밀번호는 " + rs.getString("pw") + "입니다.");
					}else {
						System.out.println("존재하지 않습니다.");
						JOptionPane.showMessageDialog(null, "회원정보가 존재하지 않습니다.");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						rs.close();
						pstmt.close();
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}else if(obj==back) {
				dispose();
				LoginPage lp = new LoginPage();
			}
		}//actionperformed end
	

}
