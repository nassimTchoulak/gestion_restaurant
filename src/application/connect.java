package application;

import java.io.IOException;

import code.ESImeal;
import code.IEsiMeal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class connect extends Stage {
	Parent root ;
	public connect(IEsiMeal c) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("connect.fxml"));
		//Parent root = (Parent) FXMLLoader.load(getClass().getResource("commandes.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		
		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("commandes.fxml")); 
	 	connectcontrol controller = fxmlLoader.<connectcontrol>getController();
		//controller.set_all(me, c);
	 	controller.set_all(c,this);
		Scene sene = new Scene(root);
	//	controller.set_all(me, c);
		this.setScene(sene);
		this.setTitle("connection");
		this.show();
		
	}
	
    // AnchorPane root = loader.load();
    // maincontroller mainWindowController = loader.getController();
    // mainWindowController.setMain(this);
     
     
		
	
}
