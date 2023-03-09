package qot.tests;


import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

public class PetsTest {

    static final ResponseSpecification SUCCESS = new ResponseSpecBuilder()
                        .expectStatusCode(200)
                        .build();
    static final RequestSpecification REQUEST = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/v2/pet")
            .build()
            .filter(new AllureRestAssured());

    @Story("POST Request")
    @Severity(value = SeverityLevel.NORMAL)
    @Description("Test Description : Verify the creation of a new employee")
    @ParameterizedTest
    @ValueSource(strings = {"available", "sold", "pending"})
    public void testThatICanGetMyPetByStatus(String petStatus) {
        given().spec(REQUEST)
                .when()
                .get("/findByStatus?status=" + petStatus).then().spec(SUCCESS);
        //Assertions.assertEquals( response.getStatusCode() , 200);

    }
//
//    public void findPetById() {
//
//        // Given
//        given()
//                .filter(new AllureRestAssured())
//
//                // WHEN
//                .when()
//                .get(BaseURL + "/v1/employee/2")
//
//                // THEN
//                .then()
//                .statusCode(200)
//                .statusLine("HTTP/1.1 200 OK")
//                // To verify booking id at index 2
//                .body("data.employee_name", equalTo("Garrett Winters"))
//                .body("message", equalTo("Successfully! Record has been fetched."));
//    }
//
//    @Test
//    @Story("POST Request")
//    @Severity(value = SeverityLevel.NORMAL)
//    @Description("Test Description : Verify the creation of a new employee")
//    public void createUser() {
//
//        JSONObject data = new JSONObject();
//
//        // Map<String, String> map = new HashMap<String, String>();
//
//        data.put("pet", "doggie");
//        data.put("employee_salary", "99999");
//        data.put("employee_age", "30");
//
//        // GIVEN
//        String BaseURL;
//        given()
//                .filter(new AllureRestAssured())
//                .contentType(ContentType.JSON)
//                .body(data.toString())
//
//                // WHEN
//                .when()
//                .post(BaseURL + "https://petstore.swagger.io/v2/pet")
//
//                // THEN
//                .then()
//                .statusCode(403)
//                .body("data.employee_name", equalTo("APITest"))
//                .body("message", equalTo("Successfully! Record has been added."));
//
//
//    }
}





