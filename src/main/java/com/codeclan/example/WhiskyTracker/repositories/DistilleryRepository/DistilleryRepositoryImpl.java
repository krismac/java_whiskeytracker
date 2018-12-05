package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    //ToDO: Find all Distillerys for a given region
    @Transactional
    public List<Distillery> findAllDistilleriesFromRegion(String region) {

        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Distillery.class);
        cr.add(Restrictions.eq("region", region));
        results = cr.list();

        return results;

    }

    //ToDO: Find all Distillerys that have whiskeys over 12 years

    @Transactional
    public List<Distillery> findAllDistilleriesWithWhiskiesOfGivenAge(int age) {

        List<Distillery> results;

        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Distillery.class);
        cr.createAlias("whiskeys", "whisky");
        cr.add(Restrictions.eq("whisky.age", age));
        results = cr.list();

        return results;
    }
}



