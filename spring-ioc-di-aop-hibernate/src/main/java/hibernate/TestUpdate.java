package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestUpdate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            /*Employee employee = (Employee) session.get(Employee.class, 2);
            employee.setName("Bill");
            employee.setSurname("Harman");
            employee.setSalary(3000);*/
            session.createQuery("update Employee set name = 'Bill', surname = 'Harman', salary = '3000' where id = 2")
                    .executeUpdate();
            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
