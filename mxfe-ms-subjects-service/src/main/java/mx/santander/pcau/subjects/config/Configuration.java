package mx.santander.pcau.subjects.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ms-subjects-service")
@org.springframework.context.annotation.Configuration
public class Configuration {
	
	 private String value;

	 public String getValue() {
	        return value;
	 }

	 public void setValue(String value) {
	        this.value = value;
	 }

}
