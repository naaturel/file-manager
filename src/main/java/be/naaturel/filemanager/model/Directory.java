package be.naaturel.filemanager.model;

public class Directory {

    private final String dir;
    private Size size;

    public Directory(String dir){
        this.dir = dir;
        this.size = new Size();
    }

    public String getPath(){
        return this.dir;
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
}
