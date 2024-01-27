package be.naaturel.filemanager.model;

import java.io.File;
import java.io.IOException;

public class Size {

    private long value;


    public Size(long value){
        this.value = value;
    }


    public double getValue(){
        return (double) value;
    }

    public double toMb() throws IOException {
        return (double) value /1000000L;
    }

    public double toGb(String dir) throws IOException {
        return (double) value /1000000000L;
    }

}
