package az.project.l12_batchInsert;

import java.util.ArrayList;
import java.util.List;

public class InsertExam {
	
	public static void main(String[] args) {
		
		PersonModel personModel1 = new PersonModel(104,"Yegane","HUSEYNZADA");
		PersonModel personModel2 = new PersonModel(105,"Reshad","HUSEYNZADA");
		PersonModel personModel3 = new PersonModel(106,"Mahire","ISMAYILOVA");
		PersonModel personModel4 = new PersonModel(107,"Irade","ISMAYILOVA");
		
		List<PersonModel> personList = new ArrayList<PersonModel>();
		
		personList.add(personModel1);
		personList.add(personModel2);
		personList.add(personModel3);
		personList.add(personModel4);
		
		DBProcess.insertListPerson(personList);
	}

}
