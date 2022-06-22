package Simplilearn.Steps;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.junit.Before;
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

public class SampleSteps002 {

	// create a logger and get the logger name which is the class name
//	Logger Logger = LogManager.getLogger(RestSteps001.class.getName());
	Logger Logger = LogManager.getLogger(SampleSteps002.class.getSimpleName());

	@Before
	public void configure() {
//		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@Given("A sample step")
	public void a_base_url() {
//		Logger.info("Classname = " + SampleSteps002.class.getSimpleName());
//		Logger.info("Classname = " + SampleSteps002.class.getName());
		
//		System.out.println("Step 1 : base URl " + baseURL);
		Logger.info("LOGGER >>> Step 1 : base URl INFO");
		Logger.debug("LOGGER DEBUG >>> Debugging DEBUG message...");
		Logger.warn("LOGGER DEBUG >>> Debugging WARN message...");
		Logger.error("LOGGER DEBUG >>> Debugging ERROR message...");
		Logger.fatal("LOGGER DEBUG >>> Debugging FATAL message...");
	}
}