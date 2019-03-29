package beans.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class ExceptionController {

    /**
     * Provides handling for exceptions throughout this service.
     */
    @ExceptionHandler(Exception.class)
    public final ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage","<h2>Exeption message: " + ex.getMessage() +"</h2><br/>" +  Stream.of(ex.getStackTrace()).map(trace -> trace.getClassName()+":"+trace.getMethodName() + ":" + trace.getLineNumber())
                .collect(Collectors.joining("<br/>")));
        return modelAndView;
    }
}
