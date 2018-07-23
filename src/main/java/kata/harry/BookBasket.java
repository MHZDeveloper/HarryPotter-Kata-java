package kata.harry;

import java.math.BigDecimal;
import java.util.*;

public class BookBasket {

    private final static BigDecimal UNITARY_BOOK_PRICE = new BigDecimal("8");
    private final static Map<Integer, BigDecimal> DISCOUNT_TABLE = new HashMap<>();
    private final List<Book> books;

    static {
        DISCOUNT_TABLE.put(1, BigDecimal.ZERO);
        DISCOUNT_TABLE.put(2, BigDecimal.valueOf(0.05));
        DISCOUNT_TABLE.put(3, BigDecimal.valueOf(0.1));
        DISCOUNT_TABLE.put(4, BigDecimal.valueOf(0.2));
        DISCOUNT_TABLE.put(5, BigDecimal.valueOf(0.25));
    }

    public BookBasket(List<Book> books) {
        this.books = books;
    }

    public BigDecimal getPrice() {
        BigDecimal bestResult = BigDecimal.ZERO;
        for (ComputingStrategy stratgy : ComputingStrategy.values()) {
            BigDecimal priceWithStrategy = getPriceWithStrategy(stratgy);
            if (bestResult.compareTo(BigDecimal.ZERO) == 0 || bestResult.compareTo(priceWithStrategy) > 0) {
                bestResult = priceWithStrategy;
            }
        }
        return bestResult;
    }

    private BigDecimal getPriceWithStrategy(ComputingStrategy strategy) {

        System.out.println("################# " + strategy);

        List<Book> booksCopy = new ArrayList<>(this.books);
        BigDecimal total = BigDecimal.ZERO;
        while (booksCopy.size() > 0) {
            Set<Book> uniqueBooks = strategy.applyStrategy(new HashSet<>(booksCopy), booksCopy);
            System.out.println(uniqueBooks);

            int uniqueBooksNumber = uniqueBooks.size();
            total = total.add(
                    UNITARY_BOOK_PRICE.multiply(BigDecimal.valueOf(uniqueBooksNumber))
                            .multiply(uniqueBooksRatio(uniqueBooksNumber)));
            booksCopy = removeUsedBooks(booksCopy, uniqueBooks);
        }
        System.out.println(total);
        return total;
    }

    private BigDecimal uniqueBooksRatio(int uniqueBooksNumber) {
        return BigDecimal.ONE.subtract(DISCOUNT_TABLE.get(uniqueBooksNumber));
    }

    private List<Book> removeUsedBooks(List<Book> booksCopy, Set<Book> uniqueBooks) {
        ArrayList<Book> books = new ArrayList<>(booksCopy);
        uniqueBooks.forEach(books::remove);
        return books;
    }
}
