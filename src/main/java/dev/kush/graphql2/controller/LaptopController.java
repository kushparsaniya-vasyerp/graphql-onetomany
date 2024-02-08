package dev.kush.graphql2.controller;

import dev.kush.graphql2.model.Laptop;
import dev.kush.graphql2.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @QueryMapping(value = "allLaptops")
    private List<Laptop> getAllLaptops(){
        return laptopService.getAllLaptops();
    }

    @QueryMapping(value = "findLaptop")
    private Laptop getLaptopById(@Argument Long laptopId){
        return laptopService.getLaptopById(laptopId);
    }

    @MutationMapping(value = "addLaptop")
    private Laptop createLaptop(@Argument Laptop laptop){
        return laptopService.createLaptop(laptop);
    }

    @MutationMapping(value = "deleteLaptop")
    private Laptop deleteLaptop(@Argument Long laptopId){
        return laptopService.deleteLaptop(laptopId);
    }

    @MutationMapping(value = "updateLaptop")
    private Laptop updateLaptop(@Argument Laptop laptop){
        return laptopService.updateLaptop(laptop);
    }

}
