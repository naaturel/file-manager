package be.naaturel.filemanager.model;

import java.io.File;

public class Directory {

    private final String dir;
    private Size size;
    private Thread computingThread;

    public Directory(String dir){
        this.dir = dir;
        computingThread = computeSize();
    }

    public Thread.State getComputingState(){
        return computingThread.getState();
    }

    private Thread computeSize(){
        Thread t = new Thread(
                () -> this.size = getSizeOf(new File(dir)));
        t.start();
        return t;
    }

    private Size getSizeOf(File folder) {
        long size = 0;

        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length(); // Add size of file
                } else {
                    size += getSizeOf(file).getValue(); // Recursively add size of subfolder
                }
            }
        }
        return new Size(size);
    }
}
