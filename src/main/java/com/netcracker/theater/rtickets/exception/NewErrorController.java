package com.netcracker.theater.rtickets.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class NewErrorController implements ErrorController {

    //Logger logger = LoggerFactory.getLogger(NewErrorController.class);


    @RequestMapping("/error")
    public String handleError(Map<String, Object> model, Exception ex, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String errorMessage = HttpStatus.INTERNAL_SERVER_ERROR.value() + " " + (ex.getMessage() != null ? ex.getMessage() : "Unknown page");
        model.put("errorMessage","Error code: "+ errorMessage);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                //logger.error("Error 404", ex);
                return "error-404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                //logger.error("Error 500", ex);
                return "error-500";
            }
        }
        //logger.error("Uncategorized error", ex);
        return "error";
    }
}
