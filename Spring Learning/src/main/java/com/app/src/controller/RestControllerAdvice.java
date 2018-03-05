package com.app.src.controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.app.src.response.ResponseObject;

@ControllerAdvice
public class RestControllerAdvice
{

   /*@ExceptionHandler(NoHandlerFoundException.class)
   public ResponseEntity< ResponseObject > exception(){
      ResponseObject object = new ResponseObject();
      object.setErrorCode( 500 );
      object.setErrorMessages( Arrays.asList( new String[]{"something went wrong"} ) );
      object.setStatus( "internal server error: 500" );
      return new ResponseEntity< ResponseObject >(HttpStatus.INTERNAL_SERVER_ERROR);
   }*/
   
   @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "resource not found", value = HttpStatus.NOT_FOUND)
   public ResponseEntity< ResponseObject > notFoundException(){
      ResponseObject object = new ResponseObject();
      object.setErrorCode( 404 );
      object.setErrorMessages( Arrays.asList( new String[]{"not found"} ) );
      object.setStatus( "internal server error: 404" );
      return new ResponseEntity< ResponseObject >(HttpStatus.NOT_FOUND);
   }
   
}
