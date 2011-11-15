package com.stepinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ParentQuizMaster implements QuizMaster {

	public String popQuestion() {
		return "Nouveau dans quel framework ?";
	}

	public final String parentQuestion() {

		final Logger logService =  LoggerFactory.getLogger(ParentQuizMaster.class);

		logService.info("Appel ParentQuestion : " + logService.getName());

		return "Parent class : " + ParentQuizMaster.class;
	}

}
