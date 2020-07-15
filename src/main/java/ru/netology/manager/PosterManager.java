package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.FilmsPoster;

@NoArgsConstructor
@Data
public class PosterManager {
    private FilmsPoster[] films = new FilmsPoster[0];

    private int posterDefaultLength = 10;
    private int posterLength;

    public PosterManager(int posterLength) {
        this.posterLength = posterLength;
    }

    public void add(FilmsPoster film) {    // Метод добавления
        int length = films.length + 1;
        FilmsPoster[] movies = new FilmsPoster[length];

        System.arraycopy(films, 0, movies, 0, films.length);

        int lastIndex = movies.length - 1;
        movies[lastIndex] = film;

        films = movies;
    }

    public FilmsPoster[] getLastMovies() {   // Получить все 10 фильмов в обратном порядке
        int filmCount = films.length;

        if ((posterDefaultLength < films.length ) && (posterLength == 0)) {
            filmCount = posterDefaultLength;
        }
        else if ((posterLength > 0) && (posterLength < films.length)) {
            filmCount = posterLength;
        }
        FilmsPoster[] result = new FilmsPoster[filmCount];

        for (int i = 0; i < filmCount; i++) {
            int index = filmCount - 1 - i;
            result[i] = films[index];
        }

        return result;

    }

}
