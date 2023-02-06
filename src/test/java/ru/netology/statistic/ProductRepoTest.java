package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepoTest {
    Product book1 = new Book(1, "Война и мир", 500, "Лев Толстой");
    Product book2 = new Book(2, "Преступление и наказание", 550, "Федор Достоевский");
    Product phone1 = new Smartphone(3, "Note 10S", 12500, "Xiaomi");
    Product phone2 = new Smartphone(4, "Galaxy3000", 100500, "Samsung");

    @Test
    public void shouldSave() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        repo.save(book2);
        repo.save(phone1);
        repo.save(phone2);
        repo.save(phone2);
        Product[] expected = {book1, book2, phone1, phone2, phone2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExistEmpty() {
        ProductRepo repo = new ProductRepo();
        Product[] expected = {};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneProduct() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        Product[] expected = {book1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdExist() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        repo.save(book2);
        repo.save(phone1);
        repo.save(phone2);
        repo.save(phone2);
        repo.removeById(4);
        Product[] expected = {book1, book2, phone1};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNoExist() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        repo.save(book2);
        repo.save(phone1);
        repo.save(phone2);
        repo.save(phone2);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }

    @Test
    public void shouldFindById() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        repo.save(book2);
        repo.save(phone1);
        repo.save(phone2);
        Product expected = book1;
        Product actual = repo.findById(1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindById() {
        ProductRepo repo = new ProductRepo();
        repo.save(book1);
        repo.save(book2);
        repo.save(phone1);
        repo.save(phone2);
        Product expected = null;
        Product actual = repo.findById(7);
        Assertions.assertEquals(expected, actual);
    }


}


