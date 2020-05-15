package library_system;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;


public class Reservation extends JFrame implements ActionListener{
	ImageIcon img1, img2, img3;
	JButton[] jb = new JButton[14]; 
	JLabel[] jl = new JLabel[14];
	Boolean[] stay = new Boolean[14];
	Thread thread;
	Timer2 timer2;
	Timer3 timer3;
	
	
	public void book() {
		
		JButton back = new JButton("뒤로가기");
    	back.setBounds(10, 550, 75, 65);
    	back.setBorderPainted(false);
    	back.setContentAreaFilled(false);
    	back.setIcon(new ImageIcon("src\\images\\bback.png"));
    	back.setBorderPainted(false);
    	ContentPage.contentPane.add(back);
		 back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ContentPage.contentPane.removeAll();
					ContentPage.contentPane.revalidate();
					ContentPage.contentPane.repaint();
					dispose();
					ChooseRoomNumber cr = new ChooseRoomNumber();
				}
			});
		 
		 JButton home = new JButton();
	    	home.setBounds(150, 480, 180, 190);
	    	home.setBorderPainted(false);
	    	home.setContentAreaFilled(false);
	    	home.setIcon(new ImageIcon("src\\images\\home.png"));
	    	ContentPage.contentPane.add(home);
			
			 home.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ContentPage.contentPane.removeAll();
						ContentPage.contentPane.revalidate();
						ContentPage.contentPane.repaint();
						dispose();
						ContentPage cp = new ContentPage();
					}
				});
		JLabel name	= new JLabel("접속자 : " + LoginPage.user + "님");
		name.setBounds(600, 10, 200, 50);
		name.setFont(new Font("THE삐끗삐끗", Font.BOLD, 25));
		add(name);			 
		
		
		img1 = new ImageIcon("src/images/bindesk.png");
		img2 = new ImageIcon("src/images/door3.png");
		img3 = new ImageIcon("src/images/mandesk.png");
	
		for(int i=0; i<stay.length; i++) {
			stay[i] = true;
		}
		
		for(int i=0; i<jb.length; i++) {
			jb[i] = new JButton(img1);
			ContentPage.contentPane.add(jb[i]);
			jb[i].setCursor(new Cursor(Cursor.HAND_CURSOR));//버튼 위에 마우스 올리면 커서모양 -> 손모양
			jb[i].addActionListener(this);
			
			
//			jl[i] = new JLabel();
//			ContentPage.contentPane.add(jl[i]);
		}
		
		jb[0].setBounds(0, 0, 150, 100);
		jb[1].setBounds(150, 0, 150, 100);
		jb[2].setBounds(480, 0, 150, 100);
		jb[3].setBounds(630, 0, 150, 100);
		jb[4].setBounds(0, 150, 150, 100);
		jb[5].setBounds(150, 150, 150, 100);
		jb[6].setBounds(480, 150, 150, 100);
		jb[7].setBounds(630, 150, 150, 100);
		jb[8].setBounds(0, 300, 150, 100);
		jb[9].setBounds(150, 300, 150, 100);
		jb[10].setBounds(480, 300, 150, 100);
		jb[11].setBounds(630, 300, 150, 100);
		jb[12].setBounds(480, 450, 150, 100);
		jb[13].setBounds(630, 450, 150, 100);
		
