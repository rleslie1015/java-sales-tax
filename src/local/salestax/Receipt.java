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
			if (p.isExempt() && !p.isImported())
			{
				p.setImportedTax(0.00);
				p.setRegularTax(0.00);
				settotal(total += p.getPrice());
			}
			// both tax
			else if (!p.isExempt() && p.isImported())
			{
				p.setRegularTax(p.calculateRegularTax());
				p.setImportedTax(p.calculateImportedTax());
				p.setPrice(p.getPrice() + p.getRegularTax() + p.getImportedTax());
				setSalesTax(getSalesTax() + p.getRegularTax() + p.getImportedTax());
				settotal(total += p.getPrice());
			}
			// or just imported tax
			else if (p.isExempt() && p.isImported())
			{
				p.setImportedTax(p.calculateImportedTax());
				p.setPrice(p.getPrice() + p.getImportedTax());
				setSalesTax(getSalesTax() + p.getImportedTax());
				settotal(total += p.getPrice());
			}
			// or just regular tax
			else if (!p.isExempt() && !p.isImported())
			{
				p.setRegularTax(p.calculateRegularTax());
				p.setPrice(p.getPrice() + p.getRegularTax());
				setSalesTax(getSalesTax() + p.getRegularTax());
				settotal(total += p.getPrice());
			}
		}
	}


	@Override
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		StringBuilder stringBuilder = new StringBuilder("");
		for (Product p : products) {
			stringBuilder.append("1 "+ p.getName() + ": " + df.format(p.getPrice()) + "\n");
		}
		return stringBuilder + "Sales Taxes: " + df.format(salesTax) + "\nTotal: " + df.format(total) + '\n';
	}
}
