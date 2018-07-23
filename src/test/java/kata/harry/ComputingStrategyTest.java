package kata.harry;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputingStrategyTest {

    @Test
    public void should_keep_5_for_FIVE_UNIQUE_BOOKS_FIRST_if_5() {
        assertThat(
                ComputingStrategy.FIVE_UNIQUE_BOOKS_FIRST.applyStrategy(
                        new HashSet<>(
                                Arrays.asList(Book.VOLUME_1,Book.VOLUME_2,Book.VOLUME_3,Book.VOLUME_4,Book.VOLUME_5)),
                        Arrays.asList(Book.VOLUME_1,Book.VOLUME_2,Book.VOLUME_3,Book.VOLUME_4,Book.VOLUME_5)))
        .hasSize(5);
    }

    @Test
    public void should_keep_4_for_FIVE_UNIQUE_BOOKS_FIRST_if_4() {
        assertThat(
                ComputingStrategy.FIVE_UNIQUE_BOOKS_FIRST.applyStrategy(
                        new HashSet<>(
                                Arrays.asList(Book.VOLUME_1,Book.VOLUME_2,Book.VOLUME_3,Book.VOLUME_4)),
                        Arrays.asList(Book.VOLUME_1,Book.VOLUME_2,Book.VOLUME_3,Book.VOLUME_4,Book.VOLUME_5)))
                .hasSize(4);
    }

    @Test
    public void should_keep_4_for_FOUR_UNIQUE_BOOKS_FIRST_if_5() {
        assertThat(
                ComputingStrategy.FOUR_UNIQUE_BOOKS_FIRST.applyStrategy(
                        new HashSet<>(
                                Arrays.asList(Book.VOLUME_1,Book.VOLUME_2,Book.VOLUME_3,Book.VOLUME_4,Book.VOLUME_5)),
                        Arrays.asList(Book.VOLUME_1,Book.VOLUME_2,Book.VOLUME_3,Book.VOLUME_4,Book.VOLUME_5)))
                .hasSize(4);
    }
}