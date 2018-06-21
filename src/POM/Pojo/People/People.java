
package POM.Pojo.People;

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
 * People
 * <p>
 * A person within the Star Wars universe
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "height",
        "hair_color",
        "skin_color",
        "vehicles",
        "gender",
        "url",
        "created",
        "name",
        "edited",
        "starships",
        "birth_year",
        "homeworld",
        "species",
        "films",
        "mass",
        "eye_color"
})
public class People {

    /**
     * The height of this person in meters.
     * (Required)
     */
    @JsonProperty("height")
    @JsonPropertyDescription("The height of this person in meters.")
    private String height;
    /**
     * The hair color of this person.
     * (Required)
     */
    @JsonProperty("hair_color")
    @JsonPropertyDescription("The hair color of this person.")
    private String hairColor;
    /**
     * The skin color of this person.
     * (Required)
     */
    @JsonProperty("skin_color")
    @JsonPropertyDescription("The skin color of this person.")
    private String skinColor;
    /**
     * An array of vehicle resources that this person has piloted
     * (Required)
     */
    @JsonProperty("vehicles")
    @JsonPropertyDescription("An array of vehicle resources that this person has piloted")
    private List<Object> vehicles = new ArrayList<Object>();
    /**
     * The gender of this person (if known).
     * (Required)
     */
    @JsonProperty("gender")
    @JsonPropertyDescription("The gender of this person (if known).")
    private String gender;
    /**
     * The url of this resource
     * (Required)
     */
    @JsonProperty("url")
    @JsonPropertyDescription("The url of this resource")
    private URI url;
    /**
     * The ISO 8601 date format of the time that this resource was created.
     * (Required)
     */
    @JsonProperty("created")
    @JsonPropertyDescription("The ISO 8601 date format of the time that this resource was created.")
    private Date created;
    /**
     * The name of this person.
     * (Required)
     */
    @JsonProperty("name")
    @JsonPropertyDescription("The name of this person.")
    private String name;
    /**
     * the ISO 8601 date format of the time that this resource was edited.
     * (Required)
     */
    @JsonProperty("edited")
    @JsonPropertyDescription("the ISO 8601 date format of the time that this resource was edited.")
    private Date edited;
    /**
     * An array of starship resources that this person has piloted
     * (Required)
     */
    @JsonProperty("starships")
    @JsonPropertyDescription("An array of starship resources that this person has piloted")
    private List<Object> starships = new ArrayList<Object>();
    /**
     * The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).
     * (Required)
     */
    @JsonProperty("birth_year")
    @JsonPropertyDescription("The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).")
    private String birthYear;
    /**
     * The url of the planet resource that this person was born on.
     * (Required)
     */
    @JsonProperty("homeworld")
    @JsonPropertyDescription("The url of the planet resource that this person was born on.")
    private String homeworld;
    /**
     * The url of the species resource that this person is.
     * (Required)
     */
    @JsonProperty("species")
    @JsonPropertyDescription("The url of the species resource that this person is.")
    private List<Object> species = new ArrayList<Object>();
    /**
     * An array of urls of film resources that this person has been in.
     * (Required)
     */
    @JsonProperty("films")
    @JsonPropertyDescription("An array of urls of film resources that this person has been in.")
    private List<Object> films = new ArrayList<Object>();
    /**
     * The mass of this person in kilograms.
     * (Required)
     */
    @JsonProperty("mass")
    @JsonPropertyDescription("The mass of this person in kilograms.")
    private String mass;
    /**
     * The eye color of this person.
     * (Required)
     */
    @JsonProperty("eye_color")
    @JsonPropertyDescription("The eye color of this person.")
    private String eyeColor;

    /**
     * The height of this person in meters.
     * (Required)
     */
    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    /**
     * The height of this person in meters.
     * (Required)
     */
    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    public People withHeight(String height) {
        this.height = height;
        return this;
    }

    /**
     * The hair color of this person.
     * (Required)
     */
    @JsonProperty("hair_color")
    public String getHairColor() {
        return hairColor;
    }

