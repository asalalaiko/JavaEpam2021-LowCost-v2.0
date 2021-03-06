package by.asalalaiko.exception;

import by.asalalaiko.controller.RegistrationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class MyExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = UserNotFoundException.class)
    public String userNotFoundException1(UserNotFoundException exception, Model model) {
        model.addAttribute("message", "User not found!");
        model.addAttribute("title", "Error page");
        LOGGER.error("User not found error", exception.getMessage());
        return "error";
    }

    @ExceptionHandler(value = PlaneNotFoundException.class)
    public String planeNotFoundException1(PlaneNotFoundException exception, Model model) {
        model.addAttribute("message", "Plane not found!");
        model.addAttribute("title", "Error page");
        LOGGER.error("Plane not found error", exception.getMessage());
        return "error";
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String nullPointerHandler(NullPointerException exception, Model model) {
        model.addAttribute("title", "Error page");
        model.addAttribute("message", "NullPointerException");
        LOGGER.error("NullPointerException", exception.getMessage());
        return "error";
    }

    @ExceptionHandler(value = IOException.class)
    public String IOException(IOException exception, Model model) {
        model.addAttribute("title", "Error page");
        model.addAttribute("message", "IOException");
        LOGGER.error("IOException", exception.getMessage());
        return "error";
    }

    @ExceptionHandler(value = Exception.class)
    public String AnyOtherHandler() {
        LOGGER.error("Exception");
        return "error";
    }
}
