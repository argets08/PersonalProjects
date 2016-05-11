package Random;

public class driver {
	public static void main(String[] args) {
		WeightedRandomNumber WRN = new WeightedRandomNumber();

		//WRN.populate();
		WRN.populateStatic();
		int sumTotal = WRN.sumOfWeights();
		Country randomCountry = ReturnRandom(WRN, sumTotal);
		System.out.println(randomCountry.getName() +"   " + randomCountry.getWt());
		System.out.println("_____________________");
		WRN.printCountries();
		
	}

	public static Country ReturnRandom(WeightedRandomNumber WRN, int TW) {
		double  random = Math.random() * TW;
		Country[] cArr = WRN.getCountries();
		int counter = 0;
		for (int i = 0; i < cArr.length; i++) {
			random = random - cArr[i].getWt();

			if (random <= 0) {
				counter = i;
				break;
			}
		}
		return cArr[counter];

	}
}
