
package POM.Pojo.Film;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Film
 * <p>
 * A Star Wars film
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "episode_id",
        "vehicles",
        "release_date",
        "url",
        "title",
        "producer",
        "edited",
        "starships",
        "created",
        "species",
        "planets",
        "characters",
        "opening_crawl",
        "director"
})
public class Film {

    /**
     * The episode number of this film.
     * (Required)
     */
    @JsonProperty("episode_id")
    @JsonPropertyDescription("The episode number of this film.")
    private Integer episodeId;
    /**
     * The vehicle resources featured within this film.
     * (Required)
     */
    @JsonProperty("vehicles")
    @JsonPropertyDescription("The vehicle resources featured within this film.")
    private List<Object> vehicles = new ArrayList<Object>();
    /**
     * The release date at original creator country.
     * (Required)
     */
    @JsonProperty("release_date")
    @JsonPropertyDescription("The release date at original creator country.")
    private String releaseDate;
    /**
     * The url of this resource
     * (Required)
     */
    @JsonProperty("url")
    @JsonPropertyDescription("The url of this resource")
    private URI url;
    /**
     * The title of this film.
     * (Required)
     */
    @JsonProperty("title")
    @JsonPropertyDescription("The title of this film.")
    private String title;
    /**
     * The producer(s) of this film.
     * (Required)
     */
    @JsonProperty("producer")
    @JsonPropertyDescription("The producer(s) of this film.")
    private String producer;
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     */
    @JsonProperty("edited")
    @JsonPropertyDescription("the ISO 8601 date format of the time that this resource was edited.")
    private Date edited;
    /**
     * The starship resources featured within this film.
     * (Required)
     */
    @JsonProperty("starships")
    @JsonPropertyDescription("The starship resources featured within this film.")
    private List<Object> starships = new ArrayList<Object>();
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     */
    @JsonProperty("created")
    @JsonPropertyDescription("The ISO 8601 date format of the time that this resource was created.")
    private Date created;
    /**
     * The species resources featured within this film.
     * (Required)
     */
    @JsonProperty("species")
    @JsonPropertyDescription("The species resources featured within this film.")
    private List<Object> species = new ArrayList<Object>();
    /**
     * The planet resources featured within this film.
     * (Required)
     */
    @JsonProperty("planets")
    @JsonPropertyDescription("The planet resources featured within this film.")
    private List<String> planets = new ArrayList<String>();
    /**
     * The people resources featured within this film.
     * (Required)
     */
    @JsonProperty("characters")
    @JsonPropertyDescription("The people resources featured within this film.")
    private List<String> characters = new ArrayList<String>();
    /**
     * The opening crawl text at the beginning of this film.
     * (Required)
     */
    @JsonProperty("opening_crawl")
    @JsonPropertyDescription("The opening crawl text at the beginning of this film.")
    private String openingCrawl;
    /**
     * The director of this film.
     * (Required)
     */
    @JsonProperty("director")
    @JsonPropertyDescription("The director of this film.")
    private String director;

    /**
     * The episode number of this film.
     * (Required)
     */
    @JsonProperty("episode_id")
    public Integer getEpisodeId() {
        return episodeId;
    }

