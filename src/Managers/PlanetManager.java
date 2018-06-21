package Managers;

import POM.Pojo.Film.Film;
import POM.Pojo.Planet.Planet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Managers.ThreadManager.getApi;

public class PlanetManager {


    /**
     * GET /planet
     *
     * @return
     */
    public List<Planet> getAllPlanets() {
        return Arrays.asList(getApi().sendGet("https://swapi.co/api/planets/").as(Planet[].class));
    }


    /**
     * GET planet/id
     *
     * @param id
     * @return
     */
    public Planet getPlanetById(int id) {
        return getApi().sendGet("https://swapi.co/api/planets/" + id).as(Planet.class);
    }

    /**
     * GET planet/id
     *
     * @param url
     * @return
     */
    public Planet getPlanetById(String url) {
        return getApi().sendGet(url).then().statusCode(200).extract().body().as(Planet.class);
    }

    /**
     * GET planet/id for defined film
     *
     * @param film
     * @return
     */
    public List<Planet> getPlanetsForFilm(Film film) {
        List<String> planetsUrls = film.getPlanets();

        List<Planet> planetsForFilm = new ArrayList();
        planetsUrls.forEach(url -> {
            Planet planet = this.getPlanetById(url);
            planetsForFilm.add(planet);
        });
        return planetsForFilm;
    }

    /**
     * filter list of planet by name
     *
     * @param planets
     * @param value
     * @return
     */
    public List<Planet> lookForPlanetByName(List<Planet> planets, String value) {
        return planets.stream().filter(planet -> planet.getName().equals(value)).collect(Collectors.toList());
    }

}
