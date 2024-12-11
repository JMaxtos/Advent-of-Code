package aoc2024.day1;

import java.util.*;

public class Day1_part1 extends Day1 {

    public Day1_part1() {
        super();
        int finalResult = calculate_distances();
        System.out.println("Total distance:" + finalResult);
    }

    private int calculate_distances() {
        int distance = 0;
        Collections.sort(leftNumbers);
        Collections.sort(rightNumbers);

        for (int i = 0; i < rightNumbers.size(); i++) {

            distance += Math.abs(rightNumbers.get(i) - leftNumbers.get(i));
        }

        return distance;
    }

    public static void main(String[] args) {
        Day1_part1 day1 = new Day1_part1();
    }


}
