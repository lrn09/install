package com.company.javaCore.install;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static StringBuilder doSomeFiles(File file) {
        StringBuilder stringBuilder = new StringBuilder();

        if (!file.getName().endsWith("/")) {
            file.mkdir();
            stringBuilder.append("Директория " + file.getName() + " создана\n");
        } else {
            try {
                file.createNewFile();
                stringBuilder.append("Файл " + file.getName() + " создан\n");

            } catch (IOException e) {
                stringBuilder.append(e.getMessage() + "\n");
            }
        }
        return stringBuilder;
    }

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        Scanner scanner = new Scanner(System.in);

        String input = "";
        while (!input.equals("ext")) {
            System.out.println("do some: ");
            input = scanner.nextLine();
            File file = new File(input);
            sb.append(doSomeFiles(file));
        }
        try (FileWriter fileWriter = new FileWriter("d://Games/temp/temp.txt")) {
            fileWriter.write(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
