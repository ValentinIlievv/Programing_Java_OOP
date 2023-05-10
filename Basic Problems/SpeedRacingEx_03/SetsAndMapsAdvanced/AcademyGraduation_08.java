package SetsAndMapsAdvanced;

import java.util.*;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> studentsGradesMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String studentsName = scanner.nextLine();
            double[] studentsGrades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            studentsGradesMap.put(studentsName, studentsGrades);
        }

        for (String student : studentsGradesMap.keySet()) {

            double averageGrade = getAverageGrade(studentsGradesMap.get(student));
            System.out.println(student + " is graduated with " + averageGrade);
        }
    }

    private static double getAverageGrade(double[] studentsGradesArr) {

        double averageGrade = 0;

        for (int i = 0; i < studentsGradesArr.length; i++) {
            double currentGrade = studentsGradesArr[i];
            averageGrade += currentGrade;
        }
        return averageGrade / studentsGradesArr.length;
    }
}
