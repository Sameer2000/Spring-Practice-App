package com.app.src.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.src.entities.Person;

@Repository
public class PersonRepository implements IPersonRepository
{

   @Autowired
   SessionFactory sessionFactory;

   @Override
   public int save( Person t )
   {
      return ( int ) sessionFactory.getCurrentSession().save( t );
   }

   @Override
   public Person find( int id )
   {
      return sessionFactory.openSession().find( Person.class, id );
   }

   @SuppressWarnings({ "unchecked", "deprecation" })
   @Override
   public List< Person > findAll()
   {
      return sessionFactory.getCurrentSession().createCriteria( Person.class ).list();
   }

   @Override
   public void update( Person t )
   {
      sessionFactory.getCurrentSession().update( t );
   }

   @Override
   public void delete( int id )
   {
      Person person = sessionFactory.openSession().get( Person.class, id );
      sessionFactory.getCurrentSession().delete( person );
   }

}
