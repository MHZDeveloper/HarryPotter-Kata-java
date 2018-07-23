package kata.harry;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class BookBasket {

    public static final BigDecimal UNITARY_BOOK_PRICE = new BigDecimal("8");
    private final List<Book> books;
    private final static Map<Integer, BigDecimal> DISCOUNT_TABLE = new HashMap<>();
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
        HashSet<Book> books = new HashSet<>(this.books);
        BigDecimal discount = DISCOUNT_TABLE.get(books.size());

        BigDecimal ratio = BigDecimal.valueOf(1).subtract(discount);
        return UNITARY_BOOK_PRICE.multiply(BigDecimal.valueOf(this.books.size())).multiply(ratio);
    }
}
