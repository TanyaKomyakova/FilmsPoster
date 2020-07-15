package ru.netology.manager;

import ru.netology.domain.FilmsPoster;

public class PosterManager {
    private FilmsPoster[] films = new FilmsPoster[0];

    public void add(FilmsPoster film){    // Метод добавления
        int length = films.length + 1;
        FilmsPoster[] movies = new FilmsPoster[length];

        System.arraycopy(films, 0, movies, 0, films.length);

        int lastIndex = movies.length - 1;
        movies[lastIndex] = film;

        films = movies;
    }

    public FilmsPoster[] getAll(){   // Получить все элементы в обратном порядке
        FilmsPoster[] result = new FilmsPoster[films.length];

        for (int i = 0; i < result.length; i++) {
            int index = films.length - 1 -i;
            result[i] = films[index];
        }
        return result;
    }

    public void removeById(int id){ // Удаление по id
        int length = films.length - 1;
        FilmsPoster[] videos = new FilmsPoster[length];

        int index = 0;
        for (FilmsPoster film : films) {
            if (film.getId() != id){
                videos[index] = film;
                index++;

            }
        }
        films = videos;
    }
}
