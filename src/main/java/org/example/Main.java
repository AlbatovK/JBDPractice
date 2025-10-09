package org.example;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchMethodException {
//        File file = new File("a.txt");
//        try {
//            boolean result = file.createNewFile();
//            System.out.println(result);
//
//            System.out.println(file.getName());
//            System.out.println(file.getAbsoluteFile());
//            System.out.println(file.length());
//            System.out.println(file.isDirectory());
//            System.out.println(file.lastModified());
//
//            File dir = new File("directory");
//            result = dir.mkdir();
//            System.out.println(result);
//            System.out.println(dir.isDirectory());
//
//            File src = new File("src");
//            for (File f: src.listFiles()) {
//                System.out.println(f.getName());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try (BufferedReader out = new BufferedReader(new FileReader("a.txt"));
//             FileWriter in = new FileWriter("a.txt")) {
//            String text = "Hello, world!";
//            in.write(text);
//            in.append("\nSecondLine");
//            in.flush();
//
//            String s;
//            while ((s = out.readLine()) != null) {
//                System.out.println(s);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//        Scanner scanner = new Scanner(System.in);


//        Files.readAllLines(Path.of(".../..."));
//        Path path = Path.of("..");
//        path.toAbsolutePath();
//        Files.copy();
//        Files.createTempFile();



        Sample obj = new Sample("Java Reflection API");

        Class<? extends Sample> cls = obj.getClass();
        System.out.println(cls.getName());

        Constructor<? extends Sample> constructor = cls.getConstructor(String.class);
        System.out.println(constructor.getName());

    }
}

class Sample {
    private final String str;

    public Sample(String str) {
        this.str = str;
    }

    public void printStr() {
        System.out.println(str);
    }

    private void privateMethod() {
        System.out.println("Private method");
    }
}
