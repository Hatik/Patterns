package com.company.v2;

import java.util.ArrayList;
import java.util.List;

public class PartMatchParser implements Parser {
    @Override
    public List<String> getCalculatedResult(List<String> input, List<String> pattern) {
        List<String> result = new ArrayList<>();
        for(String str : input) {
           for(String strPattern : pattern) {
               if (str.contains(strPattern)) {
                   result.add(str);
               }
           }
        }
        return result;
    }
}
