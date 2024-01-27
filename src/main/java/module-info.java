module be.naaturel.filemanager {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
        //requires eu.hansolo.tilesfx;
        
    opens be.naaturel.filemanager to javafx.fxml;
    exports be.naaturel.filemanager;
    exports be.naaturel.filemanager.controller;
    opens be.naaturel.filemanager.controller to javafx.fxml;
}