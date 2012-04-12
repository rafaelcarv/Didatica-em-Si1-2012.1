package ufcg.edu.br.bigu.easyaccept;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import ufcg.edu.br.bigu.Fachada;

import easyaccept.EasyAcceptFacade;

public class US01Test extends TestCase {

	public US01Test(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(US01Test.class);
	}

	public void testarEasyAcceptScript() {
		
		List<String> files = new ArrayList<String>();
		// Put the us1.txt file into the "test scripts" list
		files.add("scripts/US01.txt");

		// Instantiate the Monopoly Game fa�ade
		Fachada fachadaBigu = Fachada.getInstance();

		// Instantiate EasyAccept fa�ade
		EasyAcceptFacade eaFacade = new EasyAcceptFacade(fachadaBigu, files);

		// Execute the tests
		eaFacade.executeTests();

		// Print the tests execution results
		System.out.println(eaFacade.getCompleteResults());
		
		
		assertTrue(eaFacade.getTotalNumberOfNotPassedTests() == 0);
	}

	public static void main(String[] args) throws Exception {

		List<String> files = new ArrayList<String>();
		// Put the us1.txt file into the "test scripts" list
		files.add("scripts/US01.txt");

		// Instantiate the Monopoly Game fa�ade
		Fachada fachadaBigu = Fachada.getInstance();

		// Instantiate EasyAccept fa�ade
		EasyAcceptFacade eaFacade = new EasyAcceptFacade(fachadaBigu, files);

		// Execute the tests
		eaFacade.executeTests();

		// Print the tests execution results
		System.out.println(eaFacade.getCompleteResults());
	}

}
