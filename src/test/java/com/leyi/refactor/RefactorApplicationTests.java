package com.leyi.refactor;

import com.leyi.refactor.firstcase.Customer;
import com.leyi.refactor.firstcase.Movie;
import com.leyi.refactor.firstcase.Rental;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

@Slf4j
@SpringBootTest
class RefactorApplicationTests {

    private static String CONTENT = "Rental Record for 乐一\n" +
            "\t重构 改善既有代码的设计\t30.0\n" +
            "Amount owed is 30.0\n" +
            "You earned 2 frequent renter points";

    @Test
    void contextLoads() {

        Movie movie = Movie.builder().title("重构 改善既有代码的设计").priceCode(Movie.NEW_RELEASE).build();

        Rental rental = Rental.builder().movie(movie).daysRented(10).build();

        ArrayList<Rental> rentals = Lists.newArrayList(rental);

        Customer customer = Customer.builder().name("乐一").rentals(new Vector<>(rentals)).build();

        boolean result = Objects.equals(CONTENT, customer.statement());
        log.info("result: {}", result);

        if (!result) {
            throw new RuntimeException("测试未通过");
        }
    }
}
