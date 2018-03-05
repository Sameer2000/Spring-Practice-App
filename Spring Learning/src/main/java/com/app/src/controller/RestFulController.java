package com.app.src.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.src.entities.Person;
import com.app.src.service.IPersonService;

@RestController
@RequestMapping("rest")
public class RestFulController
{

   @Autowired
   IPersonService personService;

   @PostMapping(value = "/person/")
   public ResponseEntity< Void > savePerson( @RequestBody Person person, UriComponentsBuilder builder ) throws Exception
   {
      int id = personService.save( person );
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation( builder.path( "/person/{id}" ).buildAndExpand( id ).toUri() );
      return new ResponseEntity< Void >( headers, HttpStatus.CREATED );
   }

   @PutMapping(value = "/person/{id}")
   public ResponseEntity< Person > updatePerson( @PathVariable("id") int id, Person person )
   {
      Person savedPerson = personService.find( id );
      savedPerson.setName( person.getName() );
      savedPerson.setAddress( person.getAddress() );
      personService.update( savedPerson );
      return new ResponseEntity< Person >( savedPerson, HttpStatus.OK );
   }

   @GetMapping(value = "/person/{id}")
   public ResponseEntity< Person > findPerson( @PathVariable int id )
   {
      Person savedPerson = personService.find( id );
      if ( savedPerson == null )
      {
         return new ResponseEntity< Person >( HttpStatus.NOT_FOUND );
      }

      return new ResponseEntity< Person >( savedPerson, HttpStatus.OK );
   }

   @GetMapping(value = "/person/")
   public ResponseEntity< List< Person > > findAllPerson()
   {
      List< Person > savedPersons = personService.findAll();
      if ( savedPersons == null )
      {
         return new ResponseEntity< List< Person > >( HttpStatus.NO_CONTENT );
      }

      return new ResponseEntity< List< Person > >( savedPersons, HttpStatus.OK );
   }

   @DeleteMapping(value = "/person/{id}")
   public ResponseEntity< Person > deletePerson( @PathVariable("id") int id )
   {
      Person savedPerson = personService.find( id );
      if ( savedPerson == null )
      {
         return new ResponseEntity< Person >( HttpStatus.NOT_FOUND );
      }
      personService.delete( id );
      return new ResponseEntity< Person >( savedPerson, HttpStatus.NO_CONTENT );
   }

}
