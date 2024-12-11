package aoc2024.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class part2 extends Day3 {
    part2() {
        super();
        int finalResult = calculateMemory();
        System.out.println("Part2: What do you get if you add up all of the results of the multiplications? " + finalResult);
    }


    private int calculateMemory() {
        int totalMemory = 0;

        //Defines the Pattern
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        Pattern doPattern = Pattern.compile("do\\s*\\(\\s*\\)");
        Pattern dontPattern = Pattern.compile("don't\\s*\\(\\s*\\)");

        boolean willMultiply = true;
        for (String corrupted : input) {
            // Checks for all the matches of the pattern
            Matcher mulMatcher = pattern.matcher(corrupted);
            Matcher doMatcher = doPattern.matcher(corrupted);
            Matcher dontMatcher = dontPattern.matcher(corrupted);

            while (mulMatcher.find()) {
                    if (willMultiply) {
                        int x = Integer.parseInt(mulMatcher.group(1));
                        int y = Integer.parseInt(mulMatcher.group(2));
                        System.out.println(x + " " + y);
                        totalMemory += x * y;
                    }
                }
            while (doMatcher.find()) {
                willMultiply = true;
            }
            while (dontMatcher.find()) {
                willMultiply = false;
            }

            }

        return totalMemory;
    }


}
