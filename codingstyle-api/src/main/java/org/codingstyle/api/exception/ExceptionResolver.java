package org.codingstyle.api.exception;

import org.codingstyle.api.dto.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mav = new ModelAndView();

        mav.setView(new MappingJackson2JsonView());
        mav.addObject("error", ex.getClass().getSimpleName());
        mav.addObject("message", ex.getMessage());

        HttpStatus status = getStatus(ex);
        response.setHeader("Content-Type", "application/json");
        response.setStatus(status.getCode());

        ex.printStackTrace();

        return mav;
    }

    private static HttpStatus getStatus(Exception e) {
        if (e instanceof CodingStyleAPIException) {
            return ((CodingStyleAPIException) e).getStatus();
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
