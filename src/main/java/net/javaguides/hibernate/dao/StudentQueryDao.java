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

            String inStr = "'Krunal', 'Sameer', 'Aman', 'Ramesh'";
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

            System.out.println("results size>>>>>>>>>"+results.size());
            results.forEach(s -> System.out.println(s));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getStudentForCondition() {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            String fName = "Krunal";
            String lName = "Singh";
            //String email = "krunal@gmail.com";
            String email = null;
            String fromQuery = "FROM Student S where";
            StringBuffer sb = new StringBuffer();
            if (fName != null){
                sb.append(" S.firstName = :firstName");
            }
            if (email != null){
                sb.append(" and S.email = :email");
            }

            fromQuery = fromQuery + sb.toString();

            Query query = session.createQuery(fromQuery);
            if (fName != null){
                query.setParameter("firstName", fName);
            }
            if (email != null){
                query.setParameter("email", email);
            }

            List list = query.list();
            System.out.println("fromQuery>>>>>>"+fromQuery);
            System.out.println("query>>>>>>"+query);

            list.forEach(s -> System.out.println(s));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
