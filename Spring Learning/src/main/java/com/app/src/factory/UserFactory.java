package com.app.src.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.app.src.bean.AppUser;
import com.app.src.entities.Person;

public class UserFactory
{

   public static final AppUser createSpringSecUser( Person person )
   {
      AppUser user = new AppUser( person.getName(), "12345", mapToGrantedAuthorities() );
      return user;
   }

   private static List< GrantedAuthority > mapToGrantedAuthorities()
   {
      List< GrantedAuthority > grantedAuthorits = new ArrayList< GrantedAuthority >();
      grantedAuthorits.add( new SimpleGrantedAuthority( "ROLE_USER" ) );

      return grantedAuthorits;
   }

}
