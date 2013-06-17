package Ontology;

public class RandGenerator {
	private static double DISEASE_MIN_P = 0.001;
	private static double DISEASE_MAX_P = 0.05;
	
	private static double SYNDROM_GIVEN_D_MIN_P = 0.9;
	private static double SYNDROM_GIVEN_D_MAX_P = 0.999;

	
	private static double SYNDROM_GIVEN_NOT_D_MIN_P = 0.1;
	private static double SYNDROM_GIVEN_NOT_D_MAX_P = 0.5;
	
	private static double TEST_POSITIVE_GIVEN_D_MIN_P = 0.75;
	private static double TEST_POSITIVE_GIVEN_D_MAX_P = 0.995;

	
	private static double TEST_POSITIVE_GIVEN_NOT_D_MIN_P = 0.01;
	private static double TEST_POSITIVE_GIVEN_NOT_D_MAX_P = 0.2;
	

	public static double getDiseaseP(){
		return DISEASE_MIN_P + Math.random()* (DISEASE_MAX_P-DISEASE_MIN_P);
	}
	
	public static double getPSgivenD(){
		return SYNDROM_GIVEN_D_MIN_P + Math.random()* (SYNDROM_GIVEN_D_MAX_P-SYNDROM_GIVEN_D_MIN_P);
	}
	
	public static double getPSgivenNotD(){
		return SYNDROM_GIVEN_NOT_D_MIN_P + Math.random()* (SYNDROM_GIVEN_NOT_D_MAX_P-SYNDROM_GIVEN_NOT_D_MIN_P);
	}
	
	public static double getPTestGivenD(){
		return TEST_POSITIVE_GIVEN_D_MIN_P + Math.random()* (TEST_POSITIVE_GIVEN_D_MAX_P-TEST_POSITIVE_GIVEN_D_MIN_P);
	}
	
	public static double getPTestGivenNotD(){
		return TEST_POSITIVE_GIVEN_NOT_D_MIN_P + Math.random()* (TEST_POSITIVE_GIVEN_NOT_D_MAX_P-TEST_POSITIVE_GIVEN_NOT_D_MIN_P);
	}
}
