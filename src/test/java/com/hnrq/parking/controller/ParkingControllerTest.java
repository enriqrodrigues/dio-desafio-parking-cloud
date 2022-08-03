package com.hnrq.parking.controller;

import com.hnrq.parking.AbstractContainerBase;
import com.hnrq.parking.entity.dto.ParkingCreateDTO;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

//Teste de integração?
//Define uma porta aleatória sempre que a aplicação rodar uma teste.
//Isso é uma boa prática quando executando num servidor de integração contínua onde haverá vários testes de várias
// apis rodando ao mesmo tempo e pode acabar acontecendo algum conflito de porta.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest extends AbstractContainerBase {
    //Quando a classe é iniciada, pela extensão da AbstractContainerBase, então ela sobe um container do docker.

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
        //Rest tem que ser adicionada a dependência
        //Sem este método, não é possível localizar a aplicação, já que ele sempre vai subir numa porta diferente.
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .auth().basic("user", "Dio@123456")
                .when()
                .get("/parking")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void whenCreateThenCheckIsCreated() {
        var createDTO = new ParkingCreateDTO();
        createDTO.setColor("AMARELO");
        createDTO.setLicense("WRT-5555");
        createDTO.setModel("BRASILIA");
        createDTO.setState("SP");

        RestAssured.given()
                .when()
                .auth().basic("user", "Dio@123456")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("WRT-5555"))
                .body("color", Matchers.equalTo("AMARELO"));
    }
}