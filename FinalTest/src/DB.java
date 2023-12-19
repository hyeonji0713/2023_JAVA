import java.sql.*;

public class DB {
	// 데이터베이스 연결을 수행하는 메서드
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/duksung";
        String id = "root";
        String password = "";
        Connection con = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");

            // 데이터베이스 연결
            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        }
        return con;
    }
    
	public static void main(String[] args) throws SQLException{
		Connection con = makeConnection();
		try {
			String sql = "" +
					"INSERT INTO student(stdid, name, tel, dept) " +
					"VALUES (?, ?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 2022014);
			pstmt.setString(2, "Hyein choi");
			pstmt.setString(3, "000-0000-0004");
			pstmt.setString(4, "SotfWare");
			
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: "+rows);
			
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e) {}
			}
		}
	}
}

