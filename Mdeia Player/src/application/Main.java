package application;
	
import java.io.File;
import java.net.MalformedURLException;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	Player player;
	FileChooser fileChooser;
	 
	@Override
	public void start(final Stage primaryStage) {
		
		MenuItem open = new MenuItem("Open");
		Menu file = new Menu("File");
		MenuBar menu = new MenuBar();
		
		file.getItems().add(open);
		//adding the file to the menu
		menu.getMenus().add(file);
		
		fileChooser = new FileChooser();
		
		//set the action for the open button
		open.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				player.player.pause();
				File file = fileChooser.showOpenDialog(primaryStage);
				
				if(file != null){
					try {
						player = new Player(file.toURI().toURL().toExternalForm());
						Scene scene = new Scene(player, 720, 535);
						primaryStage.setScene(scene);
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		String path = "file:///C:/gotg1.mp4";
		File f = new File(path);
		if(!f.exists()){
			System.out.println("File is Missing!!");
		}
		                        
		player = new Player(path);
		player.setTop(menu);
		//adding the menu to the player
		
		
		Scene scene = new Scene(player, 720, 480);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
