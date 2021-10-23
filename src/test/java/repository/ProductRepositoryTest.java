package repository;

import domain.Book;
import domain.NotFoundException;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private final ProductRepository repository = new ProductRepository();
    private final Book book = new Book();
    private final Smartphone smartphone = new Smartphone();

    @Test
    public void shouldNotFindNegativeId() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-1);
        });
    }

    @Test
    public void shouldNotFindWrongId() {
        repository.save(smartphone);
        repository.save(book);
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(2);
        });
    }

    @Test
    public void shouldRemoveItemById() {
        Book book = new Book("Война и мир",1, 1000, "Л.Н. Толстой");
        Smartphone smartphone = new Smartphone("S20", 2, 60000, "Samsung");
        repository.save(smartphone);
        repository.save(book);
        repository.removeById(1);
        Product[] expected = new Product[]{smartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}