package be.naaturel.filemanager.controller;

import be.naaturel.filemanager.model.Analyser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
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
        clearAnalyseBox();
        getFiles();
    }

    private void getFiles(){
        List<String> files = this.analyser.listFiles();

        for (String file : files) {

            String completePath = String.format("%s/%s/", extractPath(), file);
            double size = 0;
            Label l = new Label();
            l.setText(file);

            try {
                size = this.analyser.getSize();
                l.setText(l.getText() + " (" + String.format("%.2f", size) + " Gb)");
            } catch (Exception e) {
                l.setText(l.getText() + " " + e.getMessage());
            }

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