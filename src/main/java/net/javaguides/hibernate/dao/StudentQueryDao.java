package net.javaguides.hibernate.dao;

import net.javaguides.hibernate.entity.Student;
import net.javaguides.hibernate.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentQueryDao {

    public void getStudent(int id) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String fromQuery = "FROM Student S ";
            String whereQuery = "WHERE S.firstName in (:firstName)";

            //String[] names = new String[]{"Krunal", "Sameer", "aman"};

            String inStr = "'Krunal', 'Sameer', 'Aman', 'atul'";
            String[] names = inStr.split(",");
            List nameList = new ArrayList<>();
            for (String str : names){
                String trim = str.trim().replaceAll("'", "");
               // String s = trim.replaceAll("'", "");
                nameList.add(trim);
            }

            String hqlQuery = fromQuery.concat(whereQuery);
            Query query = session.createQuery(hqlQuery);
            query.setParameterList("firstName", nameList);

            System.out.println("query>>>>>"+query.toString());

            List<Student> results = (List<Student>) query.list();

            results.forEach(s -> System.out.println(s));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
