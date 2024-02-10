package com.myblog.myblog1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass1 {

    public static void main(String[] args) {
/*
        Predicate<Integer> val = y->y%2==0;
        boolean result = val.test(10);
        System.out.println(result);
        Predicate<String> val = str->str.equals("Lucky");
        boolean result = val.test("Lucky");
        System.out.println(result);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> oddNumbers = numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        System.out.println("All Given numbers");
        System.out.println(numbers);
        System.out.println("Even Numbers");
        System.out.println(evenNumbers);
        System.out.println("Odd Numbers");
        System.out.println(oddNumbers);


contain
        List<String> names = Arrays.asList("Mike", "Stallin", "Adam", "Mike");
        List<String> nameConainLetterM = names.stream().filter(s -> s.contains("M")).collect(Collectors.toList());
        System.out.println(nameConainLetterM);
        List<String> nameStartsWithLetterM = names.stream().filter(s -> s.startsWith("A")).collect(Collectors.toList());
        System.out.println(nameStartsWithLetterM);

To upper case
        List<String> names = Arrays.asList("Mike", "Stallin", "Adam", "Mike");
        List<String>  newData = names.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        List<String>  newData2 = names.stream().sorted().collect(Collectors.toList());
        List<String>  newData3 = names.stream().distinct().collect(Collectors.toList());

        System.out.println(names);
        System.out.println(newData);
        System.out.println(newData2);
        System.out.println(newData3);

Consumer Functional interface
        Consumer<Integer> result = number-> System.out.println(number);
        result.accept(100);

Consumer Functional interface with for each
        List<String> names = Arrays.asList("mike", "adam", "sam");
        Consumer<String> val = name-> System.out.println(name);
        names.forEach(val);

Supplier functional interface
        Supplier<Integer> numbers = ()->new Random().nextInt(500);
        Integer i = numbers.get();
        System.out.println(i);
*/


        List<Login> logins = Arrays.asList(new Login("mike", "testing"),
                                           new Login("Stallin","testing"),
                                           new Login("adam","testing"));
        List<LoginDtoo> dtos = logins.stream().map(login -> mapToDto(login)).collect(Collectors.toList());
        System.out.println(dtos);
    }
    static LoginDtoo mapToDto(Login login){
        LoginDtoo dto = new LoginDtoo();
        dto.setUserName(login.getUserName());
        dto.setPassword(login.getPassword());
        return dto;
    }
}