    /**
     * The hair color of this person.
     * (Required)
     */
    @JsonProperty("hair_color")
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public People withHairColor(String hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    /**
     * The skin color of this person.
     * (Required)
     */
    @JsonProperty("skin_color")
    public String getSkinColor() {
        return skinColor;
    }

    /**
     * The skin color of this person.
     * (Required)
     */
    @JsonProperty("skin_color")
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public People withSkinColor(String skinColor) {
        this.skinColor = skinColor;
        return this;
    }

    /**
     * An array of vehicle resources that this person has piloted
     * (Required)
     */
    @JsonProperty("vehicles")
    public List<Object> getVehicles() {
        return vehicles;
    }

    /**
     * An array of vehicle resources that this person has piloted
     * (Required)
     */
    @JsonProperty("vehicles")
    public void setVehicles(List<Object> vehicles) {
        this.vehicles = vehicles;
    }

    public People withVehicles(List<Object> vehicles) {
        this.vehicles = vehicles;
        return this;
    }

    /**
     * The gender of this person (if known).
     * (Required)
     */
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    /**
     * The gender of this person (if known).
     * (Required)
     */
    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public People withGender(String gender) {
        this.gender = gender;
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

    public People withUrl(URI url) {
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

    public People withCreated(Date created) {
        this.created = created;
        return this;
    }

    /**
     * The name of this person.
     * (Required)
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name of this person.
     * (Required)
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public People withName(String name) {
        this.name = name;
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

    public People withEdited(Date edited) {
        this.edited = edited;
        return this;
    }

    /**
     * An array of starship resources that this person has piloted
     * (Required)
     */
    @JsonProperty("starships")
    public List<Object> getStarships() {
        return starships;
    }

    /**
     * An array of starship resources that this person has piloted
     * (Required)
     */
    @JsonProperty("starships")
    public void setStarships(List<Object> starships) {
        this.starships = starships;
    }

    public People withStarships(List<Object> starships) {
        this.starships = starships;
        return this;
    }

    /**
     * The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).
     * (Required)
     */
    @JsonProperty("birth_year")
    public String getBirthYear() {
        return birthYear;
    }

    /**
     * The birth year of this person. BBY (Before the Battle of Yavin) or ABY (After the Battle of Yavin).
     * (Required)
     */
    @JsonProperty("birth_year")
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public People withBirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    /**
     * The url of the planet resource that this person was born on.
     * (Required)
     */
    @JsonProperty("homeworld")
    public String getHomeworld() {
        return homeworld;
    }

    /**
     * The url of the planet resource that this person was born on.
     * (Required)
     */
    @JsonProperty("homeworld")
    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public People withHomeworld(String homeworld) {
        this.homeworld = homeworld;
        return this;
    }

    /**
     * The url of the species resource that this person is.
     * (Required)
     */
    @JsonProperty("species")
    public List<Object> getSpecies() {
        return species;
    }

    /**
     * The url of the species resource that this person is.
     * (Required)
     */
    @JsonProperty("species")
    public void setSpecies(List<Object> species) {
        this.species = species;
    }

    public People withSpecies(List<Object> species) {
        this.species = species;
        return this;
    }

    /**
     * An array of urls of film resources that this person has been in.
     * (Required)
     */
    @JsonProperty("films")
    public List<Object> getFilms() {
        return films;
    }

    /**
     * An array of urls of film resources that this person has been in.
     * (Required)
     */
    @JsonProperty("films")
    public void setFilms(List<Object> films) {
        this.films = films;
    }

    public People withFilms(List<Object> films) {
        this.films = films;
        return this;
    }

    /**
     * The mass of this person in kilograms.
     * (Required)
     */
    @JsonProperty("mass")
    public String getMass() {
        return mass;
    }

    /**
     * The mass of this person in kilograms.
     * (Required)
     */
    @JsonProperty("mass")
    public void setMass(String mass) {
        this.mass = mass;
    }

    public People withMass(String mass) {
        this.mass = mass;
        return this;
    }

    /**
     * The eye color of this person.
     * (Required)
     */
    @JsonProperty("eye_color")
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     * The eye color of this person.
     * (Required)
     */
    @JsonProperty("eye_color")
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public People withEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(height).append(hairColor).append(skinColor).append(vehicles).append(gender).append(url).append(created).append(name).append(edited).append(starships).append(birthYear).append(homeworld).append(species).append(films).append(mass).append(eyeColor).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof People) == false) {
            return false;
        }
        People rhs = ((People) other);
        return new EqualsBuilder().append(height, rhs.height).append(hairColor, rhs.hairColor).append(skinColor, rhs.skinColor).append(vehicles, rhs.vehicles).append(gender, rhs.gender).append(url, rhs.url).append(created, rhs.created).append(name, rhs.name).append(edited, rhs.edited).append(starships, rhs.starships).append(birthYear, rhs.birthYear).append(homeworld, rhs.homeworld).append(species, rhs.species).append(films, rhs.films).append(mass, rhs.mass).append(eyeColor, rhs.eyeColor).isEquals();
    }

}
