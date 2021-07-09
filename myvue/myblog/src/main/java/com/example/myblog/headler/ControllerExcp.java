package com.example.myblog.headler;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@ControllerAdvice
public class ControllerExcp{
  // private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(Exception.class)
   public   ModelAndView exceptionHander(HttpServletRequest request,Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
      //  mv.setViewName("error/error");
       return mv;
   }
}
