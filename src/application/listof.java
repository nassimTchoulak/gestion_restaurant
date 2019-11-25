package application;

import java.io.IOException;

import code.Client;
import code.ESImeal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class listof extends Stage {
	Parent root ;
	public listof(ESImeal c,Client cc) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listof.fxml"));
		//Parent root = (Parent) FXMLLoader.load(getClass().getResource("commandes.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		
		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("commandes.fxml")); 
	 	listofcontrol controller = fxmlLoader.<listofcontrol>getController();
		//controller.set_all(me, c);
	 	controller.set_all(c,cc);
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
