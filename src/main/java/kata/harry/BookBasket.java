package kata.harry;

import java.math.BigDecimal;
import java.util.List;

public class BookBasket {

    public static final BigDecimal UNITARY_BOOK_PRICE = new BigDecimal("8");
    private final List<Book> books;

    public BookBasket(List<Book> books) {
        this.books = books;
    }

    public BigDecimal getPrice() {
        return UNITARY_BOOK_PRICE;
    }
}
