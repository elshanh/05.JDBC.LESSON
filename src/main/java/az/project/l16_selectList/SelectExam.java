package az.project.l16_selectList;

import java.util.List;

import az.project.l16_selectList.PersonModel;

public class SelectExam {
	
	public static void main(String[] args) {
		
		List<PersonModel> personModelList  = DBProcess.selectPersonList();
		personModelList.forEach(System.out::println);
		
	}

}
