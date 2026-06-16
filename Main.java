import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("бег");
        hobbies.add("чтение");
        Person person = new Person("Максим", 23, hobbies);

        System.out.println("Имя: " + person.name());
        System.out.println("Возраст: " + person.age());
        System.out.println("Хобби: " + person.hobbies());

        hobbies.add("большой теннис");

        Person updated = person.withHobbies(hobbies);
        System.out.println("Новое хобби: " + updated.hobbies());

    }
}
