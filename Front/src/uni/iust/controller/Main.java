package uni.iust.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Kiarash23 on 12/26/2018.
 */
public class Main extends Application{
    private static Stage stage;
    private static Scene scene;
    public static Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("/uni/iust/view/compiler.fxml"));
        scene=new Scene(root,986,762);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}
