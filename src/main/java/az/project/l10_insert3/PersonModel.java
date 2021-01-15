package az.project.l10_insert3;

public class PersonModel {
	
	private int personId;
	private String personName;
	private String personSurname;
	
	public PersonModel() {
		
	}

	public PersonModel(int personId, String personName, String personSurname) {
		this.personId = personId;
		this.personName = personName;
		this.personSurname = personSurname;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonSurname() {
		return personSurname;
	}

	public void setPersonSurname(String personSurname) {
		this.personSurname = personSurname;
	}

	@Override
	public String toString() {
		return "PersonModel [personId=" + personId + ", personName=" + personName + ", personSurname=" + personSurname
				+ "]";
	}
	
	
	
}
