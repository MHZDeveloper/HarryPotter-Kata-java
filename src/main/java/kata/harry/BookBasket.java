package kata.harry;

import java.math.BigDecimal;
import java.util.*;

import static java.math.BigDecimal.valueOf;

public class BookBasket {

    private final static BigDecimal UNITARY_BOOK_PRICE = new BigDecimal("8");
    private final List<Book> books;
    private final Discount discount;


    public BookBasket(List<Book> books) {
        this.books = books;
        this.discount = new Discount();
    }

    public BigDecimal getPrice() {
        BigDecimal bestResult = BigDecimal.ZERO;
        for (ComputingStrategy strategy : ComputingStrategy.values()) {
            BigDecimal priceWithStrategy = computePriceWithStrategy(strategy);
            if (bestResult.compareTo(BigDecimal.ZERO) == 0 || bestResult.compareTo(priceWithStrategy) > 0) {
                bestResult = priceWithStrategy;
            }
        }
        return bestResult;
    }

    private BigDecimal computePriceWithStrategy(ComputingStrategy strategy) {
        List<Book> booksCopy = new ArrayList<>(this.books);
        BigDecimal total = BigDecimal.ZERO;
        while (booksCopy.size() > 0) {
            Set<Book> uniqueBooks = strategy.applyStrategy(new HashSet<>(booksCopy), booksCopy);
            total = total.add(
                    UNITARY_BOOK_PRICE.multiply(valueOf(uniqueBooks.size()))
                            .multiply(uniqueBooksRatio(uniqueBooks.size())));
            booksCopy = removeUsedBooks(booksCopy, uniqueBooks);
        }
        return total;
    }

    private BigDecimal uniqueBooksRatio(int uniqueBooksNumber) {
        return BigDecimal.ONE.subtract(discount.getDiscountFromVolumeSize(uniqueBooksNumber));
    }

    private List<Book> removeUsedBooks(List<Book> booksCopy, Set<Book> uniqueBooks) {
        ArrayList<Book> books = new ArrayList<>(booksCopy);
        uniqueBooks.forEach(books::remove);
        return books;
    }
}
