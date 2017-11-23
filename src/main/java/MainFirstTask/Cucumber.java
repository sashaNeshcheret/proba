package MainFirstTask;

public class Cucumber extends CucurbitaceaeVegetable{

	/**
	 * Default constructor.
	 */
	public Cucumber() {
		super("Cucumber", 16);
	}
	
	/**
	 * Constructor with parameters. Creates a Cucumber of a given weight.
	 * @param weight the mass of the vegetable that will be created
	 */
	public Cucumber(double weight) {
		super("Cucumber", 16, weight);
	}
}
