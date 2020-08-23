package aforo255.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
@Entity
@Table(name="users")
@UserDefinition
public class Users  extends PanacheEntity  {

	@Username
    public String username;
    @Password
    public String password;
    @Roles
    public String roles;

    public Users() {
    }

    public Users(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public static Users add(String username, String password, String roles) {
        final Users user = new Users(username, BcryptUtil.bcryptHash(password), roles);
        user.persist();
        return user;
    }
	
}
