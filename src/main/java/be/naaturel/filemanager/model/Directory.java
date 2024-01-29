package be.naaturel.filemanager.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Directory {

    private final String path;
    private List<Directory> subDirectories;
    private List<File> files;
    private Size size;

    public Directory(String dir){
        this.path = dir;
        this.subDirectories = new ArrayList<>();
        this.files = new ArrayList<>();
        this.size = new Size();
    }

    public boolean hasSubDirectories(){
        return subDirectories.size() != 0;
    }

    public boolean hasFiles(){
        return files.size() != 0;
    }

    public List<Directory> getSubDirectories() {
        return new ArrayList<>(subDirectories);
    }

    public List<File> getFiles(){
        return new ArrayList<>(files);
    }

    public String getPath(){
        return this.path;
    }

    public void setSize(long value){
        this.size.setValue(value);
    }

    public double getSize(String format){
        switch (format.toLowerCase()){
            case "mb":
                return size.toMb();
            case "gb":
                return size.toGb();
            default:
                return size.getValue();
        }
    }

    public void listElements(){

        File[] fs = new File(this.path).listFiles();
        if(fs == null) return;

        for (File f: fs) {
            if(f.isFile()){
                addFile(f);
            } else {
                Directory subDir = new Directory(f.getAbsolutePath());
                addSubDirectory(subDir);
            }
        }
    }

    private void addSubDirectory(Directory subDir){
        subDirectories.add(subDir);
        subDir.listElements();
    }

    public void addFile(File file){
        files.add(file);
    }

}
