package com.rest.dogs.entity;

import java.util.List;

public class DogResponse {
    public List<Dog> dogs;

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
