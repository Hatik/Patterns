package com.company.v2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FullMatchParser implements Parser {
    @Override
    public List<String> getCalculatedResult(List<String> input, List<String> pattern) {
        List<String> result = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>(pattern); // HashSet эффективней будет в данном случае, но вместо него можно использовать просто pattern

        for(String str : input) {
            if (hashSet.contains(str)) {
                result.add(str);
            }
        }
        return result;
    }
}
