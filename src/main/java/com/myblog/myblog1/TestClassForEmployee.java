package com.myblog.myblog1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestClassForEmployee {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("mike",22,"chennai"),
                                              new Employee("stallin",23,"bangalore"),
                                              new Employee("adam",22,"pune"),
                                              new Employee("sam",34,"chennai"));
//        List<Employee> emps = employees.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.toList());
//        for (Employee e: emps){
//            System.out.println(e.getName());
//            System.out.println(e.getAge());
//            System.out.println(e.getCity());
//        }
        
//        List<Integer> numbers = Arrays.asList(10,12,6,5,7,8,9);
//        List<Integer> data = numbers.stream().filter(n1 -> n1 % 2 == 0).map(n2 -> n2 * n2).collect(Collectors.toList());
//        System.out.println(data);

        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getAge()));

        for (Map.Entry<Integer, List<Employee>> entry : collect.entrySet()){
            int age = entry.getKey();
            List<Employee> employeeWithAge = entry.getValue();
            System.out.println("age"+age+"---");
            for (Employee e : employeeWithAge){
                System.out.println(e.getName());
                System.out.println(e.getCity());
            }

        }
    }
}
