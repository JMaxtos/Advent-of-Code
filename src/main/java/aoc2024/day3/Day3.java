package aoc2024.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {
     protected List<String> input;

    public Day3() {
        input = new ArrayList<String>();
        readValues();
    }

    public void readValues() {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.trim().isEmpty()) {
                input.add(line.trim());
            } else {
                break;
            }
        }
        sc.close();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            sb.append(s);
            sb.append("\n");
        }
    return sb.toString();
    }

}
