package com.stepinfo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.classtest.SingletonTest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Logger loggerService = LoggerFactory.getLogger(App.class);
    	Marker fatal = MarkerFactory.getMarker("FATAL");

    	loggerService.info("Start : spring poke");
    	

    	loggerService.error(fatal,"Error");
    	loggerService.warn("warn");
    	loggerService.debug("Debug Hello World {}","LOGS");


    	
//    	logService.info("App : main QuizMaster (info)");
//    	logService.debug("App : main QuizMaster (debug)");
    	

    	// Création du service sans Spring
    	
    	// Instance voulu pour l'appel au service
//    	ParentQuizMaster quizMasterStruts = new SpringQuizMaster();
//    	QuizMasterService qmService = new QuizMasterService();
//    	qmService.setQuizMaster(quizMasterStruts);
//    	qmService.poserQuestion();
    	
    	// Service crée avec Spring
    	
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
    	QuizMasterService quizService = (QuizMasterService)appContext.getBean("beanQuizService");
    	QuizMasterService quizService2 = (QuizMasterService)appContext.getBean("beanQuizService");
    	
    	SpringQuizMaster springQm = (SpringQuizMaster)appContext.getBean("springQuizMaster");
  
    	System.out.println("quizService 1 hash : " + quizService.hashCode());
    	System.out.println("quizService 2 hash : " + quizService2.hashCode() );
    	quizService.poserQuestion();
    	List list = Arrays.asList( new String[] {"fountain", "rocket", "sparkler"});

    	// Test du singleton
    	SingletonTest componentSingleton = (SingletonTest)appContext.getBean("mySingleton");
    	
    	SingletonTest sing1 = componentSingleton.getInstance();
    	System.out.println("Count singleton from 1 : " + sing1.nbInstance());
    	SingletonTest sing2 = SingletonTest.getInstance();
    	System.out.println("Count singleton from 1 : " + sing1.nbInstance());
    	SingletonTest sing3 = SingletonTest.getInstance();
    	System.out.println("Count singleton from 3 : " + sing3.nbInstance());

    	// Accès à un bean spring simple
    	System.out.print(springQm.popQuestion());
    	

    	loggerService.info("End : spring poke");
       
    }
}
