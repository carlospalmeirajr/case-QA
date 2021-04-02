package cpmj.runners;

import java.io.File;
import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/resources/features/",
		glue = { "cpmj" },
		tags = { "@validar_historias" },
		plugin = { "pretty", "json:target/cucumber.json" },
		monochrome = true,
		snippets =  SnippetType.CAMELCASE, 
		dryRun = false,
		strict = true
		)	

public class Runner{
	
	@AfterClass
	public static void teardown() {
        String buildNumber = "1";
        String projectName = "Cucumber Report";
		 Configuration configuration = new Configuration(new File("target/"), projectName);
	        configuration.setParallelTesting(false);
	        configuration.setRunWithJenkins(false);
	        configuration.setBuildNumber(buildNumber);

	        ReportBuilder reportBuilder = new ReportBuilder(Arrays.asList("target/cucumber.json"), configuration);
	        reportBuilder.generateReports();
	}
}
