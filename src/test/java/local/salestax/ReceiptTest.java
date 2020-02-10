package local.salestax;

import main.java.local.salestax.AddProduct;
import main.java.local.salestax.Product;
import main.java.local.salestax.Receipt;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.Assert.*;

public class ReceiptTest
{

	Receipt receipt;

	@Before
	public void setUp() throws Exception
	{
		receipt = new Receipt();
		receipt.addToReceipt("music CD", 14.99);
	}

	@After
	public void tearDown() throws Exception
	{
	}


	@Test
	public void addToReceipt()
	{
		receipt.addToReceipt("book", 12.49);
		int result = receipt.getProducts().size();
		assertEquals(1,result);

	}

	@Test
	public void getTotalWithTax()
	{
		// there has got to be a better way format into dollar values.
		DecimalFormat df = new DecimalFormat("0.00");
		receipt.getTotalWithTax();
		String result = df.format(receipt.gettotal());
		assertEquals("16.49", result);
	}

}