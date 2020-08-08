package aforo255.com.entity;

public class Account {
	private String id;
	private String alias;
    private String desciprion;
    
    
	public Account(String id, String alias, String desciprion) {		
		this.id = id;
		this.alias = alias;
		this.desciprion = desciprion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDesciprion() {
		return desciprion;
	}
	public void setDesciprion(String desciprion) {
		this.desciprion = desciprion;
	}
    
	
}
