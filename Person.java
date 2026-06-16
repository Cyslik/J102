import java.util.ArrayList;
import java.util.List;

public record Person(String name, int age, List<String> hobbies) {
    public Person {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        
        hobbies = new ArrayList<>(hobbies);
    }

    public Person withHobbies(List<String> newHobbies) {
        return new Person(name, age, newHobbies);
    }
}
