package dev.kush.graphql2.service;

import dev.kush.graphql2.model.Laptop;

import java.util.List;

public interface LaptopService {
    List<Laptop> getAllLaptops();
    Laptop getLaptopById(Long laptopId);

    Laptop createLaptop(Laptop laptop);
    Laptop deleteLaptop(Long laptopId);
    Laptop updateLaptop(Laptop laptop);

}
