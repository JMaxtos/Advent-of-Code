package aoc2024.day2;

import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
    public int[][] levels;

    public Day2() {
        levels = new int[1000][];
        readValues();
    }

    private void readValues() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.trim().isEmpty()) {
                String[] parts = line.trim().split("\\s+");
                levels[i] = new int[parts.length];
                int j = 0;
                while (j < parts.length) {
                    levels[i][j] = Integer.parseInt(parts[j]);
                    j++;
                }
            } else {
                break;
            }
            i++;
        }
        sc.close();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < levels.length; i++) {
            for (int j = 0; j < levels[i].length; j++) {
                sb.append(levels[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

