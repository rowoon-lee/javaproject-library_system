package library_system;
import java.awt.*;
import javax.swing.*;

class TimerRunnable implements Runnable {
	JLabel timerLabel;
	
	public TimerRunnable(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	public void run() {
		int n=0; 
		while(true) { 
			timerLabel.setText(Integer.toString(n)); 
			n++;
			try {
				Thread.sleep(1000); 
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
}

public class Timer extends JFrame {
	public Timer() {
		setTitle("RunnableTimerEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));

		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable); 
		c.add(timerLabel); 
		setSize(300,150);
		setVisible(true);
		th.start(); 
	}

	public static void main(String[] args) {
		new Timer();
	}	
}