package net.javaguides.hibernate;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.entity.Student;

import java.util.List;

public class App {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        //Student student = new Student("Krunal", "pandey", "Krunal@gmail.com");
        studentDao.saveStudent(student);

        //studentDao.insertStudent();
        //studentDao.insertStudentByQuery("ajitk433@gmail.com", "Ajit", "Kumar");

        // update student
       // Student student1 = new Student("Ram", "Fadatare", "rameshfadatare@javaguides.com");
       // studentDao.updateStudent(student1);

        // get students
        //List< Student > students = studentDao.getStudents();
        //students.forEach(s -> System.out.println(s.getFirstName()));

        // get single student
        //Student student2 = studentDao.getStudent(2);
        //System.out.println(student2.getFirstName());

        // delete student
        //studentDao.deleteStudent(1);
    }
}
