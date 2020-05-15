package library_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StockCount {
	int stock = 0;

	public int stockc() {
		// TODO Auto-generated constructor stub
		String bookname = Borrow.jt1.getText();
		
		Connection conn = MakeConnection.getConnection();
		StringBuffer sb = new StringBuffer();
		sb.append("select stock ");
		sb.append("from book ");
		sb.append("where bookname = ? ");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(sb.toString());
			pstmt.setString(1, bookname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stock = rs.getInt("stock");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//		}finally {
//			try {
//				pstmt.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		}
		return stock;
	}

}
