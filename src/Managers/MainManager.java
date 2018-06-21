package Managers;

public class MainManager {
    MainManager mainManager;
    private PeopleManager peopleManager;
    private PlanetManager planetManager;
    private FilmManager filmManager;


    public MainManager() {
        if (mainManager == null) {

            peopleManager = new PeopleManager();
            planetManager = new PlanetManager();
            filmManager = new FilmManager();
        }

    }

    public PeopleManager getPeopleManager() {
        return peopleManager;
    }

    public PlanetManager getPlanetManager() {
        return planetManager;
    }

    public FilmManager getFilmManager() {
        return filmManager;
    }


}
