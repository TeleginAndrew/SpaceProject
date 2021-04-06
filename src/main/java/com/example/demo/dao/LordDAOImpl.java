package com.example.demo.dao;

import com.example.demo.entity.Lord;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository

public class LordDAOImpl implements LordDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Lord> showTopYoungestLords() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Lord order by age asc  ", Lord.class);
        query.setMaxResults(10);
        List<Lord> lords = query.getResultList();

        return lords;
    }

    @Override
    public List<Lord> showDoNothingLords() {
        Session session = entityManager.unwrap(Session.class);
        List<Lord> lords = session.createQuery("from Lord l left join Planet p on l.id = p.lord where p.lord is null ").getResultList();
        return lords;
    }
}
