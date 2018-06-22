package task3_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] studentInfo = reader.readLine().split("\\s+");
        String studentFirstName = studentInfo[0];
        String studentLastName = studentInfo[1];
        String studentFacultyNumber = studentInfo[2];

        Student student = null;
        try {
            student = new Student(studentFirstName, studentLastName, studentFacultyNumber);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String[] workerInfo = reader.readLine().split("\\s+");
        String workerFirstName = workerInfo[0];
        String workerLastName = workerInfo[1];
        double workerSalary = Double.parseDouble(workerInfo[2]);
        double workerWorkingHours = Double.parseDouble(workerInfo[3]);

        Worker worker = null;
        try {
            worker = new Worker(workerFirstName, workerLastName, workerSalary, workerWorkingHours);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        if (student != null) {
            System.out.println(student.toString());
        }
        if (worker != null) {
            System.out.println(worker.toString());
        }
    }
}
