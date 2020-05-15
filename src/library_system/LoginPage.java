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

public class LoginPage extends JFrame implements ActionListener{
	JPanel jp1;
	JButton jb1, jb2, jb3;
	JLabel jl1, jl2;
	static JTextField jt1;
	JPasswordField jpf;
	static String user;
	
	JPanel jp2;
	JLabel jlb2;
	
	public LoginPage() {
		
		// TODO Auto-generated constructor stub
		setTitle("Login Page");
		
		setBounds(500, 200, 800, 700);
		jp1 = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jp1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jp1);
		jp1.setLayout(null);
		jp1.setBounds(500, 200, 800, 700);
			
//		JLabel background = new JLabel("");//배경화면 설정
//        background.setIcon(new ImageIcon("src\\images\\library.png"));
//        background.setBounds(0, 0, 1262, 673);
//        add(background);
		
		jb1 = new JButton("로그인하기");
		jb2 = new JButton("회원가입하기");
		jb3 = new JButton("아이디/비밀번호 찾기");
		
		jb1.setBounds(300, 450, 200, 40);
		jb2.setBounds(300, 510, 200, 40);  
		jb3.setBounds(250, 570, 300, 40);
		
		jb1.setBorderPainted(false);
		jb2.setBorderPainted(false);
		jb3.setBorderPainted(false);
		jb1.setContentAreaFilled(false);
		jb2.setContentAreaFilled(false);
		jb3.setContentAreaFilled(false);
		jb1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
		jb2.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
		jb3.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
		
		
		jp1.add(jb1); jp1.add(jb2); jp1.add(jb3);
		
		jl1 = new JLabel("I D");
		jl2 = new JLabel("P W");
		
		jl1.setBounds(250, 250, 100, 40);
		jl2.setBounds(250, 350, 100, 40);
		jl1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 30));
		jl2.setFont(new Font("THE삐끗삐끗", Font.BOLD, 30));
		
		jp1.add(jl1); jp1.add(jl2);
		
		jt1 = new JTextField(30);
		jt1.setFont(new Font("THE삐끗삐끗", Font.BOLD, 20));
		jpf = new JPasswordField(30);
		
		jt1.setBounds(450, 250, 100, 40);
		jpf.setBounds(450, 350, 100, 40);
		
		jp1.add(jt1); jp1.add(jpf);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
        JLabel background = new JLabel("");//배경화면 설정
        background.setIcon(new ImageIcon("src\\images\\rowoon3.png"));
        background.setBounds(0, 0, 1262, 673);
        jp1.add(background);
        
//        jp1.setBackground(Color.black);
		
		setVisible(true);		
	}//생성자 end

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj==jb1) {
			//System.out.println("click");
			//사용자 입력 받아오기
			String id = jt1.getText();
			String pw = jpf.getText();
			
			//System.out.println("id : " + id + ", pw : " + pw);
			
			//dbms에 접근해서 id, pw가 일치하는지 확인(비교)
			Connection conn = MakeConnection.getConnection();
			
			StringBuffer sb = new StringBuffer();
			sb.append("select * from login ");
			sb.append("where id =? and pw = ? ");
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				
				rs = pstmt.executeQuery();
				
				//간단한 회원여부 check
				if(rs.next()) {
					System.out.println("존재하는 회원");
					System.out.println("환영합니다 "+ rs.getString("name") + " 님");
					JOptionPane.showMessageDialog(null, "환영합니다.  "+ rs.getString("name") + " 님");
					jp1.removeAll();
					jp1.revalidate();
					jp1.repaint();
					user = rs.getString("name");
					dispose();
					ContentPage cp = new ContentPage();
					//System.out.println(id + " 님 어서오세요");	
				}else {
					System.out.println("회원가입하세요");
					JOptionPane.showMessageDialog(null, "존재하지 않는 회원입니다. 회원가입 후 이용해주세요.");	
				}
				
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}else if(obj==jb2) {
			//회원가입창으로 이동(호출)
				// TODO Auto-generated method stub
					jp1.removeAll();
					jp1.revalidate();
					jp1.repaint();
					dispose();
					RegisterPage rp = new RegisterPage();
		}else if(obj==jb3) {
			jp1.removeAll();
			jp1.revalidate();
			jp1.repaint();
			dispose();
			FindIdPw fip = new FindIdPw();
		}
	
	}//actionperformed end

}
