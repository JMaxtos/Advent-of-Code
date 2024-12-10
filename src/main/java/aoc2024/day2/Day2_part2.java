package aoc2024.day2;

public class Day2_part2 extends Day2 {

    public Day2_part2() {
        super();
        int safeReports = checkLevels();
        System.out.println("Number of safe reports: " + safeReports);
    }

    private int checkLevels() {
        int safeReports = 0;
        for (int[] report : levels) {
            if (report == null) {
                continue;
            }
            if (isSafeReport(report) || canBeMadeSafe(report)) {
                safeReports++;
            }
        }
        return safeReports;
    }

    private boolean isSafeReport(int[] report) {
        int[] validate = new int[report.length - 1];
        for (int i = 0; i < report.length - 1; i++) {
            if (Math.abs(report[i] - report[i + 1]) > 3) {
                return false;
            } else {
                int INCREASING = 1;
                int DECREASING = 0;
                if (report[i] > report[i + 1] && i != 0 && validate[i - 1] == INCREASING) {
                    return false;
                }
                if (report[i] < report[i + 1] && i != 0 && validate[i - 1] == DECREASING) {
                    return false;
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
        return true;
    }

    private boolean canBeMadeSafe(int[] report) {
        for (int i = 0; i < report.length; i++) {
            int[] modifiedReport = new int[report.length - 1];
            for (int j = 0, k = 0; j < report.length; j++) {
                if (j != i) {
                    modifiedReport[k++] = report[j];
                }
            }
            if (isSafeReport(modifiedReport)) {
                return true;
            }
        }
        return false;
    }
}
