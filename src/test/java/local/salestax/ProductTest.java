package local.salestax;

import main.java.local.salestax.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductTest
{
	Product book;
	Product importedChocolates;

	@Before
	public void setUp() throws Exception
	{
		book = new Product("book", 12.49);
		importedChocolates = new Product("imported box of chocolates", 10.50);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void getName()
	{
		String result = book.getName();
		assertEquals("book", result);
	}

	@Test
	public void zgetPrice()
	{
		//this is testing the price before we apply taxes to it
		double result = book.getPrice();
		assertEquals(12.49, result, 12.49);
	}


	@Test
	public void isExempt()
	{
		boolean result = book.isExempt();
		assertTrue(result);

		boolean result2 = importedChocolates.isExempt();
		assertTrue(result2);
	}

	@Test
	public void isImported()
	{
		boolean result = book.isImported();
		assertFalse(result);

		boolean result2 = importedChocolates.isImported();
		assertTrue(true);
	}

	@Test
	public void calculateRegularTax()
	{
		book.calculateRegularTax();
		double result = book.getRegularTax();
		assertEquals(0.0, result, 0);

		importedChocolates.calculateRegularTax();
		double result2 = importedChocolates.getRegularTax();
		assertEquals(0.0, result2, 0);
	}

	@Test
	public void calculateImportedTax()
	{
		book.calculateImportedTax();
		double result = book.getImportedTax();
		assertEquals(0.0, result, 0);

		importedChocolates.calculateImportedTax();
		double result2 = importedChocolates.getImportedTax();
		assertEquals(0.55, result2, 0);
	}
}