package net.javaguides.hibernate.dao;

import net.javaguides.hibernate.entity.Student;
import net.javaguides.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentQueryDao {

    public void getStudent(int id) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            //String hql = " FROM Student s WHERE s.id = :studentId";
            String inQuery = "'Sameer', 'Atul', 'Krunal'";
            //String hql = "FROM Student S WHERE S.id = :studentId";
            String hql = "FROM Student S WHERE S.firstName in (:studentName)";
            Query query = session.createQuery(hql);
            //query.setParameter("studentId", id);
            query.setParameter("studentName", inQuery);
            System.out.println("query>>>>>>>" + query);
            List<Student> results = (List<Student>) query.list();

            results.forEach(s -> System.out.println(s));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
