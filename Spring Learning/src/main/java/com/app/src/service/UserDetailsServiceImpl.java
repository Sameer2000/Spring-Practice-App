package com.app.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.app.src.entities.Person;
import com.app.src.factory.UserFactory;

@Component
public class UserDetailsServiceImpl implements UserDetailsService
{

   @Autowired
   IPersonService personService;

   @Override
   public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
   {
      System.out.println( "in user" );
      List< Person > persons = personService.findAll();
      for ( Person person : persons )
      {
         if ( person.getName().equals( username ) )
         {
            return UserFactory.createSpringSecUser( person );
         }
      }
      throw new UsernameNotFoundException( String.format( "No user found with username '%s'.", username ) );
   }

}
