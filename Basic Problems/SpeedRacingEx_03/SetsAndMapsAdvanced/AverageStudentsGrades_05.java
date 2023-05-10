package SetsAndMapsAdvanced;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> gradesMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String studentName = input[0];
            Double grade = Double.parseDouble(input[1]);

            if (!gradesMap.containsKey(studentName)) {
                gradesMap.put(studentName, new ArrayList<>());
                gradesMap.get(studentName).add(grade);
            } else {
                gradesMap.get(studentName).add(grade);
            }
        }

        for (String key : gradesMap.keySet()) {
            System.out.printf("%s -> ", key);
            double gradeSum = 0;
            for (Double value : gradesMap.get(key)) {
                gradeSum += value;
                System.out.printf("%.2f ", value);
            }
            System.out.printf("(avg: %.2f)%n", gradeSum / gradesMap.get(key).size());

        }
    }
}
