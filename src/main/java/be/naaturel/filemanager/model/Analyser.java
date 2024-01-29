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

    private SizeCalculator calculator;

    public Analyser(String path){
        this.dir = new Directory(path);
        this.calculator = new SizeCalculator(this.dir);
    }

    public void startAnalyse(){
        this.dir.listElements();
        calculator.launch();
    }

    public Directory getDir(){
        return this.dir;
    }

    public Task<Void> getTask(){
        return this.calculator.getTask();
    }


    /*public List<String> listFiles() {
        return Stream.of(
                    Objects.requireNonNull(
                    new File(dir.getPath()).listFiles())
                )
                .map(File::getName)
                .collect(Collectors.toList());
    }*/

    public double getSize() {
        return this.dir.getSize("gb");
    }
}
