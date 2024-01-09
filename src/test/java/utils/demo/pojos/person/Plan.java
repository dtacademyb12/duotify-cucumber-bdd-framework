
package utils.demo.pojos.person;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

;



@Data  // getter, setters, toString, equals, hashcode
@AllArgsConstructor
@NoArgsConstructor
@Builder // lets you create an object with custom fields initialized without using a custom constructor
@JsonInclude(JsonInclude.Include.NON_NULL) // creates a json only with initialized fields, omits null fields
public class Plan {

    public String name;
    public Integer space;
    public Integer collaborators;
    public Integer privateRepos;

}
