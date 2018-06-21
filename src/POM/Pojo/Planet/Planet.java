
package POM.Pojo.Planet;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Planet
 * <p>
 * A planet.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "gravity",
        "terrain",
        "rotation_period",
        "url",
        "created",
        "name",
        "surface_water",
        "climate",
        "diameter",
        "population",
        "residents",
        "films",
        "edited",
        "orbital_period"
})

@JsonIgnoreProperties
public class Planet {

    /**
     * A number denoting the gravity of this planet. Where 1 is normal.
     * (Required)
     */
    @JsonProperty("gravity")
    @JsonPropertyDescription("A number denoting the gravity of this planet. Where 1 is normal.")
    private String gravity;
    /**
     * the terrain of this planet. Comma-seperated if diverse.
     * (Required)
     */
    @JsonProperty("terrain")
    @JsonPropertyDescription("the terrain of this planet. Comma-seperated if diverse.")
    private String terrain;
    /**
     * The number of standard hours it takes for this planet to complete a single rotation on its axis.
     * (Required)
     */
    @JsonProperty("rotation_period")
    @JsonPropertyDescription("The number of standard hours it takes for this planet to complete a single rotation on its axis.")
    private String rotationPeriod;
    /**
     * The hypermedia URL of this resource.
     * (Required)
     */
    @JsonProperty("url")
    @JsonPropertyDescription("The hypermedia URL of this resource.")
    private URI url;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     */
    @JsonProperty("created")
    @JsonPropertyDescription("The ISO 8601 date format of the time that this resource was created.")
    private Date created;
    /**
     * The name of this planet.
     * (Required)
     */
    @JsonProperty("name")
    @JsonPropertyDescription("The name of this planet.")
    private String name;
    /**
     * The percentage of the planet surface that is naturally occuring water or bodies of water.
     * (Required)
     */
    @JsonProperty("surface_water")
    @JsonPropertyDescription("The percentage of the planet surface that is naturally occuring water or bodies of water.")
    private String surfaceWater;
    /**
     * The climate of this planet. Comma-seperated if diverse.
     * (Required)
     */
    @JsonProperty("climate")
    @JsonPropertyDescription("The climate of this planet. Comma-seperated if diverse.")
    private String climate;
    /**
     * The diameter of this planet in kilometers.
     * (Required)
     */
    @JsonProperty("diameter")
    @JsonPropertyDescription("The diameter of this planet in kilometers.")
    private String diameter;
    /**
     * The average populationof sentient beings inhabiting this planet.
     * (Required)
     */
    @JsonProperty("population")
    @JsonPropertyDescription("The average populationof sentient beings inhabiting this planet.")
    private String population;
    /**
     * An array of People URL Resources that live on this planet.
     * (Required)
     */
    @JsonProperty("residents")
    @JsonPropertyDescription("An array of People URL Resources that live on this planet.")
    private List<Object> residents = new ArrayList<Object>();
    /**
     * An array of Film URL Resources that this planet has appeared in.
     * (Required)
     */
    @JsonProperty("films")
    @JsonPropertyDescription("An array of Film URL Resources that this planet has appeared in.")
    private List<String> films = new ArrayList<String>();
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     */
    @JsonProperty("edited")
    @JsonPropertyDescription("the ISO 8601 date format of the time that this resource was edited.")
    private Date edited;
    /**
     * The number of standard days it takes for this planet to complete a single orbit of its local star.
     * (Required)
     */
    @JsonProperty("orbital_period")
    @JsonPropertyDescription("The number of standard days it takes for this planet to complete a single orbit of its local star.")
    private String orbitalPeriod;

    /**
     * A number denoting the gravity of this planet. Where 1 is normal.
     * (Required)
     */
    @JsonProperty("gravity")
    public String getGravity() {
        return gravity;
    }

    /**
     * A number denoting the gravity of this planet. Where 1 is normal.
     * (Required)
     */
    @JsonProperty("gravity")
    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public Planet withGravity(String gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * the terrain of this planet. Comma-seperated if diverse.
     * (Required)
     */
    @JsonProperty("terrain")
    public String getTerrain() {
        return terrain;
    }

    /**
     * the terrain of this planet. Comma-seperated if diverse.
     * (Required)
     */
    @JsonProperty("terrain")
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public Planet withTerrain(String terrain) {
        this.terrain = terrain;
        return this;
    }

    /**
     * The number of standard hours it takes for this planet to complete a single rotation on its axis.
     * (Required)
     */
    @JsonProperty("rotation_period")
    public String getRotationPeriod() {
        return rotationPeriod;
    }

    /**
     * The number of standard hours it takes for this planet to complete a single rotation on its axis.
     * (Required)
     */
    @JsonProperty("rotation_period")
    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public Planet withRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
        return this;
    }

