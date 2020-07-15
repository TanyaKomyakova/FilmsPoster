package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmsPoster;
import ru.netology.repository.PosterRepository;

@NoArgsConstructor
@Data
public class PosterManager {
    private PosterRepository repository;

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }


    public void add(FilmsPoster film) {    // Метод добавления
        repository.save(film);
    }

    public FilmsPoster[] getAll() {   // Получить все фильмы в обратном порядке
        FilmsPoster[] films = repository.findAll();
        FilmsPoster[] result = new FilmsPoster[films.length];

        for (int i = 0; i < result.length; i++) {
            int index = films.length - 1 - i;
            result[i] = films[index];
        }
        return result;
    }


    public void removeById(int id){ // Удаление по id
        repository.removeById(id);
    }

    public void findById(int id){ // найти по идентификатору
        repository.findById(id);
    }

    public void remove(FilmsPoster film){// очищение
        repository.removeAll();
    }
}
