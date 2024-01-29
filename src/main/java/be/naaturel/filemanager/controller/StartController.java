package be.naaturel.filemanager.controller;

import be.naaturel.filemanager.model.Analyser;
import be.naaturel.filemanager.model.Directory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class StartController {

    @FXML
    public TextField chosenPath;
    @FXML
    public VBox analyseBox;
    @FXML
    public VBox detailsBox;

    private Analyser analyser;

    @FXML
    protected void onStartButtonClick() {
        analyser = new Analyser(extractPath());
        analyser.startAnalyse();
        clearBox(analyseBox);
        displayInfos();
    }

    private void displayInfos(){

        for (Directory d : this.analyser.getDir().getSubDirectories()) {

            HBox hbox = new HBox();

            Label l = new Label();
            l.setText(String.format("%s (%.2f Gb)", d.getPath(), d.getSize("gb")));

            Button b = new Button();
            b.setText("+");
            b.setOnAction(event -> extendDirectory());

            hbox.getChildren().addAll(l, b);
            analyseBox.getChildren().add(hbox);
        }
    }

    //TODO : fix display
    private void extendDirectory(){

        clearBox(detailsBox);
        for (Directory d : this.analyser.getSubDirs()){
            HBox hbox = new HBox();

            Label l = new Label();
            l.setText(String.format("%s (%.2f Gb)", d.getPath(), d.getSize("gb")));

            Button b = new Button();
            b.setText("+");
            b.setOnAction(event -> extendDirectory());

            hbox.getChildren().addAll(l, b);
            detailsBox.getChildren().add(hbox);
        }
    }

    private String extractPath(){
        return chosenPath.getText();
    }

    private void clearBox(Pane pane){
        pane.getChildren().clear();
    }
}