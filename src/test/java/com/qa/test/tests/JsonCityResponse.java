package com.qa.test.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonCityResponse {

	@Test
	public void getCityResponse() {
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("Pune");
		// First get the JsonPath object instance from the Response interface

		String humidity = response.jsonPath().get("Humidity").toString();
		//String humidity = jsonPath.get("Humidity");
		System.out.println("Humidity received from Response " +humidity);
		assertEquals(humidity,"21 Percent", "Correct humidity name received in the Response");

		
	}
}
