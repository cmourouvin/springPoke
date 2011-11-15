package com.stepinfo;

import org.springframework.stereotype.Component;

//@Component("componentSpringQuiz")
public class SpringQuizMaster extends ParentQuizMaster {

	public SpringQuizMaster() {
		super();
	}

	public String popQuestion() {
		return "Nouveau sur Spring ?";
	}

}
