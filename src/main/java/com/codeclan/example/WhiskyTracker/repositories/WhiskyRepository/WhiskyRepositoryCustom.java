package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {

    //TODO: Put method prototypes for custom queries here

    List<Whisky> findAllWhiskiesForYear(int year);

    List<Whisky> findAllWhiskiesFromRegion(String region);

    List<Whisky> findAllWhiskiesFromDistilleryOfGivenAge(String distilleryName, int age);
}
