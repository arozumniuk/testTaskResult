package Managers;

import POM.Pojo.Film.Film;

import java.util.Arrays;
import java.util.List;

import static Managers.ThreadManager.getApi;

public class FilmManager {


    /**
     * GET /films
     *
     * @return
     */
    public List<Film> getAllFilms() {
        return Arrays.asList(getApi().sendGet("https://swapi.co/api/films/").as(Film[].class));
    }

    /**
     * GET films/id
     *
     * @param id
     * @return
     */
    public Film getFilmById(int id) {
        return getApi().sendGet("https://swapi.co/api/films/" + id).as(Film.class);
    }

    /**
     * GET films/id
     *
     * @param url
     * @return
     */
    public Film getFilmById(String url) {
        return getApi().sendGet(url).as(Film.class);
    }


}
