package be.naaturel.filemanager.model;

import java.util.List;

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

    public List<Directory> getSubDirs(){
        return this.dir.getSubDirectories().get(0).getSubDirectories();
    }

    public double getSize() {
        return this.dir.getSize("gb");
    }
}
