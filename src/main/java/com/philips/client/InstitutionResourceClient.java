package com.philips.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.philips.entity.Institution;

public class InstitutionResourceClient {

	Client client;

	public InstitutionResourceClient() {
		client = ClientBuilder.newClient();

	}

	public Institution getInstitution() {
		WebTarget target = client.target("http://localhost:8080/philips_task/webapi/").path("institutions/5");
		//List<Activity> list = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
		Response response = target.request(MediaType.APPLICATION_JSON).get(Response.class);
		if(response.getStatus()!= 200){
			throw new RuntimeException();
		}
		return response.readEntity(Institution.class);
	}
	
	public Institution createInstitution(Institution institution) {
		WebTarget target = client.target("http://localhost:8080/philips_task/webapi/").path("institutions/institution");
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(institution, MediaType.APPLICATION_JSON));
		if(response.getStatus()!= 200){
			throw new RuntimeException();
		}
		return response.readEntity(Institution.class);
	}

}
