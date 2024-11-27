package services;

import data.RequestData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DataBaseManager {
    private static final SessionFactory sessionFactory;

    // Статический блок инициализации
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Инициализация SessionFactory завершилась неудачей: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static String addRequestData(RequestData requestData) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(requestData);
            transaction.commit();
            return "данные успешно добавлены: " + requestData;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.toString();
        }
    }

    public static List<RequestData> getAllRequests() {
        List<RequestData> list;
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("from RequestData", RequestData.class).getResultList();
        }
        return list;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
