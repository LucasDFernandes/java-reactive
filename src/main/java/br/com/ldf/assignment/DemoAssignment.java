package br.com.ldf.assignment;

import br.com.ldf.util.Util;

public class DemoAssignment {

    public static void main(String[] args) {
        FileService.read("file1.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.write("file2.txt", Util.faker().gameOfThrones().character())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.write("file3.txt", "File will be deleted")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.delete("file3.txt")
//                .subscribe(
//                        Util.onNext(),
//                        Util.onError(),
//                        Util.onComplete()
//                )
        ;

    }
}
