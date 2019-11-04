package mrmathami.thegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;

/**
 * Main class. Entry point of the game.
 */
public final class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		final Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
//		final StackPane pane = new StackPane(canvas);
		final AnchorPane pane = new AnchorPane(canvas);
		final Scene scene = new Scene(pane);
		final GameController gameController = new GameController(graphicsContext, pane, scene);

		canvas.setFocusTraversable(true);
		graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);

		// keyboard and mouse events to catch. Add if you need more
		//canvas.setOnKeyPressed(gameController::keyDownHandler);
		//canvas.setOnKeyReleased(gameController::keyUpHandler);
//		canvas.setOnKeyTyped(...);

		//canvas.setOnMousePressed(gameController::mouseDownHandler);
		//canvas.setOnMouseReleased(gameController::mouseUpHandler);
//		canvas.setOnMouseClicked(...);
//		canvas.setOnMouseMoved(...);

		primaryStage.setResizable(false);
		primaryStage.setTitle(Config.GAME_NAME);
		primaryStage.setOnCloseRequest(gameController::closeRequestHandler);

		primaryStage.setScene(scene);

		//primaryStage.setScene(new Scene(new StackPane(canvas)));
		primaryStage.show();

		gameController.start();
	}
}