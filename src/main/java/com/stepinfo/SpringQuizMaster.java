package com.stepinfo;

import org.springframework.stereotype.Component;

@Component("componentSpringQuiz")
public class SpringQuizMaster extends ParentQuizMaster {

	private Integer nbBeans;
	
	public SpringQuizMaster(Integer nbSpringBeans) {
		this.nbBeans = nbSpringBeans;
	}

	public String popQuestion() {
		return "Nouveau sur Spring ?";
	}

	public Integer getNbBeans() {
		return nbBeans;
	}

	public void setNbBeans(Integer nbBeans) {
		this.nbBeans = nbBeans;
	}

}
