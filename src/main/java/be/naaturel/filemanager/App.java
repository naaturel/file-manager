package be.naaturel.filemanager;

import be.naaturel.filemanager.controller.IChangeView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application implements IChangeView {

    private Scene scene;
    private final FXMLLoader fxmlLoader;
    private final String mainView = "start-view.fxml";

    public App() throws IOException {
         fxmlLoader = new FXMLLoader(App.class.getResource(mainView));
         scene = new Scene(fxmlLoader.load(), 1080, 720);
    }

    @Override
    public void start(Stage stage) throws IOException {
        setView(stage);
        stage.setTitle("File Manager");
    }

    @Override
    public void change(String view) {

    }

    private void setView(Stage stage) {
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}