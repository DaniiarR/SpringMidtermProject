package kg.iau.midtermproject.dao;

import kg.iau.midtermproject.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);

        List<Customer> customerList = query.getResultList();

        return customerList;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Customer.class, id);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }
}
