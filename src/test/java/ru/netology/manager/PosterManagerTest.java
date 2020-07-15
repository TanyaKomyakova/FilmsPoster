package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FilmsPoster;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PosterManagerTest {
    @Mock
    private PosterRepository repository;

    @InjectMocks
    private PosterManager manager;
    private FilmsPoster first = new FilmsPoster(1, "first", "comedy", 10);
    private FilmsPoster second = new FilmsPoster(2, "second", "comedy", 15);
    private FilmsPoster third = new FilmsPoster(3, "third", "comedy", 23);
    private FilmsPoster fourth = new FilmsPoster(4, "fourth", "comedy", 1);
    private FilmsPoster fifth = new FilmsPoster(5, "fifth", "comedy", 17);
    private FilmsPoster sixth = new FilmsPoster(6, "sixth", "comedy", 19);
    private FilmsPoster seventh = new FilmsPoster(7, "seventh", "comedy", 21);
    private FilmsPoster eighth = new FilmsPoster(8, "eighth", "comedy", 22);
    private FilmsPoster ninth = new FilmsPoster(9, "ninth", "comedy", 23);
    private FilmsPoster tenth = new FilmsPoster(10, "tenth", "comedy", 12);


    @Test
    public void showInReverseOrder() {// Показать в обратном порядке
        FilmsPoster[] returned = new FilmsPoster[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        FilmsPoster[] actual = manager.getAll();
        FilmsPoster[] expected = new FilmsPoster[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() { // Должен удалить если существует
        int idToRemove = 1;
        // setup mock
        FilmsPoster[] returned = new FilmsPoster[]{second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        FilmsPoster[] actual = manager.getAll();
        FilmsPoster[] expected = new FilmsPoster[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);

    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        FilmsPoster[] returned = new FilmsPoster[]{first, second, third, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        FilmsPoster[] expected = new FilmsPoster[]{tenth, ninth, eighth, seventh, sixth, fifth, third, second, first};
        FilmsPoster[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }

    @Test
    public void findById() {// Найти по id
        int idToFind = 1;
        FilmsPoster[] returned = new FilmsPoster[]{first};
        doReturn(returned).when(repository).findAll();


        manager.findById(idToFind);
        FilmsPoster[] actual = manager.getAll();
        FilmsPoster[] expected = new FilmsPoster[]{first};
        assertArrayEquals(expected, actual);
        verify(repository).findById(idToFind);

    }

}