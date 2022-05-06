import static io.restassured.RestAssured.given;

public class REST {
    public static void getResponseBody() {
        given().when().get("http://localhost:3000/posts").then().log().all();
    }

    public static void main(String[] args) {
        getResponseBody();
    }
}
