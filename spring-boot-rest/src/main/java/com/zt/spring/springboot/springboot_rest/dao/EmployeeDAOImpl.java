package com.zt.spring.springboot.springboot_rest.dao;

import com.zt.spring.springboot.springboot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
//import org.hibernate.Session;
//import org.hibernate.query.Query; // try to use JPA, not Hibernate
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    public List<Employee> getAllEmployees() {
        //Session session = sessionFactory.getCurrentSession();
        /*Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();*/
        //List<Employee> allEmployees = session.createQuery("from Employee").list();  //, Employee.class).getResultList();

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    public void saveEmployee(Employee employee) {
        //Session session = entityManager.unwrap(Session.class);

        //if employee.getID ...
        //session.saveOrUpdate(employee);

        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    public Employee getEmployee(int id) {
        /*Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, id);*/

        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    public void deleteEmployee(int id) {
        /*Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("delete from Employee" +
                " where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();*/

        Query query = entityManager.createQuery("delete from Employee" +
                "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}