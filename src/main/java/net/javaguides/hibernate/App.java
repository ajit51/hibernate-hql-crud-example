package net.javaguides.hibernate;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.entity.Student;

import java.util.List;

public class App {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        //Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        Student student = new Student("Krunal", "Singh", "krunal@gmail.com");
        studentDao.saveStudent(student);
    }
}
