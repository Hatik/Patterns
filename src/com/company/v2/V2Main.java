package com.company.v2;

import java.util.List;

public class V2Main {
    public static void main(String[] args) {
        Reader reader = new LocalFileReader();
        List<String> input = reader.getDataFromSource("input.txt");
        List<String> patterns = reader.getDataFromSource("patterns.txt");
        Parser parser = ParserFactory.getParser(ParserType.FULL_MATCH);
        System.out.println(parser.getCalculatedResult(input, patterns));
        parser = ParserFactory.getParser(ParserType.PART_MATCH);
        System.out.println(parser.getCalculatedResult(input, patterns));
        parser = ParserFactory.getParser(ParserType.LEVENSTEIN_MATCH);
        System.out.println(parser.getCalculatedResult(input, patterns));

    }
}
