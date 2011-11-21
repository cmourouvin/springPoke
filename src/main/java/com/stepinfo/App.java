package com.stepinfo;

import java.util.Arrays;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.classtest.SingletonTest;
import com.persistence.Personne;
import com.stepinfo.dao.CustomerDAO;
import com.stepinfo.dao.beans.Customer;

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
    	
    	Personne pers = (Personne)appContext.getBean("personne");
    	Personne pers2 = (Personne)appContext.getBean("componentPersonne");
    	Personne personne2 = (Personne)appContext.getBean("personne2");
    	Personne personne3 = (Personne)appContext.getBean("personne3");

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
    	
//    	pers.setAge(19);
//    	pers.setNom("Mourouvin");
//    	pers.setPrenom("Cédric");
//    	pers.setId(Long.parseLong("1"));
//    	pers2 = pers;
//    	pers.creer();
//    	pers2 = pers2.getPersonneById(Long.parseLong("1"));
//    	System.out.print(pers2);
//    	personne2.creer();
//    	personne3.creer();
    	
    	// utilisation de Spring DAO avec JDBC
    	CustomerDAO customerDAO = (CustomerDAO)appContext.getBean("customerDAO");
    	Customer cus = new Customer();
    	int nbElement = customerDAO.getMaxId();
//    	cus.setCustId(nbElement);
    	cus.setAge(20+(nbElement*10)%5);
    	cus.setName("DAOCUSTOMER"+nbElement);
    	customerDAO.insert(cus);
    	
    		// Récupération de ce nouveau ustomer
    	Customer cusInsert = customerDAO.findByCustomerId(1);
    	System.out.print("Customer 1 : " + cusInsert);

    	// Accès à un bean spring simple
    	System.out.print(springQm.popQuestion());

    	loggerService.info("End : spring poke");
       
    }
}
