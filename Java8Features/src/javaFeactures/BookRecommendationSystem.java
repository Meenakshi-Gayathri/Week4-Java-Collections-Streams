package javaFeactures;

import java.util.*;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String toString() {
        return title + " | Rating: " + rating;
    }

    public double getRating() {
        return rating;
    }
}

public class BookRecommendationSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String title = in.nextLine();
            String author = in.nextLine();
            String genre = in.nextLine();
            double rating = in.nextDouble();
            in.nextLine();
            books.add(new Book(title, author, genre, rating));
        }

        List<BookRecommendation> top10Recommendations = books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase("Science Fiction") && b.getRating() > 4.0)
                .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
                .sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed())
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Page 1:");
        top10Recommendations.stream().limit(5).forEach(System.out::println);

        if (top10Recommendations.size() > 5) {
            System.out.println("\nPage 2:");
            top10Recommendations.stream().skip(5).limit(5).forEach(System.out::println);
        }
    }
}
