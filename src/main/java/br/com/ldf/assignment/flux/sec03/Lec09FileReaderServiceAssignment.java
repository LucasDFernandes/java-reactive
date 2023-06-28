package br.com.ldf.assignment.flux.sec03;

import br.com.ldf.util.Util;

import java.nio.file.Paths;

public class Lec09FileReaderServiceAssignment {

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();

        fileReaderService.readFile(Paths.get("src/main/resources/assignment/sec01/file-flux.txt"))
                .subscribe(Util.subscriber());
    }
}