    /**
     * The episode number of this film.
     * (Required)
     */
    @JsonProperty("episode_id")
    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    public Film withEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
        return this;
    }

    /**
     * The vehicle resources featured within this film.
     * (Required)
     */
    @JsonProperty("vehicles")
    public List<Object> getVehicles() {
        return vehicles;
    }

    /**
     * The vehicle resources featured within this film.
     * (Required)
     */
    @JsonProperty("vehicles")
    public void setVehicles(List<Object> vehicles) {
        this.vehicles = vehicles;
    }

    public Film withVehicles(List<Object> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    /**
     * The release date at original creator country.
     * (Required)
     */
    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * The release date at original creator country.
     * (Required)
     */
    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Film withReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    /**
     * The url of this resource
     * (Required)
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * The url of this resource
     * (Required)
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    public Film withUrl(URI url) {
        this.url = url;
        return this;
    }

    /**
     * The title of this film.
     * (Required)
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * The title of this film.
     * (Required)
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Film withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * The producer(s) of this film.
     * (Required)
     */
    @JsonProperty("producer")
    public String getProducer() {
        return producer;
    }

    /**
     * The producer(s) of this film.
     * (Required)
     */
    @JsonProperty("producer")
    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Film withProducer(String producer) {
        this.producer = producer;
        return this;
    }

    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     */
    @JsonProperty("edited")
    public Date getEdited() {
        return edited;
    }

    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     */
    @JsonProperty("edited")
    public void setEdited(Date edited) {
        this.edited = edited;
    }

    public Film withEdited(Date edited) {
        this.edited = edited;
        return this;
    }

    /**
     * The starship resources featured within this film.
     * (Required)
     */
    @JsonProperty("starships")
    public List<Object> getStarships() {
        return starships;
    }

    /**
     * The starship resources featured within this film.
     * (Required)
     */
    @JsonProperty("starships")
    public void setStarships(List<Object> starships) {
        this.starships = starships;
    }

    public Film withStarships(List<Object> starships) {
        this.starships = starships;
        return this;
    }

    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     */
    @JsonProperty("created")
    public Date getCreated() {
        return created;
    }

    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     */
    @JsonProperty("created")
    public void setCreated(Date created) {
        this.created = created;
    }

    public Film withCreated(Date created) {
        this.created = created;
        return this;
    }

    /**
     * The species resources featured within this film.
     * (Required)
     */
    @JsonProperty("species")
    public List<Object> getSpecies() {
        return species;
    }

    /**
     * The species resources featured within this film.
     * (Required)
     */
    @JsonProperty("species")
    public void setSpecies(List<Object> species) {
        this.species = species;
    }

    public Film withSpecies(List<Object> species) {
        this.species = species;
        return this;
    }

    /**
     * The planet resources featured within this film.
     * (Required)
     */
    @JsonProperty("planets")
    public List<String> getPlanets() {
        return planets;
    }

    /**
     * The planet resources featured within this film.
     * (Required)
     */
    @JsonProperty("planets")
    public void setPlanets(List<String> planets) {
        this.planets = planets;
    }

    public Film withPlanets(List<String> planets) {
        this.planets = planets;
        return this;
    }

    /**
     * The people resources featured within this film.
     * (Required)
     */
    @JsonProperty("characters")
    public List<String> getCharacters() {
        return characters;
    }

    /**
     * The people resources featured within this film.
     * (Required)
     */
    @JsonProperty("characters")
    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public Film withCharacters(List<String> characters) {
        this.characters = characters;
        return this;
    }

    /**
     * The opening crawl text at the beginning of this film.
     * (Required)
     */
    @JsonProperty("opening_crawl")
    public String getOpeningCrawl() {
        return openingCrawl;
    }

    /**
     * The opening crawl text at the beginning of this film.
     * (Required)
     */
    @JsonProperty("opening_crawl")
    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public Film withOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
        return this;
    }

    /**
     * The director of this film.
     * (Required)
     */
    @JsonProperty("director")
    public String getDirector() {
        return director;
    }

    /**
     * The director of this film.
     * (Required)
     */
    @JsonProperty("director")
    public void setDirector(String director) {
        this.director = director;
    }

    public Film withDirector(String director) {
        this.director = director;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(episodeId).append(vehicles).append(releaseDate).append(url).append(title).append(producer).append(edited).append(starships).append(created).append(species).append(planets).append(characters).append(openingCrawl).append(director).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Film) == false) {
            return false;
        }
        Film rhs = ((Film) other);
        return new EqualsBuilder().append(episodeId, rhs.episodeId).append(vehicles, rhs.vehicles).append(releaseDate, rhs.releaseDate).append(url, rhs.url).append(title, rhs.title).append(producer, rhs.producer).append(edited, rhs.edited).append(starships, rhs.starships).append(created, rhs.created).append(species, rhs.species).append(planets, rhs.planets).append(characters, rhs.characters).append(openingCrawl, rhs.openingCrawl).append(director, rhs.director).isEquals();
    }

}
