package com.algodst.algo_dst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class driver {
	public static void main(String[] args) {
		SpringApplication.run(driver.class,args);
		WeightedRandomNumber wrn = new WeightedRandomNumber();

		//WRN.populate();
		wrn.populateStatic();
		int sumTotal = wrn.sumOfWeights();
		Country randomCountry = ReturnRandom(wrn, sumTotal);
		System.out.println(randomCountry.getName() +"   " + randomCountry.getWt());
		System.out.println("_____________________");
		wrn.printCountries();
		
	}

	public static Country returnRandom(WeightedRandomNumber WRN, int TW) {
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