//		jl[0].setBounds(0, 70, 150, 100);
//		jl[1].setBounds(150, 70, 150, 100);
//		jl[2].setBounds(480, 70, 150, 100);
//		jl[3].setBounds(630, 70, 150, 100);
//		jl[4].setBounds(0, 220, 150, 100);
//		jl[5].setBounds(150, 220, 150, 100);
//		jl[6].setBounds(480, 220, 150, 100);
//		jl[7].setBounds(630, 220, 150, 100);
//		jl[8].setBounds(0, 370, 150, 100);
//		jl[9].setBounds(150, 370, 150, 100);
//		jl[10].setBounds(480, 370, 150, 100);
//		jl[11].setBounds(630, 370, 150, 100);
//		jl[12].setBounds(480, 520, 150, 100);
//		jl[13].setBounds(630, 520, 150, 100);
		
		 JLabel background = new JLabel("");//배경화면 설정
	     background.setIcon(new ImageIcon("src\\images\\colorful.png"));
	     background.setBounds(0, 0, 1262, 673);
	     ContentPage.contentPane.add(background);

	     //좌석 버튼 클릭시 이벤트
		for(int i=0; i<jb.length; i++) {	
		jb[i].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		}
	}//void book end

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for(int i=0; i<jb.length; i++) {
				
				if(stay[i]==true) {			
					if(e.getSource().equals(jb[i])) {
						int first = JOptionPane.showConfirmDialog(null,  "예약하시겠습니까?" , "사용가능", JOptionPane.YES_NO_OPTION);
						if(first==0) {
							String[] buttons = {"3시간", "5시간"};
							int num = JOptionPane.showOptionDialog(null, "이용시간을 선택하세요", "이용시간 선택", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "3시간");	//3시간이 기본(점선으로 표시됨)
							if(num==0) {
								JOptionPane.showMessageDialog(null, LoginPage.user+"님  이용시간은 3시간입니다.");
								timer2 = new Timer2(img1, jb, stay);
								thread = new Thread(timer2);
								Timer2.k = i;
								thread.start();
//								jl[i] = new JLabel("남은 시간 : " + Timer2.j);
								
							}else if(num==1) {
								JOptionPane.showMessageDialog(null, LoginPage.user+"님 이용시간은 5시간입니다.");
								timer3 = new Timer3(img1, jb, stay);
								thread = new Thread(timer3);
								Timer3.y = i;
								thread.start();
//								jl[i] = new JLabel("남은 시간 : " + Timer3.x);
							}
							 jb[i].setIcon(img3);
							 stay[i] = false;
							 System.out.println("사용중");
						}else if(first==1) {
							JOptionPane.showMessageDialog(null, "다시선택하세요.");
						}
					}//if equals end
				}
				
				else if(stay[i]==false){
					
					if(e.getSource().equals(jb[i])) {
						int second = JOptionPane.showConfirmDialog(null, "이용중인 좌석입니다.\n정보입력 후 이용가능합니다.", "이용중", JOptionPane.OK_CANCEL_OPTION);
						if(second==0) {
							String id = LoginPage.jt1.getText();
							String input = JOptionPane.showInputDialog("아이디를 입력하세요.");
							if(id.equals(input)) {
								String[] option = {"연장", "반납"};
								int third = JOptionPane.showOptionDialog(null, "연장   /   반납", "연장/반납", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, "반납");
								if(third==0) {
									JOptionPane.showMessageDialog(null, "3시간 연장되었습니다. \n 이용해주셔서 감사합니다.");
									System.out.println("3시간 더 연장되었습니다.");
									Timer2.j += 10;
									Timer3.x += 10;
								}if(third==1) {
										JOptionPane.showMessageDialog(null, "반납되었습니다.\n이용해주셔서 감사합니다.");
											jb[i].setIcon(img1);
											stay[i] = true;
											System.out.println("이용가능");
											thread.suspend();
								}
							}else {
								JOptionPane.showMessageDialog(null, "사용자정보가 일치하지 않습니다.");
							}
							
		
						
						}else if(second==1) {
							System.exit(0);
						}
						
					}
				}
				
					
			}//for() end	
			
		}//actionPerformed() end
	}//class end

class Timer2 extends Thread{
	static int j;
	static int k;
	ImageIcon img1;
	JButton[] jb;
	Boolean[] stay;
	public Timer2(ImageIcon img1, JButton[] jb, Boolean[] stay) {
		// TODO Auto-generated constructor stub
		this.img1 = img1;
		this.jb = jb;
		this.stay = stay;
	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(j=10; j>0; j--) {
			System.out.println(j);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		jb[k].setIcon(img1);
		stay[k] = true;
	
	}
}

class Timer3 extends Thread{
	static int x;
	static int y;
	ImageIcon img1;
	JButton[] jb;
	Boolean[] stay;
	public Timer3(ImageIcon img1, JButton[] jb, Boolean[] stay) {
		// TODO Auto-generated constructor stub
		this.img1 = img1;
		this.jb = jb;
		this.stay = stay;
	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(x=15; x>0; x--) {
			System.out.println(x);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		jb[y].setIcon(img1);
		stay[y] = true;
	
	}
}

