package Managers;

import POM.Pojo.Film.Film;
import POM.Pojo.People.People;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Managers.ThreadManager.getApi;

public class PeopleManager {


    /**
     * GET /people
     *
     * @return
     */
    public ArrayList<People> getAllPeoples() {
        return getApi().sendGet("https://swapi.co/api/people/").as(ArrayList.class);
    }

    /**
     * GET people/id
     *
     * @param id
     * @return
     */
    public People getPeopleById(int id) {
        return getApi().sendGet("https://swapi.co/api/people/" + id).as(People.class);
    }

    /**
     * GET people/id
     *
     * @param url
     * @return
     */
    public People getPeopleById(String url) {
        return getApi().sendGet(url).as(People.class);
    }

    /**
     * GET people/id for defined film
     *
     * @param film
     * @return
     */
    public List<People> getPeoplesForFilm(Film film) {
        List<String> charactersUrls = film.getCharacters();

        List<People> peoplesForFilm = new ArrayList();
        charactersUrls.forEach(url -> {
            People people = this.getPeopleById(url);
            peoplesForFilm.add(people);
        });
        return peoplesForFilm;
    }

    /**
     * filter list of people by name
     *
     * @param peoples
     * @param value
     * @return
     */
    public List<People> lookForPeopleByName(List<People> peoples, String value) {
        return peoples.stream().filter(people -> people.getName().equals(value)).collect(Collectors.toList());
    }
}
