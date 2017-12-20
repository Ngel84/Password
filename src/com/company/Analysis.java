package com.company;

import java.io.*;
import java.util.function.Predicate;

/**
 * Created by ����� on 16.12.2017.
 */
public class Analysis implements Runnable {
    static volatile boolean checkResult;


    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(Main.FILE_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String currentLine = null;
        try {
            currentLine = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inputStream = Analysis.class.getResourceAsStream("/password.txt");

        String content = null;
        try {
            content = getFileContent(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean checkResult = check(content, currentLine);
        try {
            inputStream.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean check(String content, String currentLine) {

        if (!currentLine.contentEquals(content)) {

            return false;
        }
        checkResult = true;
        return true;
    }

    private static String getFileContent(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            int read = inputStream.read(buffer);
            if (read == -1) {
                break;
            }
        }
        return new String(buffer);
    }

    public static boolean getCheckResult() {
        return checkResult;
    }

}
