package test.velocity;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepository;

/**
 * @author Lucas
 * dependency libs
 * "antlr-2.7.5.jar" "avalon-logkit-2.1.jar" "commons-collections-3.2.1.jar" "commons-lang-2.5.jar" "commons-logging-1.1.1.jar" "jdom-1.0.jar" "log4j-1.2.16.jar" "servletapi-2.3.jar" "velocity-1.7.jar" 
 */
public class VelocityTest {
	public static void main(String args[]){
		VelocityEngine velocityEngine = new VelocityEngine();
		
		String templateResourceContent = "$$$!{d2012}{this.${colname}}bdef#set($str='abcEO')#set($strSize=$str.length()+(-2))$strSize";
		StringWriter codeWriter = new StringWriter();
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("colname", "id");
		try {
			velocityEngine.setProperty(VelocityEngine.RESOURCE_LOADER, "string");
			velocityEngine.setProperty("string.resource.loader.class", "org.apache.velocity.runtime.resource.loader.StringResourceLoader");
//			velocityEngine.setProperty(VelocityEngine.RESOURCE_LOADER, "class");
//			velocityEngine.setProperty("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			velocityEngine.init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		StringResourceRepository repository = StringResourceLoader.getRepository();
		String templateName = "templateName";
		repository.putStringResource(templateName, templateResourceContent);
		try {
			Template velocityTemplate = velocityEngine.getTemplate(templateName);
			velocityTemplate.merge(velocityContext, codeWriter);
			System.out.println(codeWriter.toString());
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		} catch (ParseErrorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
