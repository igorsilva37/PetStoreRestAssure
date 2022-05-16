package petshopping;

import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;


public class Pet {
    String uri = "https://petstore.swagger.io/v2/pet";

    //Ler o arquivo Json
    public String lerJson(String caminhoJson) throws IOException {
       return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //Incluir -Create - Post
    @Test // identifica o metodo o função como um teste
    public void incluirPet() throws IOException {
        String jsonBody = lerJson( "db/pet1.json");

        //Sintaxe Gherkin
        //Dado - Quando - Entãp
        //Given - When - Then

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)

        .when()
                .post(uri)

        .then()
                .log().all()
                .statusCode(200)
        ;

    }
}
