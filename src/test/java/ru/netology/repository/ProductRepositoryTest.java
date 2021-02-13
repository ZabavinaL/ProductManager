package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Book bookThird = new Book(1, "Pride and Prejudice", 100, "Jane Austen");
    private Book bookSecond = new Book(2, "The Wonderful Wizard of Oz", 130, "Lyman Frank Baum");
    private Smartphone smartSecond = new Smartphone(2, "Samsung Galaxy S20", 31600, "Samsung");
    private Smartphone smartThird = new Smartphone(3, "Motorola Razr", 1600, "Motorola");


    @Test
    public void shouldRemoveByIDSmartphone() {
        repository.save(smartThird);
        repository.save(smartSecond);

        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{smartThird};
        assertArrayEquals(expected, actual);
    }
}
