package com.leyi.refactor;

import com.leyi.refactor.firstcase.Customer;
import com.leyi.refactor.firstcase.Movie;
import com.leyi.refactor.firstcase.Rental;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Vector;

@Slf4j
@SpringBootTest
class RefactorApplicationTests {

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

        log.info("newReleaseTest statement: {}", customer.statement());
    }

    private static void regularTest() {
        Movie movie = Movie.builder().title("重构 改善既有代码的设计").priceCode(Movie.REGULAR).build();

        Rental rental = Rental.builder().movie(movie).daysRented(10).build();

        ArrayList<Rental> rentals = Lists.newArrayList(rental);

        Customer customer = Customer.builder().name("乐一").rentals(new Vector<>(rentals)).build();

        log.info("regularTest statement: {}", customer.statement());
    }

    private static void childrenTest() {
        Movie movie = Movie.builder().title("重构 改善既有代码的设计").priceCode(Movie.CHILDRENS).build();

        Rental rental = Rental.builder().movie(movie).daysRented(10).build();

        ArrayList<Rental> rentals = Lists.newArrayList(rental);

        Customer customer = Customer.builder().name("乐一").rentals(new Vector<>(rentals)).build();

        log.info("childrenTest statement: {}", customer.statement());
    }
}
