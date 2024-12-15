package aoc2024.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {
    protected List<char[]> input;

    Day4(){
        input = new ArrayList<>();
        readValues();
    }
    private void readValues(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.trim().isEmpty()) {
                input.add(line.trim().toCharArray());
            } else {
                break;
            }
        }
        sc.close();
    }
}
