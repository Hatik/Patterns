package com.company.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevenshteinParser implements Parser {
    @Override
    public List<String> getCalculatedResult(List<String> input, List<String> pattern) {
        List<String> result = new ArrayList<>();
        for(String str : input) {
            for(String strPattern : pattern) {
                if (calculate(str, strPattern) > 1) continue;
                result.add(str);
            }
        }
        return result;
    }

    private int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    private int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    private int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
}
