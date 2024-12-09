package aoc2024.day2;

public class Day2_part1 extends Day2 {
    private final int INCREASING = 1;
    private final int DECREASING = 0;

    public Day2_part1() {
        super();
        int safeReports = checkLevels();
        System.out.println("Number of safe reports: " + safeReports);
    }

    private int checkLevels() {
        int safeReports = 0;
        int i = 0;
        for (int[] report : levels) {
            if (report == null) {
                continue;
            }
            i++;
            if (isSafeReport(report, i)) {
                safeReports++;
            }
        }
        return safeReports;
    }

    private boolean isSafeReport(int[] report, int level) {
        int[] validate = new int[report.length - 1];
        for (int i = 0; i < report.length - 1; i++) {
            if (Math.abs(report[i] - report[i + 1]) > 3) {
                return false;
            } else {
                if (report[i] > report[i + 1] && i != 0 && validate[i - 1] == INCREASING) {
                    return false;
                }
                if (report[i] < report[i + 1] && i != 0 && validate[i - 1] == DECREASING) {
                    validate[i] = DECREASING;
                }
                if (report[i] < report[i + 1]) {
                    validate[i] = INCREASING;
                }
                if (report[i] > report[i + 1]) {
                    validate[i] = DECREASING;
                }
                if (report[i] == report[i + 1]) {
                    return false;
                }
            }
        }
        for (int i = 1; i < validate.length; i++) {
            if (validate[i] != validate[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
