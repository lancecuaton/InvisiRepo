package com.mycompany.schoolrecord;

public class Student {

    private final String givenName;
    private final String middleName;
    private final String surname;
    private final int age;
    private final int year;
    private final String major;
    private final int section;
    private final int studentID;
    private final String phone;
    private final String dob;

    private Student(StudentBuilder builder) {
        this.givenName = builder.givenName;
        this.middleName = builder.middleName;
        this.surname = builder.surname;
        this.age = builder.age;
        this.year = builder.year;
        this.major = builder.major;
        this.section = builder.section;
        this.studentID = builder.studentID;
        this.phone = builder.phone;
        this.dob = builder.dob;
    }

    public String getGivenName() { return givenName; }
    public String getMiddleName() { return middleName; }
    public String getSurname() { return surname; }
    public int getAge() { return age; }
    public int getYear() { return year; }
    public String getMajor() { return major; }
    public int getSection() { return section; }
    public int getStudentID() { return studentID; }
    public String getPhone() { return phone; }
    public String getDob() { return dob; }

    @Override
    public String toString() {
        return studentID + " | " + givenName + " " + surname + " | " + major;
    }

    public static class StudentBuilder {

        private String givenName;
        private String middleName;
        private String surname;
        private int age;
        private int year;
        private String major;
        private int section;
        private int studentID;
        private String phone;
        private String dob;

        public StudentBuilder withGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public StudentBuilder withMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public StudentBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder withYear(int year) {
            this.year = year;
            return this;
        }

        public StudentBuilder withMajor(String major) {
            this.major = major;
            return this;
        }

        public StudentBuilder withSection(int section) {
            this.section = section;
            return this;
        }

        public StudentBuilder withStudentID(int studentID) {
            this.studentID = studentID;
            return this;
        }

        public StudentBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public StudentBuilder withDob(String dob) {
            this.dob = dob;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}