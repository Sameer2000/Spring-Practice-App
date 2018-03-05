package com.app.src.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
   @Override
   protected ResponseEntity< Object > handleNoHandlerFoundException( NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request )
   {
      System.out.println( "404 exception" );
      return super.handleNoHandlerFoundException( ex, headers, status, request );
   }
}
