package Random;

public class WeightedRandomNumber {

	private Country[] countryArray = new Country[10];
	private int randomWt;

	public int populate() {
		for (int i = 0; i < 10; i++) {
			randomWt = (int) (Math.random() * 100 + 1);
			Country c = new Country("C" + i, randomWt);
			countryArray[i] = c;
		}
		return 1;
	}
	

	public int populateStatic() {
		for (int i = 0; i < 10; i++) {
			randomWt = i*13;
			Country c = new Country("C" + i, randomWt);
			countryArray[i] = c;
		}
		return 1;
	}


	public int sumOfWeights() {
		if (countryArray== null)
			return 0;
		else {
			int totalWt = 0;
			for (int i = 0; i < 10; i++) {
				totalWt += countryArray[i].getWt();
			}
			return totalWt;
		}
	}

	public Country[] getCountries() {
		if (countryArray== null)
				return null;
		else return countryArray;
	}
	
	public void printCountries(){
		for (int i = 0; i < 10; i++) {
			System.out.println(countryArray[i].getName() + "     " + countryArray[i].getWt());
		}
	}
	
}
