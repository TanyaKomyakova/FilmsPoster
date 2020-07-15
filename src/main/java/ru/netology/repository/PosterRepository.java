package ru.netology.repository;

import ru.netology.domain.FilmsPoster;

public class PosterRepository {
    private FilmsPoster[] films = new FilmsPoster[0];

    public void save(FilmsPoster film) {    // Метод добавления
        int length = films.length + 1;
        FilmsPoster[] movies = new FilmsPoster[length];

        System.arraycopy(films, 0, movies, 0, films.length);

        int lastIndex = movies.length - 1;
        movies[lastIndex] = film;

        films = movies;
    }

    public FilmsPoster[] findAll(){  // Получить все фильмы в обратном порядке
        return films;
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

    public FilmsPoster findById(int id) { // Возвращение по id, если нет то null

        for (FilmsPoster film : films) {
            if (film.getId() == id){

                return film;
            }

        }
        return null;

    }

    public void removeAll(){ // Полностью вычищает репозиторий
        films = new FilmsPoster[0];
    }

}
