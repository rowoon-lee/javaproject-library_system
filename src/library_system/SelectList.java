package library_system;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class SelectList extends JFrame{

	Vector<Vector> outer;
	Vector<String> inner, title;	//inner = 책리스트, title = 컬럼명
	JTable table, table1, table2;
	DefaultTableModel model;
	
	public SelectList() {
		// TODO Auto-generated constructor stub
		super("Select list");
		Connection conn = MakeConnection.getConnection();
		
		title = new Vector<String>();
		outer = new Vector<Vector>();
	
		
		title.add("bookname");
		title.add("author");
		title.add("publisher");
		title.add("genre");
		title.add("stock");
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from book ");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()) {
				inner = new Vector<String>();
				for(int i=1; i<=rsmd.getColumnCount(); i++) {
					inner.add(rs.getString(i));
				}
				outer.add(inner);
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
		
		JTable table = new JTable(outer, title);
		JScrollPane scrollPane = new JScrollPane(table);
		Container c = getContentPane();
		
		table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		Object value = table.getValueAt(row, 0);
		Borrow.jt1.setText(value.toString());
		//System.out.println("borrow click");
		}
		});

		c.add(scrollPane, BorderLayout.CENTER);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(550, 420, 700, 370);
		setVisible(true);
		
	}//생성자 end	
	
}
