package dev.kush.graphql2.config;

import dev.kush.graphql2.model.Laptop;
import dev.kush.graphql2.model.Student;
import dev.kush.graphql2.repository.LaptopRepository;
import dev.kush.graphql2.repository.StudentRepository;
import graphql.scalars.ExtendedScalars;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class GraphqlConfig {

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.GraphQLBigDecimal);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository, LaptopRepository laptopRepository){
        return args -> {
            Student student = new Student("Kush","Parsaniya","1234567899","kush@gmail.com");

            Laptop laptop1 = new Laptop("HP","NoteBook",new BigDecimal(1000),true);
            Laptop laptop2 = new Laptop("Apple","m2",new BigDecimal(100000),false);

            student.setLaptops(List.of(laptop1,laptop2));
            laptop1.setStudent(student);
            laptop2.setStudent(student);

            studentRepository.save(student);
        };
    }
}
