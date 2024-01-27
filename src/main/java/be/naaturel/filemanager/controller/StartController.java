package be.naaturel.filemanager.controller;

import be.naaturel.filemanager.model.DirectoryAnalyser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class StartController {

    @FXML
    public TextField chosenPath;
    @FXML
    public VBox analyseBox;
    private final DirectoryAnalyser analyser = new DirectoryAnalyser();

    @FXML
    protected void onStartButtonClick() throws IOException {
        clearAnalyseBox();
        getFiles();
    }

    private void getFiles() throws IOException {
        List<String> files = this.analyser.listFilesOf(extractPath());

        for (String file : files) {

            String completePath = String.format("%s/%s/", extractPath(), file);
            double size = this.analyser.getGbSizeOf(completePath);
            Label l = new Label();
            l.setText(file + " (" + String.format("%.2f", size) + " Gb)");
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