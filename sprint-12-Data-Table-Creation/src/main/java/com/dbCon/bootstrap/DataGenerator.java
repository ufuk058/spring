package com.dbCon.bootstrap;

import com.dbCon.entity.Car;
import com.dbCon.entity.Department;
import com.dbCon.entity.Employee;
import com.dbCon.enums.Gender;
import com.dbCon.repository.CarRepository;
import com.dbCon.repository.DepartmentRepository;
import com.dbCon.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component // this annotation is for injection (connect the java class to the spring framework)
public class DataGenerator implements CommandLineRunner {

    private final CarRepository carRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeesRepository;

    public DataGenerator(CarRepository carRepository, DepartmentRepository departmentRepository, EmployeeRepository employeesRepository) {
        this.carRepository = carRepository;
        this.departmentRepository = departmentRepository;
        this.employeesRepository = employeesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Car> carlist= new ArrayList<>();
        List<Employee> employeeList= new ArrayList<>();
        List<Department> departmentList= new ArrayList<>();
        //creating some car objects
        Car car1 = new Car("BMW","M3");
        Car car2 = new Car("Audi","RS6");
        Car car3 = new Car("Lexus","CT200h");
        Car car4 = new Car("Honda","Jazz");

        //We need to save these objects to database
        carlist.addAll(Arrays.asList(car1,car1,car3,car4));
        carRepository.saveAll(carlist);

        Employee e1= new Employee("Berrie","Manueau","bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20), Gender.FEMALE,2500.00);
        Employee e2= new Employee("Aeriell","McNee","amcnee1@google.es", LocalDate.of(2009,01,26), Gender.FEMALE,2500.00);
        Employee e3= new Employee("Sydney","Symonds","ssymonds@hhs.gov", LocalDate.of(2010,05,17), Gender.FEMALE,2500.00);
        Employee e4= new Employee("Avrom","Rowantree",null, LocalDate.of(2014,03,02), Gender.MALE,2500.00);
        Employee e5= new Employee("Feliks","Morffew","fmowffew4@a8.net", LocalDate.of(2003,01,14), Gender.MALE,2500.00);
        employeeList.addAll(Arrays.asList(e1,e2,e3,e4,e5));
        employeesRepository.saveAll(employeeList);


        Department d1= new Department("Sports","Outdoors");
        Department d2= new Department("Tools","Hardware");
        Department d3= new Department("Clothing","Home");
        Department d4= new Department("Phones & Tablets","Electronics");
        Department d5= new Department("Computers","Electronics");
        departmentList.addAll(Arrays.asList(d1,d2,d3,d4,d5));
        departmentRepository.saveAll(departmentList);



    }



}
