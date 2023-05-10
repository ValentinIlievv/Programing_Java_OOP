package CompanyRosterEx_02;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departmentMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String name = inputArr[0];
            double salary = Double.parseDouble(inputArr[1]);
            String position = inputArr[2];
            String department = inputArr[3];
            Employee employee = new Employee(name, salary, position, department);
            if (inputArr.length == 6 ){
                String email = inputArr[4];
                int age = Integer.parseInt(inputArr[5]);
                employee.setEmail(email);
                employee.setAge(age);
            }
            else if (inputArr.length == 5){
                String elementFourth = inputArr[4];
                if (elementFourth.contains("@")){

                    employee.setEmail(elementFourth);
                }
                else {
                    int age = Integer.parseInt(inputArr[4]);
                    employee.setAge(age);
                }
            }
            if (!departmentMap.containsKey(department)){
                departmentMap.put(department, new Department(department));
            }
            departmentMap.get(department).getEmployees().add(employee);

        }

        Department maxAverageSalaryDepartment = departmentMap.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));

    }
}
