package be.naaturel.filemanager.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DirectoryAnalyser {


    public List<String> listFilesOf(String dir) {
        return Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                .map(File::getName)
                .collect(Collectors.toList());
    }






}
