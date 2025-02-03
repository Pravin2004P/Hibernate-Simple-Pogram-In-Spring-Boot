package org.example;

import org.example.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        User user1 = new User();
        user1.setId(1);
        user1.setName("Pravin");
        user1.setEmail("Pravin@gmail.com");
        user1.setPassword("Pravin@2004");
        user1.setGender("male");
        user1.setCity("Jalna");

        cfg.configure("hibernate.cfg.xml"); // updated path
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(user1);                 //insert

            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

    }
}