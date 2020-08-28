package steps;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.petstore.util.Constants.PET_ENDPOINT;

public class PetAPIClient {

  EndPointExecutor endPointExecutor;

  public PetAPIClient() {
    endPointExecutor = new EndPointExecutor("BASE_URL");
  }

  public String getPetsByStatus(String uri, String petStatus) {
    String getUri =  String.format("%s%s", PET_ENDPOINT,uri);;
    Response response = endPointExecutor.getCall(getUri, petStatus);
      return response.asString();
  }

  public List<String> validatePetsByStatus(String jsonObjresp,String name,String status){
    List<String> statusList = new ArrayList<>();
    JSONArray jsonArr = new JSONArray(jsonObjresp.toString());
    if (jsonArr.length() > 0) {
      for (int i = 0; i < jsonArr.length(); i++) {
        JSONObject obj = jsonArr.getJSONObject(i);
        if (obj.get("name").equals(name))
          statusList.add((obj.get("status").toString()));
      }
    }
    return statusList;
  }

}
