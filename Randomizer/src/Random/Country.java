package Random;

public class Country {

	private int weight;
	private String countryName;
	
	public Country(){
		
	};
	public Country(String name, int weight){
		this.weight = weight;
		this.countryName = name;
	}
	public int getWt(){
		return this.weight;
	}
	public String getName(){
		return this.countryName;
	}
}
