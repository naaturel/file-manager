package be.naaturel.filemanager.model;

import javafx.concurrent.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Analyser {

    private final Directory dir;

    public Analyser(String path){
        this.dir = new Directory(path);
    }

    public void startAnalyse(){
        this.dir.calculateInfos();
    }

    public Directory getDir(){
        return this.dir;
    }

    public double getSize() {
        return this.dir.getSize("gb");
    }
}
