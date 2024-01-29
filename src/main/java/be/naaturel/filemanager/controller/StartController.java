package be.naaturel.filemanager.controller;

import be.naaturel.filemanager.model.Analyser;
import be.naaturel.filemanager.model.Directory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.List;

public class StartController {

    @FXML
    public TextField chosenPath;
    @FXML
    public VBox analyseBox;
    private Analyser analyser;

    @FXML
    protected void onStartButtonClick() {
        analyser = new Analyser(extractPath());
        analyser.startAnalyse();
        clearAnalyseBox();
        displayInfos();
    }

    private void displayInfos(){

        for (Directory d : this.analyser.getDir().getSubDirectories()) {
            Label l = new Label();
            l.setText(String.format("%s %.2f", d.getPath(), d.getSize("gb")));
            analyseBox.getChildren().add(l);
        }
    }

    private String extractPath(){
        return chosenPath.getText();
    }

    private void clearAnalyseBox(){
        analyseBox.getChildren().clear();
    }
}