package beans.configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
@Component
public class WebAppInitializer implements WebApplicationInitializer {
	public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfiguration.class);
        ctx.setServletContext(servletContext);    
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(ctx);
		servlet.setTransformWsdlLocations(true);
        Dynamic dynamic = servletContext.addServlet("dispatcher",servlet);
        dynamic.addMapping("/soapws/*");  
        dynamic.setLoadOnStartup(1);  
   }  
} 