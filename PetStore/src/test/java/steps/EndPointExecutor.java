package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class EndPointExecutor {

  private static RequestSpecification requestSpecification;

  public EndPointExecutor(String baseUrl) {
    RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    requestSpecBuilder.setBaseUri(baseUrl);
    requestSpecBuilder.setContentType(ContentType.JSON);
    requestSpecBuilder.log(LogDetail.ALL);
    requestSpecification = requestSpecBuilder.build();
  }


  public Response getCall(String getUri, String queryParam) {
    return given(requestSpecification)
        .queryParam("status", queryParam)
        .get(getUri)
        .then()
        .log()
        .all()
        .extract()
        .response();
  }

}
