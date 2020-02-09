package local.salestax;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class Receipt implements AddProduct, CashierFunctions
{

	private List<Product> products = new ArrayList<>();
	private double salesTax =0;
	private double total = 0;

	public Receipt()
	{
	}

	public List<Product> getProducts()
	{
		return products;
	}

	public void setProducts(List<Product> products)
	{
		this.products = products;
	}

	public double getSalesTax()
	{
		return salesTax;
	}

	public void setSalesTax(double salesTax)
	{
		this.salesTax = salesTax;
	}

	public double gettotal()
	{
		return total;
	}

	public void settotal(double total)
	{
		total = total;
	}

	@Override
	public void addToReceipt(String name, double price)
	{
		getProducts().add(new Product(name, price));
	}

	@Override
	public void getTotalWithTax()
	{
		// loop through products calculating sales tax & set taxes for each product & each product total
		for (Product p : products)
		{
			// products either have no tax
			if (p.isExempt() == true && p.isImported() == false)
			{
				p.setImportedTax(0.00);
				p.setRegularTax(0.00);
				settotal(total += p.getPrice());
			}
			// both tax
			else if (p.isExempt() == false && p.isImported() == true)
			{
				p.setRegularTax(p.calculateRegularTax());
				p.setImportedTax(p.calculateImportedTax());
				p.setPrice(p.getPrice() + p.getRegularTax() + p.getImportedTax());
				setSalesTax(getSalesTax() + p.getRegularTax() + p.getImportedTax());
				settotal(total += p.getPrice());
			}
			// or just imported tax
			else if (p.isExempt() == true && p.isImported() == true)
			{
				p.setImportedTax(p.calculateImportedTax());
				p.setPrice(p.getPrice() + p.getImportedTax());
				setSalesTax(getSalesTax() + p.getImportedTax());
				settotal(total += p.getPrice());
			}
			// or just regular tax
			else if (p.isExempt() == false && p.isImported() == false)
			{
				p.setRegularTax(p.calculateRegularTax());
				p.setPrice(p.getPrice() + p.getRegularTax());
				setSalesTax(getSalesTax() + p.getRegularTax());
				settotal(total += p.getPrice());
			}
			//outside the loop return total
		}
	}


	@Override
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return products.toString() + " salesTax: " + df.format(salesTax) + "\n total: " + df.format(total) + '\n';
	}
}
