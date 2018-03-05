package com.app.src.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable
{

   /**
    * 
    */
   private static final long serialVersionUID = 8345597029342185881L;

   private String address;

   private int zipcode;

   public String getAddress()
   {
      return address;
   }

   public void setAddress( String address )
   {
      this.address = address;
   }

   public int getZipcode()
   {
      return zipcode;
   }

   public void setZipcode( int zipcode )
   {
      this.zipcode = zipcode;
   }

}
