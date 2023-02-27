package com.App.exceptions;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	//-------------------------------------------------------------------------//
	//									CUSTOMER EXCEPTIONS
	//-------------------------------------------------------------------------//	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> customerHandler(CustomerException e, WebRequest wr) {
		
		
		System.out.println("Inside CustomerException handler...");
		
        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(),wr.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	

	
	
	

   //-------------------------------------------------------------------------//
   //								VALIDATION EXCEPTIONS
   //-------------------------------------------------------------------------//


   //	if user passes wrong api than this exception will be thrown automatically by spring boot

   @ExceptionHandler(NoHandlerFoundException.class)
   public ResponseEntity<MyErrorDetails> wrongApiHandler(NoHandlerFoundException e, WebRequest wr){
	
	  System.out.println("Inside the NoHandlerFoundException Handler...");
	
	  MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
	
	  return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
   }

   
   
   


  //	if user don't pass right argument than this exception will be thrown....

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<MyErrorDetails> methodHandler(MethodArgumentNotValidException ie,WebRequest req) {
	
		System.out.println("inside MethodArgumentNotValidException Handler...");
		
		MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		

    }
	
	
   
		   //-------------------------------------------------------------------------//
		   //								GLOBAL EXCEPTIONS
		   //-------------------------------------------------------------------------//
		
		
		//	if any logical error happens than this exception will be thrown.
		
		@ExceptionHandler(Exception.class)
		public ResponseEntity<MyErrorDetails> logicalHandler(Exception e, WebRequest wr){
		
			System.out.println("Inside the Exception Handler...");
			
			MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
			
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
				
		}

   
   
}
