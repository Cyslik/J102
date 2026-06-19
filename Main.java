import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("student.txt");

        List<Student> students = Files.lines(path)
                .map(Main::parseStudent)
                .collect(Collectors.toList());

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .reduce((a, b) -> b)
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Такая книга отсутствует")
                );
    }

    private static Student parseStudent(String line) {
        String[] tokens = line.split(";");
        String name = tokens[0];

        List<Book> books = new ArrayList<>();
        for (int i = 1; i < tokens.length; i += 3) {
            books.add(new Book(
                    tokens[i],
                    Integer.parseInt(tokens[i + 1]),
                    Integer.parseInt(tokens[i + 2])
            ));
        }
        return new Student(name, books);
    }
}