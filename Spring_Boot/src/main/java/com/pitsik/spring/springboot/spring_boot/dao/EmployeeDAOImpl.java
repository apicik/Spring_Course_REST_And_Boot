package com.pitsik.spring.springboot.spring_boot.dao;

import com.pitsik.spring.springboot.spring_boot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

//    @Autowired
//    private SessionFactory sessionFactory; // hibernate
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

////        Session session = sessionFactory.getCurrentSession(); // hibernate
//        Session session = entityManager.unwrap(Session.class); // hibernate
//
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();

        Query query = entityManager.createQuery("from Employee"); // JPA
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
////        Session session = sessionFactory.getCurrentSession(); // hibernate
//        Session session = entityManager.unwrap(Session.class); // hibernate
//
//        session.saveOrUpdate(employee);

        Employee employeeFromDB = entityManager.merge(employee); // JPA
        employee.setId(employeeFromDB.getId());

    }

    @Override
    public Employee getEmployee(int id) {
////        Session session = sessionFactory.getCurrentSession(); // hibernate
//        Session session = entityManager.unwrap(Session.class); // hibernate
//
//        Employee employee = session.get(Employee.class, id);

        Employee employee = entityManager.find(Employee.class, id); // JPA

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
////        Session session = sessionFactory.getCurrentSession(); // hibernate
//        Session session = entityManager.unwrap(Session.class); // hibernate
//
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");

        Query query = entityManager.createQuery("delete from Employee where id =:employeeId"); // JPA

        query.setParameter("employeeId", id);
        query.executeUpdate();

    }
}
