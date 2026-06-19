public class Book {
    private String title;
    private int year;
    private int pages;

    public Book(String title, int year, int pages) {
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public int getPages() { return pages; }

    public String toString() {
        return "\"" + title + "\" (" + year + ", " + pages + " стр.)";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book b = (Book) o;
        return year == b.year && pages == b.pages && title.equals(b.title);
    }

    public int hashCode() {
        return java.util.Objects.hash(title, year, pages);
    }
}
