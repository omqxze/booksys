package Login;


import Login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginGUI extends Application{
	private static LoginGUI login;
	private static LoginController LoginCon;
	Pane p;
	@Override
	public void init() throws Exception{
		FXMLLoader fxmlLoader=new FXMLLoader();
		p=fxmlLoader.load(getInstance().getClass().getResource("Login.fxml").openStream());
		super.init();
	}
	public static LoginGUI getInstance() {
		// TODO Auto-generated method stub
		if(login==null)
			login=new LoginGUI();
		return login;
	}
	
	public static LoginController getEnvViewCon() {
		return LoginCon;
	}
	@Override
	public void stop() throws Exception{
		System.exit(0);
		super.stop();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		init();
		primaryStage.setScene(new Scene(p));
		primaryStage.setTitle("Login");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public static void main(String args[]) {
		launch(args);
	}
}
