package aoc2024.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    protected List<int[]> levels;

    public Day2() {
        levels = new ArrayList<int[]>();
        readValues();
    }

    private void readValues() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.trim().isEmpty()) {
                String[] parts = line.trim().split("\\s+");
                int[] reports = new int[parts.length];
                for (int i = 0; i < reports.length; i++) {
                    reports[i] = Integer.parseInt(parts[i]);
                }
                levels.add(reports);
            } else {
                break;
            }
        }
        sc.close();
    }

    //to String Method to make sure everything was getting read
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] report : levels) {
            for (int num : report) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

