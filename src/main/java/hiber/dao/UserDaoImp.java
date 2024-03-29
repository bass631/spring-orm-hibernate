package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> getListUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("SELECT u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public List<User> findUsersListByModelAndSeriesCar(String model, int series) {
        Query<User> query = sessionFactory.getCurrentSession()
                .createQuery("SELECT u from User u where u.userCar.model = :model and u.userCar.series = :series", User.class)
                .setParameter("model", model)
                .setParameter("series", series);
        return query.getResultList();
    }

}
