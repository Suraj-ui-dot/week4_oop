// File: LibrarySystem.java

// Base class
class LibraryItem {
       String title;
        String author;
         int id;

    public LibraryItem(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public void getInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ID: " + id);
    }
}

// Subclass Book
class Book extends LibraryItem {
    

    public Book(String title, String author, int id) {
        super(title, author, id);
    
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Type: Book");
    }
}

// Subclass Magazine
class Magazine extends LibraryItem {
     int issueNumber;
     String publicationFrequency;

    public Magazine(String title, String author, int id, int issueNumber, String publicationFrequency) {
        super(title, author, id);
        this.issueNumber = issueNumber;
        this.publicationFrequency = publicationFrequency;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Type: Magazine");
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Publication Frequency: " + publicationFrequency);
    }
}

// Subclass Newspaper
class Newspaper extends LibraryItem {
     String publicationDate;

    public Newspaper(String title, String author, int id, String publicationDate) {
        super(title, author, id);
        this.publicationDate = publicationDate;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Type: Newspaper");
        System.out.println("Publication Date: " + publicationDate);
    }
}

// Main class
public class LibrarySystem {
    public static void main(String[] args) {
        LibraryItem[] catalog = new LibraryItem[3];

        catalog[0] = new Book("fundamental", "Joshua Bloch", 1);
        catalog[1] = new Magazine("kantipur", "Various", 2, 202, "Monthly");
        catalog[2] = new Newspaper("The New York Times", "NYT Editorial", 3, "2025-06-10");

        for (LibraryItem item : catalog) {
            item.getInfo();
            System.out.println("---------------------");
        }
    }
}

