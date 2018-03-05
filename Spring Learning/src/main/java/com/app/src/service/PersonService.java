package com.app.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.src.entities.Person;
import com.app.src.repositories.IPersonRepository;

@Service
@Transactional
public class PersonService implements IPersonService
{

   @Autowired
   IPersonRepository personRepository;

   @Override
   @Transactional(rollbackFor = Exception.class)
   public int save( Person t ) throws Exception
   {
      int id = 0;
      for ( int i = 0; i < 3; i++ )
      {
         id = personRepository.save( new Person( t ) );
         if ( i == 1 )
         {
            throw new Exception();
         }
      }
      return id;
   }

   @Override
   @Transactional
   public Person find( int id )
   {
      return personRepository.find( id );
   }

   @Override
   @Transactional
   public List< Person > findAll()
   {
      return personRepository.findAll();
   }

   @Override
   @Transactional
   public void update( Person t )
   {
      personRepository.update( t );
   }

   @Override
   @Transactional
   public void delete( int id )
   {
      personRepository.delete( id );
   }

}
