package com.qa.test.tests;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
//import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherDetails {

	@Test
	public void getWeatherDetails() {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		// Response object which represents the HTTP Response packet received
		// from the Web service Server. HTTP Response contains Status, collection
		// of Headers and a Body.
		// Response is an interface which lives in the package: io.restassured.response.
		// Response response= httpRequest.request(Method.GET,"Pune");
		Response response = httpRequest.get("/Pune");
		String body = response.getBody().asString();
		System.out.println(" The response body is =>" + body);
		assertEquals(body.contains("Pune"), true, "Response body contains Pune");
		String contentType = response.getHeader("Content-Type");
		System.out.println(" The Content-Type value is =>" + contentType);
		String serverType = response.header("Server");
		System.out.println(" The Server value is =>" + serverType);
		String acceptLanguage = response.getHeader("Content-Encoding");
		System.out.println(" The Content-Encoding value is =>" + acceptLanguage);
		
		Headers allHeaders =  response.getHeaders();
		for(Header headers: allHeaders) {
			System.out.println("Key : " + headers.getName() + " Value : " + headers.getValue());
		}
		//String cookieValue = response.getCookie("cookieName");
		//System.out.println(" The cookie value is =>" + cookieValue);

		int statusCode = response.getStatusCode();
		System.out.println("StatusCode: " + statusCode);
		String getStatusLine = response.getStatusLine();
		System.out.println("StatusLine: " + getStatusLine);
		assertEquals(getStatusLine, "HTTP/1.1 200 OK", "Correct status code returned");
		assertEquals(statusCode, 200, "Valid status code");
		// String responseBody= response.body().asString();
		// System.out.println(" The response body is =>" + responseBody);

	}

}
