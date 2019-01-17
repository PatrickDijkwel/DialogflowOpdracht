package nl.sogeti.dialogflow.webservices;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/testing")
public class TestResource {
	
	@GET
	@RolesAllowed("admin")
	@Produces("application/json")
	public void getTest() {
		System.out.println("TEST");
	}
	
	@POST
	@RolesAllowed("admin")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public String getFulfillment(JsonArray object) {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for (int i = 0;i < 10;i++) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("Naam", "Gast Nr." + i);
			job.add("leeftijd", i);
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}

}
