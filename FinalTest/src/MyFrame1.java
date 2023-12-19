import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


public class MyFrame1 extends JFrame {
    JTextField id, name, tel, dept;
    JButton previousBut, nextBut, insertBut, deleteBut, searchBut, clearBut;
    ResultSet rs;
    Statement stmt;

    public MyFrame1() {
        super("Student Viewer");

        // 데이터베이스 연결
        Connection con = makeConnection();

        try {
            // 업데이트 가능한 Result Set 생성
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            // books 테이블에서 모든 레코드를 가져옴
            rs = stmt.executeQuery("SELECT * FROM student WHERE stdid IS NOT NULL");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        setLayout(new GridLayout(0, 2));
        add(new JLabel("stuID", JLabel.CENTER));
        add(id = new JTextField());

        add(new JLabel("name", JLabel.CENTER));
        add(name= new JTextField());

        add(new JLabel("tel", JLabel.CENTER));
        add(tel = new JTextField());

        add(new JLabel("dept"), JLabel.CENTER);
        add(dept = new JTextField());
        
        
        previousBut = new JButton("이전");
        previousBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    if (rs.previous()) {
                        setFieldsFromResultSet();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        nextBut = new JButton("다음");
        nextBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    if (rs.next()) {
                        setFieldsFromResultSet();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        insertBut = new JButton("삽입");
        insertBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (insertRecord()) {
                    System.out.println("레코드 삽입 성공");
                } else {
                    System.out.println("레코드 삽입 실패");
                }
            }
        });

        deleteBut = new JButton("삭제");
        deleteBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (deleteRecord()) {
                    System.out.println("레코드 삭제 성공");
                } else {
                    System.out.println("레코드 삭제 실패");
                }
            }
        });

        searchBut = new JButton("검색");
        searchBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (searchRecord()) {
                    System.out.println("검색 성공");
                } else {
                    System.out.println("검색 실패");
                }
            }
        });

        clearBut = new JButton("초기화");
        clearBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                clearFields();
            }
        });

        add(previousBut);
        add(nextBut);
        add(insertBut);
        add(deleteBut);
        add(searchBut);
        add(clearBut);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setVisible(true);
    }
 	
        
 // 데이터베이스 연결 메서드
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/duksung";
        String id = "root";
        String password = "";
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection(url, id, password);
            con.setAutoCommit(false); // Auto-Commit 비활성화
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        }
        return con;
    }


    // 콘솔 창에 레코드 정보 출력 메서드
    private void printRecordInfo() {
        try {
            System.out.println("ID: " + rs.getInt("stdid"));
            System.out.println("이름: " + rs.getString("name"));
            System.out.println("전화번호: " + rs.getString("tel"));
            System.out.println("전공: " + rs.getString("dept"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ResultSet으로부터 필드에 데이터 설정 메서드
    private void setFieldsFromResultSet() {
        try {
            id.setText("" + rs.getInt("stdid"));
            name.setText("" + rs.getString("name"));
            tel.setText("" + rs.getString("tel"));
            dept.setText("" + rs.getString("dept"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 레코드 삽입 메서드
    private boolean insertRecord() {
        try {
            rs.moveToInsertRow();
            rs.updateString("name", name.getText());
            rs.updateString("tel", tel.getText());
            rs.updateString("dept", dept.getText());
            rs.insertRow();
            rs.moveToCurrentRow();
            System.out.println("레코드 삽입 성공");
            return true;
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("레코드 삽입 실패");
            return false;
        }
    }


    // 레코드 삭제 메서드
    private boolean deleteRecord() {
        try {
            rs.deleteRow();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 레코드 검색 메서드
    private boolean searchRecord() {
        try {
            String searchKeyword = search.getText();
            String query = "SELECT * FROM student WHERE stdid LIKE ?";
            PreparedStatement searchStmt = stmt.getConnection().prepareStatement(query);
            searchStmt.setString(1, "%" + searchKeyword + "%");
            ResultSet searchResult = searchStmt.executeQuery();

            if (searchResult.next()) {
                rs = searchResult;
                setFieldsFromResultSet();
                return true;
            } else {
                System.out.println("검색 결과 없음");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 필드 초기화 메서드
    private void clearFields() {
        id.setText("");
        name.setText("");
        tel.setText("");
        dept.setText("");
    }

    public static void main(String[] args) {
        new MyFrame1();
    }
}