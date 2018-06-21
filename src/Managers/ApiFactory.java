package Managers;


import Utils.Runner;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

public class ApiFactory {

    private RequestSpecification spec;
    public MainManager mainManager;


    public ApiFactory() {
        mainManager = new MainManager();
        spec = initSpecification();
    }


    /**
     * set up main spec, which will be used with all requests
     *
     * @return
     */
    private RequestSpecification initSpecification() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    /**
     * Set up post
     *
     * @param url
     * @param body
     * @return
     */
    public Response sendPost(String url, Object body) {

        return given()
                .spec(spec)
                .body(body).
                        log().method().log().path()
                .post(Runner.getCfg().startUrl() + url)
                .then().log().ifError().extract().response();
    }


    /**
     * Set up get
     *
     * @param url
     * @return
     */
    public Response sendGet(String url) {
        return given()
                .spec(spec).
                        log().method().log().path()
                .when()
                .get(url)
                .then().log().ifError().extract().response();
    }

}
