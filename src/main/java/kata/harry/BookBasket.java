package kata.harry;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static java.math.BigDecimal.valueOf;

public class BookBasket {

    private final static BigDecimal UNITARY_BOOK_PRICE = BigDecimal.valueOf(8);
    private final static BinaryOperator<BigDecimal> bigDecimalMinBinaryOperator = (p1, p2) -> p1.compareTo(p2) > 0 ? p2 : p1;
    private final List<Book> books;
    private final Discount discount;

    public BookBasket(List<Book> books) {
        this.books = books;
        this.discount = new Discount();
    }

    public BigDecimal getPrice() {
        return Stream.of(ComputingStrategy.values())
                .map(this::computePriceWithStrategy)
                .reduce(BigDecimal.valueOf(Integer.MAX_VALUE), bigDecimalMinBinaryOperator);
    }

    private BigDecimal computePriceWithStrategy(ComputingStrategy strategy) {
        List<Book> booksCopy = new ArrayList<>(this.books);
        BigDecimal total = BigDecimal.ZERO;
        while (booksCopy.size() > 0) {
            Set<Book> uniqueBooks = strategy.applyStrategy(new HashSet<>(booksCopy), booksCopy);
            total = total.add(
                    UNITARY_BOOK_PRICE.multiply(valueOf(uniqueBooks.size()))
                            .multiply(discount.getDiscountFromVolumeSize(uniqueBooks.size())));
            booksCopy = removeUsedBooks(booksCopy, uniqueBooks);
        }
        return total;
    }

    private List<Book> removeUsedBooks(List<Book> booksCopy, Set<Book> uniqueBooks) {
        ArrayList<Book> books = new ArrayList<>(booksCopy);
        uniqueBooks.forEach(books::remove);
        return books;
    }
}
