package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book bookFirst = new Book(1, "Pride and Prejudice", 100, "Jane Austen");
    private Book bookSecond = new Book(2, "The Wonderful Wizard of Oz", 130, "Lyman Frank Baum");
    private Book bookThird = new Book(3, "The Adventures of Tom Sawyer", 155, "Mark Twain");
    private Smartphone smartFirst = new Smartphone(1, "Huawei P40", 11700, "Huawei");
    private Smartphone smartSecond = new Smartphone(2, "Samsung Galaxy S20", 31600, "Samsung");
    private Smartphone smartThird = new Smartphone(3, "Motorola Razr", 1600, "Motorola");

    @BeforeEach
    public void setUp() {
        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(smartFirst);
        manager.add(smartSecond);
        manager.add(smartThird);
    }

    @Test
    public void shouldGetAll() {
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{bookFirst, bookSecond, bookThird, smartFirst, smartSecond, smartThird};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBypNameProductBook() {
        Product[] actual = manager.searchBy("The Wonderful Wizard of Oz");
        Product[] expected = new Book[]{bookSecond};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        Product[] actual = manager.searchBy("Mark Twain");
        Product[] expected = new Book[]{bookThird};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBypNameProductSmartphone() {
        Product[] actual = manager.searchBy("Samsung Galaxy S20");
        Product[] expected = new Smartphone[]{smartSecond};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacturer() {
        Product[] actual = manager.searchBy("Huawei");
        Product[] expected = new Smartphone[]{smartFirst};
        assertArrayEquals(expected, actual);
    }

}
