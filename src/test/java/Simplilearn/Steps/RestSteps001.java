package Simplilearn.Steps;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.junit.runner.Request;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import org.apache.log4j.ConsoleAppender;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
//import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.Matchers.hasKey;

public class RestSteps001 {

	String path = "";
	RequestSpecification req001;
	Response resp001;

	// create a logger and get the logger name which is the class name
//	Logger Logger = LogManager.getLogger(RestSteps001.class.getName());
	Logger Logger = LogManager.getLogger(RestSteps001.class.getSimpleName());

	@Given("A base URL {string}")
	public void a_base_url(String baseURL) {
//		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");

//		Logger.info("Classname = " + RestSteps001.class.getSimpleName());
		Logger.info("Classname = " + RestSteps001.class.getName());
		
//		System.out.println("Step 1 : base URl " + baseURL);
		Logger.info("LOGGER >>> Step 1 : base URl " + baseURL);
//		Logger.debug("LOGGER DEBUG >>> Debugging message...");
//		Logger.warn("LOGGER DEBUG >>> Debugging message...");
//		Logger.error("LOGGER DEBUG >>> Debugging message...");
//		Logger.fatal("LOGGER DEBUG >>> Debugging message...");
		// set base URL
		RestAssured.baseURI = baseURL;
		// initialize request
		req001 = RestAssured.given();
	}

	@And("path is {string}")
	public void path_is(String path001) {
//		System.out.println("Step 2 : path " + path001);
		Logger.info("LOGGER >>>>>> Step 2 : path " + path001);

		path = path001;
	}

//	@When("User send get request")
//	public void user_send_get_request() {
////		System.out.println("Step 3 : request");
//		Logger.info("LOGGER >>>>>> Step 3 : request");
//		resp001 = req001.get(path);
//	}

	@When("User send post request")
	public void user_send_post_request() {
//		System.out.println("Step 3 : Post request");
		Logger.info("LOGGER >>>>>> Step 3 : Post request");
		resp001 = req001.post(path);
	}

	@And("payload file is {string}")
	public void payload_file_is(String fileName001) {
		String proPath = System.getProperty("user.dir");
		String filePath = proPath + "/" + fileName001;
		System.out.println("File = " + filePath);
		File payf = new File(filePath);
		System.out.println("File exists = " + payf.exists());
		req001.body(payf);
	}

	@Then("print response")
	public void print_response() {
//		System.out.println("Step 4 : response");
		Logger.info("LOGGER >>>>>> Step 4 : response");
		resp001.then().log().body();
	}

	@Then("status code is {int}")
	public void status_code_is(Integer code) {
		Logger.info("LOGGER >>>>>> Step 5 : Status code");
		resp001.then().statusCode(code);
	}

//	@Then("test {string} equals {int}")
//	public void test_equals(String key001, int value001) {
//		Logger.info("LOGGER >>>>>> Step 6 : equalTo");
//		resp001.then().assertThat().body(key001, equalTo(value001));
//	}
//
//	@Then("test {string} has {string}")
//	public void test_has(String key002, String value002) {
//		Logger.info("LOGGER >>>>>> Step 6 : hasItem");
//		resp001.then().assertThat().body(key002, hasItem(value002));
//	}
//
//	@Then("test {string} has key {string}")
//	public void test_has_key(String key003, String value003) {
//		Logger.info("LOGGER >>>>>> Step 6 : hasKey");
//		resp001.then().assertThat().body(key003, hasKey(value003));
//	}
}
