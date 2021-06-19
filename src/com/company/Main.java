package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> input = readFromFile("input.txt");
        List<String> patterns = readFromFile("patterns.txt");
        List<String> result = new ArrayList<>();
        List<String> result2 = new ArrayList<>();
        for(String str : input) {
            for(String pattern : patterns) {
                if(str.equals(pattern)) {
                    result.add(str);
                }
                if(str.contains(pattern)) {
                    result2.add(str);
                }
            }
        }
        System.out.println(result);
        System.out.println(result2);
    }

    public static List<String> readFromFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        List<String> list = new ArrayList<>();
        while(scanner.hasNext()){
            list.add(scanner.nextLine());
        }
        fileReader.close();
        return list;
    }
}
