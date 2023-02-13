/**
 * 
 */
package mx.santander.pcau.categories.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author AdministradorAgo
 *
 */
@ConfigurationProperties("ms-categories-service")
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
