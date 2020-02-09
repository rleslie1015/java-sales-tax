package local.salestax;

import java.text.DecimalFormat;


public class Product
{
	//fields
	private String name;

	private double price;

	private double regulartax = 0.00;

	private double importedTax= 0.00;

	//default constructor
	public Product()
	{
	}

	public Product(String name, double price)
	{
		this.name = name;
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public double getRegularTax()
	{
		return regulartax;
	}

	public void setRegularTax(double regulartax)
	{
		this.regulartax = regulartax;
	}

	public double getImportedTax()
	{
		return importedTax;
	}

	public void setImportedTax(double importedTax)
	{
		this.importedTax = importedTax;
	}

	public boolean isExempt()
	{
		if (getName().contains("book") || getName().contains("chocolate") || getName().contains("pill")){
			return true;
		} return false;
	}

	public boolean isImported()
	{
		if (getName().contains("imported"))
		{
			return true;
		} return false;
	}

	public double calculateRegularTax(){
		//calculate 10% tax rounded
		double taxes = Math.round((getPrice() / 10)*100)/100.0;

		//rounded up to the nearest 0.05
		taxes = Math.ceil(taxes*20)/20.0;

		//set the tax for the item
		setRegularTax(taxes);

		return getRegularTax();
	}

	public double calculateImportedTax() {
		double tenPercent = Math.round((getPrice() / 10)*100)/100.0;
		double fivePercent = Math.round(tenPercent/2*100)/100.0;
		//rounded up to the nearest 0.05
		fivePercent = Math.ceil(fivePercent*20)/20.0;

		//set the imported tax for the item
		setImportedTax(fivePercent);
		return getImportedTax();
	}

}
