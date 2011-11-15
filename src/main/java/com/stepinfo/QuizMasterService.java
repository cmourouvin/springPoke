package com.stepinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("beanQuizService")
public class QuizMasterService {

//	@Autowired
	private ParentQuizMaster quizMaster;
	
//	public QuizMasterService(ParentQuizMaster quizMaster) {
//		super();
//		this.quizMaster = quizMaster;
//	}
	
	
	public void setQuizMaster(ParentQuizMaster quizMaster) {
		this.quizMaster = quizMaster;
	}

	public void poserQuestion() {

		// retourne la question de l'implémentation
		System.out.println("Ma classe mere est : " + super.getClass());
		System.out.println("ParentQuestion : " + quizMaster.parentQuestion());
		System.out.println(quizMaster.popQuestion());
	}

}
