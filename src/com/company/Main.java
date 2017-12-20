package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static final String FILE_NAME = "C:\\Java21\\Reader.txt";
    private static FileWriter fileWriter;
    private static BufferedWriter bufferedWriter;


    public static void main(String[] args) throws IOException, InterruptedException {
        int flag = 0;
        while (flag < 3) {
            Scanner readCons = new Scanner(System.in);
            String content = readCons.nextLine();
            writeInFile(content);
            Analysis cheaker = new Analysis();
            Thread thread = new Thread(cheaker);
            thread.start();
            thread.join();
            boolean check = cheaker.getCheckResult();

            if (check) {
                System.out.println("Password");
                return;
            } else {
                System.out.println("Error password");
                flag++;
            }
        }
    }


    private static void writeInFile(String content) throws IOException {
        // String content = "��� ������ ����� �������� � ����";
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
        fileWriter = new FileWriter(FILE_NAME, false);
        bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(content);
        System.out.println("Готово");
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}