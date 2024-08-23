package demo_pro1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;
public class CreateBug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	RestAssured.baseURI= "https://gsreekeerthana001.atlassian.net/";
		
String createIssueResponse = given()
		.header("Content-Type","application/json")
		.header("Authorization","Basic Z3NyZWVrZWVydGhhbmEwMDFAZ21haWwuY29tOkFUQVRUM3hGZkdGMEp0Z0NEYXY0YllRSC0yLThVQW9GVmhhX1RwMHJvTUZzMHlHMW1sR1UwSldULUM3d0pnMlRndEoyWjQyVGdndVRNUzVoeGRJS1NEVm1EMFNWMzhLVnpxdDJFY3YyS2l1a0pGcHk5Y24wUzEwTC0tdVhiT1ZEMk5XcHhUMWhoaV9MNEVXamV6dU5MUWQtSHBtV2lYR3NIM1VsU2VxNFI2ZmNwT1ZWaG0zS0pKRT05QzMzMkM5MA== ")
		.body("{\n"
				+ "    \"fields\": {\n"
				+ "        \"project\": {\n"
				+ "            \"key\": \"SCRUM\"\n"
				+ "        },\n"
				+ "        \"summary\": \"website not working -automation(attachment)\",\n"
				+ "        \"issuetype\": {\n"
				+ "            \"name\": \"Bug\"\n"
				+ "        }\n"
				+ "    }\n"
				+ "}\n"
				+ "")
		.log().all()
		.post("rest/api/3/issue").then().log().all().assertThat().statusCode(201)
		.extract().response().asString();
		
		JsonPath js = new JsonPath(createIssueResponse);
		String issueId = js.getString("id");
		System.out.println(issueId);
		
		//add attachment
		given()
		.pathParam("key",issueId)
		.header("X-Atlassian-Token", "no-check")
		.header("Authorization","Basic Z3NyZWVrZWVydGhhbmEwMDFAZ21haWwuY29tOkFUQVRUM3hGZkdGMEp0Z0NEYXY0YllRSC0yLThVQW9GVmhhX1RwMHJvTUZzMHlHMW1sR1UwSldULUM3d0pnMlRndEoyWjQyVGdndVRNUzVoeGRJS1NEVm1EMFNWMzhLVnpxdDJFY3YyS2l1a0pGcHk5Y24wUzEwTC0tdVhiT1ZEMk5XcHhUMWhoaV9MNEVXamV6dU5MUWQtSHBtV2lYR3NIM1VsU2VxNFI2ZmNwT1ZWaG0zS0pKRT05QzMzMkM5MA== ")
		.multiPart("file",new File("/Users/keerthanag/Downloads/IMG_0748.PNG")).log().all()
		.post("rest/api/3/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);
	}

}
