package com.mycompany.schoolrecord;

import java.util.List;

public class Record {

    public static void main(String[] args) {

        DatabaseHandler db = new DatabaseHandler();

        // Insert sample data (run once only to avoid duplicate ID error)
        db.insertStudent(new Student.StudentBuilder()
                .withGivenName("Juan")
                .withMiddleName("A.")
                .withSurname("Dela Cruz")
                .withAge(20)
                .withYear(2)
                .withMajor("BSIT")
                .withSection(1)
                .withStudentID(1)
                .withPhone("09123456789")
                .withDob("2004-01-01")
                .build());

        List<Student> students = db.fetchAllStudents();

        System.out.println("MASTER LIST OF STUDENTS");
        System.out.println("------------------------");

        for (Student s : students) {
            System.out.println(s);
        }
    }
}x