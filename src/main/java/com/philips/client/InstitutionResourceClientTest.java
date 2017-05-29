package com.philips.client;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.philips.entity.Institution;

public class InstitutionResourceClientTest {

	@Test(expected =RuntimeException.class)
	public void testGetActivity() {
		InstitutionResourceClient client = new InstitutionResourceClient();
		Institution institution = client.getInstitution();
		System.out.println(institution);
		assertNotNull(institution);
	}
	
	@Test(expected =RuntimeException.class)
	public void testBadRequest() {
		InstitutionResourceClient client = new InstitutionResourceClient();
		Institution institution = client.getInstitution();
		System.out.println(institution);
		assertNotNull(institution);
	}
	
	
	@Test
	public void testPostRequest() {
		InstitutionResourceClient client = new InstitutionResourceClient();
		Institution institution = new Institution();
		institution.setDescription("Institution1");
		institution.setName("Institution1");
		Institution act = client.createInstitution(institution);
		assertNotNull(act);
	}

}
