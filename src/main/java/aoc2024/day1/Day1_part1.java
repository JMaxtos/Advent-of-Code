package aoc2024.day1;

import java.util.*;

public class Day1_part1 {
    private final List<Integer> rightNumbers;
    private final List<Integer> leftNumbers;

    public Day1_part1() {
        rightNumbers = new ArrayList<>();
        leftNumbers = new ArrayList<>();
        readValues();
        int finalResult = calculate_distances();
        System.out.println("Total distance:" + finalResult);
    }

    private void readValues() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {

            String line = sc.nextLine();

            if (!line.trim().isEmpty()) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 2) {
                    leftNumbers.add(Integer.parseInt(parts[0]));
                    rightNumbers.add(Integer.parseInt(parts[1]));

                }
            } else {

                break;
            }
        }
        sc.close();
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


}
