package az.project.l13_update;

public class UpdateExam {
	
	public static void main(String[] args) {
		
		PersonModel personModel = new PersonModel(100,"Irade","HUSEYNZADA");
		
		personModel.setPersonName("Irada");
		
		DBProcess.updatePerson(personModel);
	}

}
