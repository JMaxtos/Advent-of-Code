package aoc2024.day4;

import java.util.Arrays;

public class Day4_part1 extends Day4 {
    private final char[][] xmasMatrix;
    private final String target = "XMAS";
    private final int[][] possibleDirections = {
            {0, 1},   // Right
            {0, -1},  // Left
            {1, 0},   // Down
            {-1, 0},  // Up
            {1, 1},   // Down-Right
            {-1, -1}, // Up-Left
            {1, -1},  // Down-Left
            {-1, 1}   // Up-Right
    };

    Day4_part1() {
        super();
        xmasMatrix = input.toArray(new char[0][]);
        int numberOfXMAS = countXMAS();
        System.out.println("NumberOfXMas: " + numberOfXMAS );

    }

    private int countXMAS() {
        int numberOfXMAS = 0;
        for (int i = 0; i < xmasMatrix.length; i++) {
            for (int j = 0; j < xmasMatrix[i].length; j++) {
                for (int[] direction : possibleDirections) {
                    int directionX = direction[0];
                    int directionY = direction[1];
                    if (isXMAS(i, j, directionX, directionY)) {
                        numberOfXMAS++;
                    }
                }
            }
        }
        return numberOfXMAS;
    }

    private boolean isXMAS(int x, int y, int directionX, int directionY) {
        for (int i = 0; i < target.length(); i++) {
            int nextX = x + i * directionX;
            int nextY = y + i * directionY;

            if (nextX < 0 || nextX >= xmasMatrix.length || nextY < 0 || nextY >= xmasMatrix[0].length || xmasMatrix[nextX][nextY] != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Day4_part1 d = new Day4_part1();
    }
}



