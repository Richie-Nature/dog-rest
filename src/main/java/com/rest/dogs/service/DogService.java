package com.rest.dogs.service;

import com.rest.dogs.entity.Dog;
import com.rest.dogs.view.DogBreedView;
import com.rest.dogs.view.DogNameView;

import java.util.List;

public interface DogService {
    List<String> retrieveDogBreed();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogNames();

    List<Dog> retrieveDogs();
}
