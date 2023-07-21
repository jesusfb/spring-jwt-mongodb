package com.auth.jwtserver.document;

import java.util.Collection;
import java.util.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@RequiredArgsConstructor
public class Product implements ProductDetails {

	@Id
    private String id;

	@Indexed(unique = true)
    @NonNull
    private String productname;
 
}
