package be.naaturel.filemanager.model;

import javafx.concurrent.Task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Allows to create threads that calculates the size of a specific directory
 */
public class SizeCalculator implements IThreadBuilder<Task<Void>> {

    private Directory baseDir;
    private Task<Void> task;

    public SizeCalculator(Directory dir){
        this.baseDir = dir;
    }

    @Override
    public Task<Void> launch() {
        Task<Void> task = createTask(baseDir);
        this.task = task;

        Thread t = new Thread(task);
        t.start();
        return task;
    }

    private Task<Void> createTask(Directory dir){
        return new Task<> () {
            @Override
            public Void call() {
                long value = sizeOf(dir);
                dir.setSize(value);
                updateMessage(String.format("%s", dir.getSize("gb")));
                return null;
            }
        };
    }

    public Task<Void> getTask(){
        return this.task;
    }

    private long sizeOf(Directory directory) {
        long totalSize = 0;

        for (File f : directory.getFiles()){
            totalSize += f.length();
        }

        for (Directory d: directory.getSubDirectories()) {
            totalSize += sizeOf(d);
        }

        System.out.println(totalSize);
        return totalSize;

    }


}
