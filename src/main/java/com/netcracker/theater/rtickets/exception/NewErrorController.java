package com.netcracker.theater.rtickets.exception;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class NewErrorController implements ErrorController {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();


    @RequestMapping("/error")
    public String handleError(Map<String, Object> model, Exception ex, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMessage = HttpStatus.INTERNAL_SERVER_ERROR.value() + " " + (ex.getMessage() != null ? ex.getMessage() : "Unknown page");
        model.put("errorMessage","Error code: "+ errorMessage);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                logger.error(errorMessage);
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                logger.error(errorMessage);
                return "error-500";
            }
        }
        logger.error(errorMessage);
        return "error";
    }
}
