package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;


    //ToDO: Find all Whiskey for year

    @Transactional
    public List<Whisky> findAllWhiskiesForYear(int year) {
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Whisky.class); //I want a Whisky back, the ones with the right age

        cr.add(Restrictions.eq("year", year));

        results = cr.list();
        return results;
    }

    //ToDO: Find all Whiskey from Region

    @Transactional
    public List<Whisky> findAllWhiskiesFromRegion(String region){

        List<Whisky> results = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class); //Whiskey that are being given

        cr.createAlias("distilleries", "distillery");
        cr.add(Restrictions.eq("distillery.region", region));
        results = cr.list();
        return results; //return the arraylist called Whiskey

    }

    //ToDO: Find all Whiskey from a given distillery when also given an age

    @Transactional
    public List<Whisky> findAllWhiskiesFromDistilleryOfGivenAge(String distilleryName, int age) {

        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);
        cr.createAlias("distillery", "distillery");
        cr.add(Restrictions.eq("distillery.name", distilleryName));
        cr.add(Restrictions.eq("age", age));
        results = cr.list();

        return results;

    }


}