    /**
     * The hypermedia URL of this resource.
     * (Required)
     */
    @JsonProperty("url")
    public URI getUrl() {
        return url;
    }

    /**
     * The hypermedia URL of this resource.
     * (Required)
     */
    @JsonProperty("url")
    public void setUrl(URI url) {
        this.url = url;
    }

    public Planet withUrl(URI url) {
        this.url = url;
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

    public Planet withCreated(Date created) {
        this.created = created;
        return this;
    }

    /**
     * The name of this planet.
     * (Required)
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name of this planet.
     * (Required)
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Planet withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * The percentage of the planet surface that is naturally occuring water or bodies of water.
     * (Required)
     */
    @JsonProperty("surface_water")
    public String getSurfaceWater() {
        return surfaceWater;
    }

    /**
     * The percentage of the planet surface that is naturally occuring water or bodies of water.
     * (Required)
     */
    @JsonProperty("surface_water")
    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public Planet withSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
        return this;
    }

    /**
     * The climate of this planet. Comma-seperated if diverse.
     * (Required)
     */
    @JsonProperty("climate")
    public String getClimate() {
        return climate;
    }

    /**
     * The climate of this planet. Comma-seperated if diverse.
     * (Required)
     */
    @JsonProperty("climate")
    public void setClimate(String climate) {
        this.climate = climate;
    }

    public Planet withClimate(String climate) {
        this.climate = climate;
        return this;
    }

    /**
     * The diameter of this planet in kilometers.
     * (Required)
     */
    @JsonProperty("diameter")
    public String getDiameter() {
        return diameter;
    }

    /**
     * The diameter of this planet in kilometers.
     * (Required)
     */
    @JsonProperty("diameter")
    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public Planet withDiameter(String diameter) {
        this.diameter = diameter;
        return this;
    }

    /**
     * The average populationof sentient beings inhabiting this planet.
     * (Required)
     */
    @JsonProperty("population")
    public String getPopulation() {
        return population;
    }

    /**
     * The average populationof sentient beings inhabiting this planet.
     * (Required)
     */
    @JsonProperty("population")
    public void setPopulation(String population) {
        this.population = population;
    }

    public Planet withPopulation(String population) {
        this.population = population;
        return this;
    }

    /**
     * An array of People URL Resources that live on this planet.
     * (Required)
     */
    @JsonProperty("residents")
    public List<Object> getResidents() {
        return residents;
    }

    /**
     * An array of People URL Resources that live on this planet.
     * (Required)
     */
    @JsonProperty("residents")
    public void setResidents(List<Object> residents) {
        this.residents = residents;
    }

    public Planet withResidents(List<Object> residents) {
        this.residents = residents;
        return this;
    }

    /**
     * An array of Film URL Resources that this planet has appeared in.
     * (Required)
     */
    @JsonProperty("films")
    public List<String> getFilms() {
        return films;
    }

    /**
     * An array of Film URL Resources that this planet has appeared in.
     * (Required)
     */
    @JsonProperty("films")
    public void setFilms(List<String> films) {
        this.films = films;
    }

    public Planet withFilms(List<String> films) {
        this.films = films;
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

    public Planet withEdited(Date edited) {
        this.edited = edited;
        return this;
    }

    /**
     * The number of standard days it takes for this planet to complete a single orbit of its local star.
     * (Required)
     */
    @JsonProperty("orbital_period")
    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    /**
     * The number of standard days it takes for this planet to complete a single orbit of its local star.
     * (Required)
     */
    @JsonProperty("orbital_period")
    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Planet withOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(gravity).append(terrain).append(rotationPeriod).append(url).append(created).append(name).append(surfaceWater).append(climate).append(diameter).append(population).append(residents).append(films).append(edited).append(orbitalPeriod).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Planet) == false) {
            return false;
        }
        Planet rhs = ((Planet) other);
        return new EqualsBuilder().append(gravity, rhs.gravity).append(terrain, rhs.terrain).append(rotationPeriod, rhs.rotationPeriod).append(url, rhs.url).append(created, rhs.created).append(name, rhs.name).append(surfaceWater, rhs.surfaceWater).append(climate, rhs.climate).append(diameter, rhs.diameter).append(population, rhs.population).append(residents, rhs.residents).append(films, rhs.films).append(edited, rhs.edited).append(orbitalPeriod, rhs.orbitalPeriod).isEquals();
    }

}
