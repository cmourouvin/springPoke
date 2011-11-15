package com.stepinfo;

import org.springframework.stereotype.Component;

//@Component("componentStrutsQuiz")
public class StrutsQuizMaster extends ParentQuizMaster {

	public StrutsQuizMaster() {
		super();
	}

	public String popQuestion() {
		return "Nouveau sur Struts ?";
	}

}
