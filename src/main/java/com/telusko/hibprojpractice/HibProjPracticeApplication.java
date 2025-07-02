package com.telusko.hibprojpractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibProjPracticeApplication {
    public static void main(String[] args) {
        student s1 = new student();
        s1.setSid(105);
        s1.setSname("Tony");
        s1.setMarks(100);
        System.out.println(s1);

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(student.class);
        SessionFactory sf = cfg.buildSessionFactory();

        Session sesssion = sf.openSession();
        Transaction tx = sesssion.beginTransaction();
        sesssion.persist(s1);
        tx.commit();
        sesssion.close();
        sf.close();

    }
}