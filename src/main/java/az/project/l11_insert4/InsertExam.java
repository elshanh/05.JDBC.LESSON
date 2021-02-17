package az.project.l11_insert4;

public class InsertExam {
	
	public static void main(String[] args) {
		
		PersonModel personModel = new PersonModel(103,"Elshan","HUSEYNZADA");	
		DBProcess.insert(personModel);

	}

}
