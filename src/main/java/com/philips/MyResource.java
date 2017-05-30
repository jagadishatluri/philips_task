package com.philips;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.philips.entity.Institution;
import com.philips.entity.Patient;
import com.philips.resource.InstitutionRequest;
import com.philips.resource.InstitutionResponse;
import com.philips.service.InstitutionService;

/**
 * Root resource (exposed at "myresource" path)
 */
// @Component
@Path("institutions")
public class MyResource {

	@Autowired
	InstitutionService institutionService;

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Institution get() {
	 * 
	 * Institution institution = new Institution();
	 * institution.setDescription("Description");
	 * 
	 * institution.setId(9999l); institution.setName("Name");
	 * 
	 * Set<Patient> patientSet = new HashSet<Patient>();
	 * 
	 * Patient patient = new Patient(); patient.setId(444l);
	 * patient.setName("Patient_Name"); patient.setGender('M');
	 * patient.setDob(Calendar.getInstance()); patientSet.add(patient);
	 * 
	 * institution.setPatients(patientSet);
	 * 
	 * return institution; //System.out.println(); return "Got it!"; }
	 */

	@POST
	@Path("institution")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createInstitution(InstitutionRequest request) {
		Institution createdInstitution = institutionService.createInstitution(request);
		return Response.ok().entity(createdInstitution).build();
	}
	
	@POST
	@Path("patient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createPatient(Patient patient) {
		Patient createdPatient = institutionService.createPatient(patient);
		return Response.ok().entity(createdPatient).build();
	}

	@DELETE
	@Path("{institutionId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("institutionId") Long institutionId) {
		System.out.println(institutionId);
		institutionService.delete(institutionId);
		return Response.ok().build();

	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{institutionId}")
	public Response getActivity(@PathParam("institutionId") Long institutionId) {

		if (institutionId == 0) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		InstitutionResponse inst = institutionService.findInstitution(institutionId);

		if (inst == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().header("Access-Control-Allow-Origin","*").entity(inst).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getInstitutions() {
		List<Institution> institutions = institutionService.getInstitutions();
		List<InstitutionResponse> responseList = new ArrayList<InstitutionResponse>();

		for (Institution ins : institutions) {
			InstitutionResponse response = new InstitutionResponse();
			response.setDescription(ins.getDescription());
			response.setName(ins.getName());
			response.setId(ins.getId());
			responseList.add(response);
		}
		GenericEntity<List<InstitutionResponse>> entity = new GenericEntity<List<InstitutionResponse>>(responseList) {};
		Response response = Response.ok(entity).header("Access-Control-Allow-Origin","*").build();
		return response;

	}

	@PUT
	@Path("{institutionId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Institution institution) {
		Institution update = institutionService.update(institution);
		return Response.ok().entity(update).build();
	}

}
