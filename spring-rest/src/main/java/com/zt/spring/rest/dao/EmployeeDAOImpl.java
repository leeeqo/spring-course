package com.zt.spring.rest.dao;

import com.zt.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        //List<Employee> allEmployees = session.createQuery("from Employee").list();  //, Employee.class).getResultList();

        return allEmployees;
    }

    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        //if employee.getID ...
        session.saveOrUpdate(employee);
    }

    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("delete from Employee" +
                " where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}