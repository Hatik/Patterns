package com.company.v2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocalFileReader implements Reader {
    @Override
    public List<String> getDataFromSource(String source) {
        try(FileReader fileReader = new FileReader(source)) {
            Scanner scanner = new Scanner(fileReader);
            List<String> list = new ArrayList<>();
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Something gone wrong");
        }
    }
}
