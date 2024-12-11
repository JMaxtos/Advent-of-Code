package aoc2024.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3part2 extends Day3 {
    Day3part2() {
        super();
        int finalResult = calculateMemory();
        System.out.println("Part2: What do you get if you add up all of the results of the multiplications? " + finalResult);
    }


    private int calculateMemory() {
        int totalMemory = 0;
        boolean willMultiply = true;
        //Defines the Pattern
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        Pattern doPattern = Pattern.compile("do\\s*\\(\\s*\\)");
        Pattern dontPattern = Pattern.compile("don't\\s*\\(\\s*\\)");
        for (String corrupted : input) {
            Matcher matcher = Pattern.compile(pattern.pattern() + "|" + doPattern.pattern() + "|" + dontPattern.pattern()).matcher(corrupted);
            while (matcher.find()) {
                if (matcher.group(1) != null) {
                    if (willMultiply) {
                        int x = Integer.parseInt(matcher.group(1));
                        int y = Integer.parseInt(matcher.group(2));
                        totalMemory += x * y;
                    }
                } else if (matcher.group(0).startsWith("don't")) {
                    willMultiply = false;
                } else if (matcher.group(0).startsWith("do")) {
                    willMultiply = true;

                }
            }
        }
        return totalMemory;
    }
    public static void main(String[] args) {
        Day3part2 d = new Day3part2();
    }
}
