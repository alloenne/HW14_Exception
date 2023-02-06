package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductManagerTest {
    ProductRepo repo = new ProductRepo();
    ProductManager manager = new ProductManager(repo);
    Product book1 = new Book(1, "Война и мир", 500, "Лев Толстой");
    Product book2 = new Book(2, "Преступление и наказание", 550, "Федор Достоевский");
    Product phone1 = new Smartphone(3, "Note 10S", 12500, "Xiaomi");
    Product phone2 = new Smartphone(4, "Galaxy3000", 100500, "Samsung");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);
    }


    @Test
    public void shouldAdd() {
        manager.add(phone2);
        Product[] expected = {book1, book2, phone1, phone2, phone2};
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchExistRussianLetters() {
        manager.add(book1);
        Product[] expected = {book1, book1};
        Product[] actual = manager.searchBy("Война");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchExistLatinLetters() {
        manager.add(phone1);
        Product[] expected = {phone1, phone1};
        Product[] actual = manager.searchBy("Note");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchExistNumber() {
        manager.add(phone2);
        Product[] expected = {phone2, phone2, phone1};
        Product[] actual = manager.searchBy("0");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoExist() {
        manager.add(phone2);
        Product[] expected = {};
        Product[] actual = manager.searchBy("W");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAuthor() {
        manager.add(phone2);
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Лев");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchManufacturer() {
        manager.add(phone2);
        Product[] expected = {phone2, phone2, phone1};
        Product[] actual = manager.searchBy("X");
        Assertions.assertArrayEquals(expected, actual);
    }

}
