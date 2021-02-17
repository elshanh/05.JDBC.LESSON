package az.project.l15_selectById;

import az.project.l15_selectById.PersonModel;

public class SelectExam {
	
	public static void main(String[] args) {
		
		PersonModel personModel = DBProcess.selectByPersonId(103);
		System.out.println(personModel);
		
	}

}
