package kata.harry;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookBasketTest {

    @Test
    public void should_return_8_if_basket_contains_one_book() {
        //Given
        List<Book> books = Arrays.asList(Book.VOLUME_1);

        //When
        BookBasket bookBasket = new BookBasket(books);

        //Then
        assertThat(bookBasket.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(8));
    }

    @Test
    public void should_return_16_if_basket_contains_two_same_books() {
        //Given
        List<Book> books = Arrays.asList(Book.VOLUME_1, Book.VOLUME_1);

        //When
        BookBasket bookBasket = new BookBasket(books);

        //Then
        assertThat(bookBasket.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(16));
    }

    @Test
    public void should_return_15_20_if_basket_contains_two_different_books() {
        //Given
        List<Book> books = Arrays.asList(Book.VOLUME_1, Book.VOLUME_2);

        //When
        BookBasket bookBasket = new BookBasket(books);

        //Then
        assertThat(bookBasket.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(15.2));
    }

    @Test
    public void should_return_21_60_if_basket_contains_three_different_books() {
        //Given
        List<Book> books = Arrays.asList(Book.VOLUME_1, Book.VOLUME_2, Book.VOLUME_3);

        //When
        BookBasket bookBasket = new BookBasket(books);

        //Then
        assertThat(bookBasket.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(21.6));
    }

    @Test
    public void should_return_25_60_if_basket_contains_four_different_books() {
        //Given
        List<Book> books = Arrays.asList(Book.VOLUME_1, Book.VOLUME_2, Book.VOLUME_3, Book.VOLUME_4);

        //When
        BookBasket bookBasket = new BookBasket(books);

        //Then
        assertThat(bookBasket.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(25.60));
    }

    @Test
    public void should_return_30_00_if_basket_contains_five_different_books() {
        //Given
        List<Book> books = Arrays.asList(Book.VOLUME_1, Book.VOLUME_2, Book.VOLUME_3, Book.VOLUME_4, Book.VOLUME_5);

        //When
        BookBasket bookBasket = new BookBasket(books);

        //Then
        assertThat(bookBasket.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(30.00));
    }

}