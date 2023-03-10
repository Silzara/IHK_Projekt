package com.example.bildorganisator_ihk_projekt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Find {
    public Find() throws IOException {
        Path search = Path.of(Browse.selectFolder());
        Stream<Path> stream =
                Files.find(search, 100,
                        (path, basicFileAttributes) -> {
                            File file = path.toFile();
                            return !file.isDirectory() &&
                                    file.getName().contains(".jpg") || file.getName().contains(".png");
                        });
        stream.forEach(System.out::println);
    }
    public static void main(String[] args) throws IOException {
        new Find();
    }
}