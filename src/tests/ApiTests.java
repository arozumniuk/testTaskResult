package tests;

import Managers.ThreadManager;
import POM.Pojo.Film.Film;
import POM.Pojo.People.People;
import POM.Pojo.Planet.Planet;
import Utils.Logger;
import Utils.TestNGListener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Listeners(TestNGListener.class)
public class ApiTests extends BaseTest {

    private static final int USER_ID = 1;

    @AfterClass
    public void tearDown() throws Exception {
        ThreadManager.removeApiDriver();
    }

    @Test
    public void checkHomeWorldsNameForUserWithDefinedId() {

        Logger.STEP("Get info about user with defined Id");
        String homeWorld = mainManager.getPeopleManager()
                .getPeopleById(USER_ID)
                .getHomeworld();


        Logger.STEP("Get info about home world for user with defined Id");
        Planet planet = mainManager.getPlanetManager().getPlanetById(homeWorld);

        assertThat(planet.getName()).as("Planet name:").isEqualTo("Tatooine");
    }

    @Test
    public void checkHomeWorldsPopulationForUserWithDefinedId() {

        Logger.STEP("Get info about user with defined Id");
        String homeWorld = mainManager.getPeopleManager()
                .getPeopleById(USER_ID)
                .getHomeworld();

        Logger.STEP("Get info about home world for user with defined Id");
        Planet planet = mainManager.getPlanetManager().getPlanetById(homeWorld);

        assertThat(planet.getPopulation()).as("Planet population:").isEqualTo("200000");
    }

    @Test
    public void checkFilmNameForUserWithDefinedId() {

        Logger.STEP("Get info about user with defined Id");
        String homeWorld = mainManager.getPeopleManager()
                .getPeopleById(USER_ID)
                .getHomeworld();

        Logger.STEP("Get info about home world for user with defined Id");
        Planet planet = mainManager.getPlanetManager().getPlanetById(homeWorld);

        Logger.STEP("Get urls to all films for home world");
        String filmUrl = planet.getFilms().get(0);

        Logger.STEP("Get info about first film for home world");
        Film film = mainManager.getFilmManager().getFilmById(filmUrl);

        assertThat(film.getTitle()).as("Film title:").isEqualTo("Attack of the Clones");

    }

    @Test
    public void checkIfFilmContainsDefinedUserName() {
        String NAME = "Luke Skywalker";

        Logger.STEP("Get info about homeWorld for user with defined Id");
        String homeWorld = mainManager.getPeopleManager()
                .getPeopleById(USER_ID)
                .getHomeworld();

        Logger.STEP("Get info about homeWorld for user with defined Id.");
        Planet planet = mainManager.getPlanetManager().getPlanetById(homeWorld);

        Logger.STEP("Get first film for homeWorld.");
        String filmUrl = planet.getFilms().get(0);
        Film film = mainManager.getFilmManager().getFilmById(filmUrl);

        Logger.STEP("Get peoples for first film.");
        List<People> peopleForFilm = mainManager.getPeopleManager().getPeoplesForFilm(film);

        Logger.STEP("Looking for man with name: " + NAME);
        List<People> manWithDefinedName = mainManager.getPeopleManager().lookForPeopleByName(peopleForFilm, NAME);

        Assert.assertTrue(manWithDefinedName.size() > 0,
                "Count of people with name " + NAME + " for film is " + manWithDefinedName.size());
    }

    @Test
    public void checkIfFilmContainsDefinedPlanet() {

        Logger.STEP("Get info about homeWorld for user with defined Id");
        String homeWorld = mainManager.getPeopleManager()
                .getPeopleById(USER_ID)
                .getHomeworld();

        Logger.STEP("Get info about homeWorld for user with defined Id.");
        Planet planet = mainManager.getPlanetManager().getPlanetById(homeWorld);

        Logger.STEP("Get first film for homeWorld.");
        String filmUrl = planet.getFilms().get(0);
        Film film = mainManager.getFilmManager().getFilmById(filmUrl);

        Logger.STEP("Get planets for first film.");
        List<Planet> planetsForFilm = mainManager.getPlanetManager().getPlanetsForFilm(film);

        Logger.STEP("Looking for planet with name: " + planet.getName());
        List<Planet> planetsWithDefinedName = mainManager.getPlanetManager().lookForPlanetByName(planetsForFilm, planet.getName());

        Assert.assertEquals(planetsWithDefinedName.size(), 1,
                "Count of Luke Skywalker's homeworld " + planet.getName() + " for film " + planetsForFilm.size() + " is incorrect");
    }

}
