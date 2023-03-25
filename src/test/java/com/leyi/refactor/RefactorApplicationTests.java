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

    private static String NEW_RELEASE_TEST_STATEMENT = "Rental Record for 乐一\n" +
            "\t重构 改善既有代码的设计\t30.0\n" +
            "Amount owed is 30.0\n" +
            "You earned 2 frequent renter points";

    private static String REGULAR_TEST_STATEMENT = "Rental Record for 乐一\n" +
            "\t重构 改善既有代码的设计\t14.0\n" +
            "Amount owed is 14.0\n" +
            "You earned 1 frequent renter points";

    private static String CHILDREN_TEST_STATEMENT = "Rental Record for 乐一\n" +
            "\t重构 改善既有代码的设计\t12.0\n" +
            "Amount owed is 12.0\n" +
            "You earned 1 frequent renter points";

    @Test
    void contextLoads() {
        newReleaseTest();
        regularTest();
        childrenTest();
    }

    private static void newReleaseTest() {
        Movie movie = Movie.builder().title("重构 改善既有代码的设计").priceCode(Movie.NEW_RELEASE).build();

        Rental rental = Rental.builder().movie(movie).daysRented(10).build();

        ArrayList<Rental> rentals = Lists.newArrayList(rental);

        Customer customer = Customer.builder().name("乐一").rentals(new Vector<>(rentals)).build();

        log.info("NEW_RELEASE_TEST_STATEMENT: {}", NEW_RELEASE_TEST_STATEMENT);
        log.info("newReleaseTest statement: {}", customer.statement());

        boolean result = Objects.equals(NEW_RELEASE_TEST_STATEMENT, customer.statement());
        log.info("result: {}", result);

        if (!result) {
            throw new RuntimeException("newReleaseTest 测试未通过");
        }
    }

    private static void regularTest() {
        Movie movie = Movie.builder().title("重构 改善既有代码的设计").priceCode(Movie.REGULAR).build();

        Rental rental = Rental.builder().movie(movie).daysRented(10).build();

        ArrayList<Rental> rentals = Lists.newArrayList(rental);

        Customer customer = Customer.builder().name("乐一").rentals(new Vector<>(rentals)).build();

        log.info("REGULAR_TEST_STATEMENT: {}", REGULAR_TEST_STATEMENT);
        log.info("regularTest statement: {}", customer.statement());

        boolean result = Objects.equals(REGULAR_TEST_STATEMENT, customer.statement());
        log.info("result: {}", result);

        if (!result) {
            throw new RuntimeException("regularTest 测试未通过");
        }
    }

    private static void childrenTest() {
        Movie movie = Movie.builder().title("重构 改善既有代码的设计").priceCode(Movie.CHILDRENS).build();

        Rental rental = Rental.builder().movie(movie).daysRented(10).build();

        ArrayList<Rental> rentals = Lists.newArrayList(rental);

        Customer customer = Customer.builder().name("乐一").rentals(new Vector<>(rentals)).build();

        log.info("CHILDREN_TEST_STATEMENT: {}", CHILDREN_TEST_STATEMENT);
        log.info("childrenTest statement: {}", customer.statement());

        boolean result = Objects.equals(CHILDREN_TEST_STATEMENT, customer.statement());
        log.info("result: {}", result);

        if (!result) {
            throw new RuntimeException("childrenTest 测试未通过");
        }
    }
}
