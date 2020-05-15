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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class RegisterPage extends JFrame implements ActionListener{
	JPanel jp2;
	JButton jb0, jb1, back;
	JLabel jl1, jl2, jl3, jl4;
	JTextField jt1, jt2, jt3;
	JPasswordField jpf1;
	
	public RegisterPage() {
		// TODO Auto-generated constructor stub
	setTitle("Register Page");
	
	setBounds(500, 200, 800, 700);
	jp2 = new JPanel();
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	jp2.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(jp2);
	jp2.setLayout(null);

	jb0 = new JButton("아이디 중복 체크");
	jb0.setBounds(540, 200, 145	, 40);
	jb0.setFont(new Font("THE삐끗삐끗", Font.BOLD, 17));
	jp2.add(jb0);
	
	jb1 = new JButton("회원가입하기");
	jb1.setBounds(540, 300, 145	, 40);
	jb1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 17));
	jp2.add(jb1);
	
	jb0.setBorderPainted(false);
	jb1.setBorderPainted(false);
	jb0.setBackground(Color.WHITE);
	jb1.setBackground(Color.WHITE);
	
	jl1 = new JLabel("아이디");
	jl2 = new JLabel("비밀번호");
	jl3 = new JLabel("이름");
	jl4 = new JLabel("이메일");
	
	jl1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 30));
	jl2.setFont(new Font("THE삐끗삐끗", Font.BOLD, 30));
	jl3.setFont(new Font("THE삐끗삐끗", Font.BOLD, 30));
	jl4.setFont(new Font("THE삐끗삐끗", Font.BOLD, 30));
	jl1.setBounds(150, 200, 100, 40);
	jl2.setBounds(150, 300, 100, 40);
	jl3.setBounds(150, 400, 100, 40);
	jl4.setBounds(150, 500, 100, 40);
	jp2.add(jl1); jp2.add(jl2); jp2.add(jl3); jp2.add(jl4);
	
	jt1 = new JTextField();
	jt2 = new JTextField();
	jpf1 = new JPasswordField();
	jt3 = new JTextField();
	jt1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
	jt2.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
	jt3.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
	jt1.setBounds(310, 200, 120, 40);
	jpf1.setBounds(310, 300, 120, 40);
	jt2.setBounds(310, 400, 120, 40);
	jt3.setBounds(310, 500, 120, 40);
	jp2.add(jt1); jp2.add(jt2); jp2.add(jpf1); jp2.add(jt3);
	
	back = new JButton("뒤로가기");
	back.setBounds(10, 10, 75, 65);
	back.setContentAreaFilled(false);
	back.setIcon(new ImageIcon("src\\images\\bback.png"));
	back.setBorderPainted(false);
	add(back);
	
	jb0.addActionListener(this);
	jb1.addActionListener(this);
	back.addActionListener(this);
	
	JLabel background = new JLabel("");//배경화면 설정
	background.setIcon(new ImageIcon("src\\images\\colorful.png"));
	background.setBounds(0, 0, 1262, 673);
	add(background);

	setVisible(true);
	}

//	public static void main(String[] args) {
//		new RegisterPage();	
//		
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==jb0) {
			String id = jt1.getText();
//			MakeConnection mc1 = MakeConnection.getInstance();
			
			//dbms 연결
			Connection conn = MakeConnection.getConnection();
			
			//sql statement
			StringBuffer sb = new StringBuffer();
			sb.append("select * from login ");
			sb.append("where id = ? ");
					
			//문장 객체
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, id);
				
				//실행
				rs = pstmt.executeQuery();
				
				//select 먼저해서 중복되는아이디 있는지 체크  -> insert하기
				if(rs.next()) {
					System.out.println("중복되는 아이디입니다. 다시 입력하세요");
					JOptionPane.showMessageDialog(null, "중복되는 아이디입니다. 다시 입력하세요");
				}else {
					System.out.println("사용가능한 아이디입니다.");
					JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}//자원 반납
			finally {
				try {
					rs.close();
					pstmt.close();
	
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	
		}else if(obj==jb1) {
			MakeConnection mc1 = MakeConnection.getInstance();
			
			//dbms 연결
			Connection conn = MakeConnection.getConnection();
			String id = jt1.getText();
			String pw = jpf1.getText();
			String name = jt2.getText();
			String email = jt3.getText();
			
			//sql statement
			StringBuffer sb = new StringBuffer();
			sb.append("insert into login ");
			sb.append("values ( ?, ?, ?, ? )");
			
			//문장 객체
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				pstmt.setString(3, name);
				pstmt.setString(4, email);
				//실행
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null,"회원가입이 완료되었습니다. 로그인 후 이용해주세요" );
				
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
			jp2.removeAll();
			jp2.revalidate();
			jp2.repaint();
			dispose();
			System.out.println("로그인 페이지로 이동합니다.");
			LoginPage lp = new LoginPage();
		}else if(obj==back) {
			dispose();
			LoginPage lp = new LoginPage();
		}
		
	}

}
