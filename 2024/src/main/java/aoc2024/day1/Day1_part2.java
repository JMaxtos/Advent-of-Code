package aoc2024.day1;

public class Day1_part2 extends Day1 {
    public Day1_part2() {
        super();
        int sumOfAppearances = countAppearances();
        System.out.println(sumOfAppearances);
    }

    private int countAppearances() {
        int totalAppearances = 0;
        for (Integer leftNumber : leftNumbers) {
            int count = 0;
            for (Integer rightNumber : rightNumbers) {
                if (leftNumber.equals(rightNumber)) {
                    count++;
                }
            }
            totalAppearances += (count * leftNumber);

        }
        return totalAppearances;
    }

    static public void main(String[] args) {
        Day1_part2 d = new Day1_part2();
    }
}
