package Streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class STream {
    public static void main(String[] args){
        List<Person> people = List.of(
            new Person ("Ahmet Furkan" ,Gender.MALE),
            new Person ("Zeynep" ,Gender.FEMALE),
            new Person ("Gül" ,Gender.FEMALE),
            new Person ("İbrahim" ,Gender.MALE),
            new Person ("Hüseyin" ,Gender.MALE)
        );
       people.stream().map((person -> person.gender)).collect(Collectors.toSet()).forEach(System.out :: println);
       people.stream().map((person -> person.name)).collect(Collectors.toSet()).forEach(System.out :: println);
       people.stream().map((person -> person.name)).mapToInt(String ::length).forEach(System.out :: println);
       
       Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
    boolean containsOnlyFemales = people.stream().anyMatch(personPredicate);
    System.out.println(containsOnlyFemales);

    }
    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){
           this.name = name;
           this.gender = gender;
        }
        
     @Override
     public String toString() {
         return "Person{" + "name= " + name + '\'' + ", gender= " + gender + '}';
     }
}
    enum Gender {
        MALE,
        FEMALE
    }
    
}
