package aoc2024.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3_part1 extends Day3 {
    public Day3_part1() {
        super();
        int finalResult = calculateMemory();
        System.out.println("Part1: What do you get if you add up all of the results of the multiplications? " + finalResult);
    }

    private int calculateMemory() {
        int totalMemory = 0;

        //Defines the Pattern
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");

        for (String corrupted : input) {
            // Checks for all the matches of the pattern
            Matcher matcher = pattern.matcher(corrupted);

            while (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));

                totalMemory += x*y;
            }
        }
        return totalMemory;
    }
    public static void main(String[] args) {
        Day3_part1 d = new Day3_part1();
    }


}
