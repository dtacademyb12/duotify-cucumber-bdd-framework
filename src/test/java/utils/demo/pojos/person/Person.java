
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
public class Person {

    public String login;
    public Integer id;
    public String nodeId;
    public String avatarUrl;
    public String gravatarId;
    public String url;
    public String htmlUrl;
    public String followersUrl;
    public String followingUrl;
    public String gistsUrl;
    public String starredUrl;
    public String subscriptionsUrl;
    public String organizationsUrl;
    public String reposUrl;
    public String eventsUrl;
    public String receivedEventsUrl;
    public String type;
    public Boolean siteAdmin;
    public Object name;
    public Object company;
    public String blog;
    public Object location;
    public Object email;
    public Object hireable;
    public Object bio;
    public Object twitterUsername;
    public Integer publicRepos;
    public Integer publicGists;
    public Integer followers;
    public Integer following;
    public String createdAt;
    public String updatedAt;
    public Integer privateGists;
    public Integer totalPrivateRepos;
    public Integer ownedPrivateRepos;
    public Integer diskUsage;
    public Integer collaborators;
    public Boolean twoFactorAuthentication;
    public Plan plan;

}
