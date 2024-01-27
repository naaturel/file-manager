package be.naaturel.filemanager.model;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Analyser {

    private final Directory dir;
    private final Thread computingThread;

    public Analyser(String path){
        this.dir = new Directory(path);
        computingThread = launchComputing();
    }

    public List<String> listFiles() {
        return Stream.of(Objects.requireNonNull(new File(dir.getPath()).listFiles()))
                .map(File::getName)
                .collect(Collectors.toList());
    }

    public double getSize() {

        if(computingState() == Thread.State.TERMINATED){
            return this.dir.getSize("gb");
        } else {
            throw new RuntimeException("Size is being computed. Please wait");
        }
    }

    public Thread.State computingState(){
        return computingThread.getState();
    }

    private Thread launchComputing(){
        Thread t = new Thread(
                () -> {
                    File file = new File(dir.getPath());
                    long size = computeSize(file);
                    this.dir.setSize(size);
                    System.out.println(this.dir.getSize("gb"));
                });
        t.start();
        return t;
    }

    private long computeSize(File folder) {
        long size = 0;
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else {
                    size += computeSize(file);
                }
            }
        }
        return size;
    }
}
