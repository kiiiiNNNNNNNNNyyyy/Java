package application;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane{
	
	Media media;
	MediaPlayer player;
	MediaView view;
	Pane mpane;
	MediaBar bar;
	
	public Player(String file){
		
		media = new Media(file);
		player = new MediaPlayer(media);
		view = new MediaView(player);
		mpane = new Pane();
		
		//add the view to the pane using getChildren method.
		mpane.getChildren().add(view);
		
		//now add to the BorderPane which is our player class
		setCenter(mpane);
		
		//create a media bar
		bar = new MediaBar(player);
		setBottom(bar); 
		setStyle("-fx-background-color: #bfc2c7");
		
		//to play the video
		player.play();
		
	}
}
