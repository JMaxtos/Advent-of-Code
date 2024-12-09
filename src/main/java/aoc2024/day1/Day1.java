package aoc2024.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    protected final List<Integer> rightNumbers;
    protected final List<Integer> leftNumbers;

    Day1() {
        rightNumbers = new ArrayList<>();
        leftNumbers = new ArrayList<>();
        readValues();
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
}
