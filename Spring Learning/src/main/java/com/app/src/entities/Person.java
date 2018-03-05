package com.app.src.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.app.src.response.ResponseObject;

@Entity
public class Person extends ResponseObject
{

   /**
    * 
    */
   private static final long serialVersionUID = 4875455085159183355L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   private String name;

   public Person( Person p )
   {
      this.name = p.name;
      this.address = p.address;
   }

   @Embedded
   private Address address;

   public String getName()
   {
      return name;
   }

   public void setName( String name )
   {
      this.name = name;
   }

   public Address getAddress()
   {
      return address;
   }

   public void setAddress( Address address )
   {
      this.address = address;
   }

}
