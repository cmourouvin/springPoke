package com.stepinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final Logger logService =  LoggerFactory.getLogger(App.class);
    	
    	logService.info("App : main QuizMaster (info)");
    	logService.debug("App : main QuizMaster (debug)");
    	

    	// Création du service sans Spring
    	
    	// Instance voulu pour l'appel au service
//    	ParentQuizMaster quizMasterStruts = new SpringQuizMaster();
//    	QuizMasterService qmService = new QuizMasterService();
//    	qmService.setQuizMaster(quizMasterStruts);
//    	qmService.poserQuestion();
    	
    	// Service crée avec Spring
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
    	QuizMasterService quizService = (QuizMasterService)appContext.getBean("componentQuizMasterService");
    	
    	// SpringQuizMaster springQm = (SpringQuizMaster)appContext.getBean("springQuizMaster");
    	
    	quizService.poserQuestion();
    	
    	// Accès à un bean spring simple
    	// System.out.print(springQm.parentQuestion());
       
    }
}
