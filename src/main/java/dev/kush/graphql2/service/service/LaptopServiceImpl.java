package dev.kush.graphql2.service.service;

import dev.kush.graphql2.model.Laptop;
import dev.kush.graphql2.repository.LaptopRepository;
import dev.kush.graphql2.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;
    @Override
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop getLaptopById(Long laptopId) {
        return findLaptopById(laptopId);
    }

    @Override
    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public Laptop deleteLaptop(Long laptopId) {
        Laptop laptop = findLaptopById(laptopId);
        laptopRepository.delete(laptop);
        return laptop;
    }

    @Override
    public Laptop updateLaptop(Laptop laptop) {
        Laptop existingLaptop = findLaptopById(laptop.getLaptopId());

        if (laptop.getBrand() != null && !laptop.getBrand().isEmpty()){
            existingLaptop.setBrand(laptop.getBrand());
        }

        if (laptop.getModel()!= null &&!laptop.getModel().isEmpty()){
            existingLaptop.setModel(laptop.getModel());
        }

        if (laptop.getPrice().longValue() > 0){
            existingLaptop.setPrice(laptop.getPrice());
        }

        if (laptop.getIsOnSale()!= null){
            existingLaptop.setIsOnSale(laptop.getIsOnSale());
        }

        return laptopRepository.save(existingLaptop);
    }

    private Laptop findLaptopById(Long laptopId) {
        return laptopRepository.findById(laptopId).orElseThrow(() -> new RuntimeException("Could not find laptop"));
    }
}
