package com.company.v2;

public class ParserFactory {
    private static final Parser fullMatch;
    private static final Parser partMatch;
    private static final Parser levensteinMatch;

    static {
        fullMatch = new FullMatchParser();
        partMatch = new PartMatchParser();
        levensteinMatch = new LevenshteinParser();
    }

    public static Parser getParser(ParserType pattern) {
        switch (pattern) {
            case PART_MATCH: return fullMatch;
            case FULL_MATCH: return partMatch;
            case LEVENSTEIN_MATCH: return levensteinMatch;
        }
        throw new RuntimeException();
    }


}
