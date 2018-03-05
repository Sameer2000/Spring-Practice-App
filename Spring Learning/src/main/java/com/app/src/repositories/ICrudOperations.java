package com.app.src.repositories;

import java.util.List;

public interface ICrudOperations< T >
{

   public abstract int save( T t ) throws Exception;

   public abstract T find( int id );

   public abstract List< T > findAll();

   public abstract void update( T t );

   public abstract void delete( int id );

}
