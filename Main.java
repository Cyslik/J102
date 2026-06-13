import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Максим", 23,
                new ArrayList<>(List.of("бег", "чтение")));

        System.out.println("Имя: " + person.name());
        System.out.println("Возраст: " + person.age());
        System.out.println("Хобби: " + person.hobbies());

        List<String> newHobbies = new ArrayList<>(person.hobbies());
        newHobbies.add("большой тенис");

        Person updated = new Person(person.name(), person.age(), newHobbies);
        System.out.println("Новое хобби: " + updated.hobbies());


    }
}
