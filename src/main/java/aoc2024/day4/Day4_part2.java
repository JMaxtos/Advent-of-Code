package aoc2024.day4;

public class Day4_part2 extends Day4 {
    private final char[][] xmasMatrix;
    private final int[][] possibleDirections = {
            {1, 1},   // Down-Right
            {-1, -1}, // Up-Left
            {1, -1},  // Down-Left
            {-1, 1}   // Up-Right
    };

    public Day4_part2() {
        super();
        xmasMatrix = input.toArray(new char[0][]);
        int numberOfXMAS = countX_MAS();
        System.out.println("NumberOfX-Mas: " + numberOfXMAS);
    }

    private int countX_MAS() {
        int numberOfX_MAS = 0;
        for (int i = 0; i < xmasMatrix.length; i++) {
            for (int j = 0; j < xmasMatrix[i].length; j++) {
                for (int[] direction : possibleDirections) {
                    int directionX = direction[0];
                    int directionY = direction[1];
                    if (isXMAS(i, j, directionX, directionY)) {
                        numberOfX_MAS++;
                    }
                }
            }
        }
        return numberOfX_MAS;
    }

    private boolean isXMAS(int x, int y, int directionX, int directionY) {

        String target = "MAS";
        if (xmasMatrix[x][y] == 'A'||xmasMatrix[x][y] =='X') {
            return false;
        }
        for (int i = 0; i < target.length(); i++) {
            int nextX = x + i * directionX;
            int nextY = y + i * directionY;

            if (nextX < 0 || nextX >= xmasMatrix.length || nextY < 0 || nextY >= xmasMatrix[0].length || xmasMatrix[nextX][nextY] != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    /* Need to check all the possibilities can't be done with the directions matrix */

    public static void main(String[] args) {
        Day4_part2 d = new Day4_part2();
    }

}
