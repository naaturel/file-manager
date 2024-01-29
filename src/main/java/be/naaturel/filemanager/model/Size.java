package be.naaturel.filemanager.model;

import java.io.IOException;

public class Size {

    private long value;

    public Size(){
        this.value = 0;
    }

    public Size(long value){
        this.value = value;
    }

    public void setValue(long value){
        this.value = value;
    }

    public double getValue(){
        return (double) value;
    }

    public double toMb() {
        return (double) value /1000000L;
    }

    public double toGb() {
        return (double) value /1000000000L;
    }

}
