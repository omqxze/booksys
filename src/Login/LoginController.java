package Login;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import booksys.presentation.*;
public class LoginController {
	BookingSystemApp bsa;

    @FXML
    private TextField textfield1;

    @FXML
    private Button bth1;

    @FXML
    private PasswordField passwordfield1;

    @FXML
    private Label result;

    @FXML
    void btnAction(ActionEvent event) {
    	if(isCorrect(textfield1.getText(),passwordfield1.getText())) {
    		if(textfield1.getText().equals("manager")) {
    			result.setText("�����ڴ� ȯ���մϴ�.");
    			new BookingSystemApp();
    			LoginGUI gui=new LoginGUI();
    			}
    		else {
    			result.setText("���� ȯ���մϴ�.");
    			bsa=new BookingSystemApp();
    			bsa.hide();
    			Frame[] f=bsa.getFrames();
    			MenuBar mb=f[0].getMenuBar();
    			f[0].getMenuBar().getMenu(2).disable();
    			bsa.show();
    		}
    		
    		}
    	else {
    		result.setText("�α��ο� �����߽��ϴ�.");
    }
    	}

	private boolean isCorrect(String id, String pwd) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		String driver="org.mariadb.jdbc.Driver";
		
		try {
			try {
				Class.forName(driver);
			}catch(ClassNotFoundException e) {
				System.out.println("����̹� �ε� ����");
				e.printStackTrace();
			}
			con=DriverManager.getConnection(
					"jdbc:mariadb://localhost:3306/test", "root", "se");
			stmt=con.createStatement();
			if(con!=null) {
				System.out.println("DB ���� ����");
			}
			rs=stmt.executeQuery("select password from login where id='"+id+"'");
			while(rs.next()) {
				if(rs.getString(1).equals(pwd)) {
					return true;
				}
			}
		}catch(SQLException sqex) {
			System.out.println("SQLException: "+sqex.getMessage());
			System.out.println("SQLState: "+sqex.getSQLState());
		}
	
		return false;
	}

}