package com.telusko.hibprojpractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibProjPracticeApplication {
    public static void main(String[] args) {
        student s1 = new student();
        s1.setSid(110);
        s1.setSname("Rona");
        s1.setMarks(91);
        System.out.println(s1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(student.class)
                .configure()
                .buildSessionFactory();

//        Configuration cfg = new Configuration();
//        cfg.configure("hibernate.cfg.xml");        // The above code can also be written as this
//        cfg.addAnnotatedClass(student.class);
//       SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        student s2 = session.find(student.class,110);
        session.remove(s2);

        //sesssion.persist(s1);
        tx.commit();
        session.close();
        sf.close();
        System.out.println(s2);
    }
}