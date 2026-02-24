
package com.mycompany.schoolrecord;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseHandler db = new DatabaseHandler();

        // Insert sample students
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

        db.insertStudent(new Student.StudentBuilder()
                .withGivenName("Maria")
                .withMiddleName("B.")
                .withSurname("Santos")
                .withAge(21)
                .withYear(3)
                .withMajor("BSCS")
                .withSection(2)
                .withStudentID(2)
                .withPhone("09987654321")
                .withDob("2003-05-10")
                .build());

        List<Student> students = db.fetchAllStudents();

        System.out.println("MASTER LIST OF STUDENTS");
        System.out.println("------------------------");

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
