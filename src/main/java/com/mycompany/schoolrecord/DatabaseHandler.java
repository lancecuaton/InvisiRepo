package com.mycompany.schoolrecord;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    private static final String DATABASE_URL = "jdbc:sqlite:students.db";

    public DatabaseHandler() {
        createTable();
    }

    private void createTable() {

        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                "givenName TEXT, " +
                "middleName TEXT, " +
                "surname TEXT, " +
                "age INTEGER, " +
                "year INTEGER, " +
                "major TEXT, " +
                "section INTEGER, " +
                "studentID INTEGER PRIMARY KEY, " +
                "phone TEXT, " +
                "dob TEXT)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStudent(Student student) {

        String sql = "INSERT INTO students " +
                "(givenName, middleName, surname, age, year, major, section, studentID, phone, dob) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getGivenName());
            pstmt.setString(2, student.getMiddleName());
            pstmt.setString(3, student.getSurname());
            pstmt.setInt(4, student.getAge());
            pstmt.setInt(5, student.getYear());
            pstmt.setString(6, student.getMajor());
            pstmt.setInt(7, student.getSection());
            pstmt.setInt(8, student.getStudentID());
            pstmt.setString(9, student.getPhone());
            pstmt.setString(10, student.getDob());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> fetchAllStudents() {

        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Student student = new Student.StudentBuilder()
                        .withGivenName(rs.getString("givenName"))
                        .withMiddleName(rs.getString("middleName"))
                        .withSurname(rs.getString("surname"))
                        .withAge(rs.getInt("age"))
                        .withYear(rs.getInt("year"))
                        .withMajor(rs.getString("major"))
                        .withSection(rs.getInt("section"))
                        .withStudentID(rs.getInt("studentID"))
                        .withPhone(rs.getString("phone"))
                        .withDob(rs.getString("dob"))
                        .build();

                list.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}