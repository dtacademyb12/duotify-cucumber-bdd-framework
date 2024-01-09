package utils.demo.pojos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // getter, setters, toString, equals, hashcode
@AllArgsConstructor
@NoArgsConstructor
@Builder // lets you create an object with custom fields initialized without using a custom constructor
@JsonInclude(Include.NON_NULL) // creates a json only with initialized fields, omits null fields
public class User {

    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String signUpDate;
    private String profilePic;
    private String createdAt;



}
