package net.javaguides.hibernate.dao;

import net.javaguides.hibernate.entity.Student;

public class Client {
    public static void main(String[] args) {
        StudentQueryDao dao = new StudentQueryDao();
        //dao.getStudent(2);
        dao.getStudentForCondition();
    }
}
