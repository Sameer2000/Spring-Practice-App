package com.app.src.response;

import java.sql.Timestamp;
import java.util.List;

public class ResponseObject
{

   private Timestamp timestamp;

   private String status;

   private List< String > errorMessages;

   private int errorCode;

   public Timestamp getTimestamp()
   {
      return timestamp;
   }

   public void setTimestamp( Timestamp timestamp )
   {
      this.timestamp = timestamp;
   }

   public String getStatus()
   {
      return status;
   }

   public void setStatus( String status )
   {
      this.status = status;
   }

   public List< String > getErrorMessages()
   {
      return errorMessages;
   }

   public void setErrorMessages( List< String > errorMessages )
   {
      this.errorMessages = errorMessages;
   }

   public int getErrorCode()
   {
      return errorCode;
   }

   public void setErrorCode( int errorCode )
   {
      this.errorCode = errorCode;
   }

}
