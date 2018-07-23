package kata.harry;

import java.util.*;
import java.util.stream.Collectors;

public enum ComputingStrategy {

    FIVE_UNIQUE_BOOKS_FIRST(5),
    FOUR_UNIQUE_BOOKS_FIRST(4);

    private final int uniqueBooksNumber;

    ComputingStrategy(int uniqueBooksNumber) {
        this.uniqueBooksNumber = uniqueBooksNumber;
    }

    public Set<Book> applyStrategy(Set<Book> books, List<Book> originalBasket) {
        ArrayList<Book> booksList = new ArrayList<>(books);
        while (booksList.size() > uniqueBooksNumber) {
            booksList.remove(originalBasket.stream().collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .limit(1).findAny().get().getKey());
        }
        return new HashSet<>(booksList);
    }

}


