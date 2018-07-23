package kata.harry;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BookBasketTest {

    @Test
    public void should_return_8_if_basket_contains_one_book() {
        BookBasket bookBasket = new BookBasket(Arrays.asList(Book.VOLUME_1));

        assertThat(bookBasket.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(8));
    }
}