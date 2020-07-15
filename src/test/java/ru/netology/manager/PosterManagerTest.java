package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FilmsPoster;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    PosterManager manager = new PosterManager();
    FilmsPoster first = new FilmsPoster(1, 1, "first", 1,1);
    FilmsPoster second = new FilmsPoster(2, 2, "second", 2,1);
    FilmsPoster third = new FilmsPoster(3, 3, "third", 3,1);

    @BeforeEach
    public void setUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);

    }

    @Test
    public void shouldRemoveIfExists(){
        int idToRemote = 1;

        manager.removeById(idToRemote);
        FilmsPoster[] actual = manager.getAll();
        FilmsPoster[] expected = new FilmsPoster[]{third,second};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        FilmsPoster[] actual = manager.getAll();
        FilmsPoster[] expected = new FilmsPoster[]{third,second, first};

        assertArrayEquals(expected, actual);
    }


}