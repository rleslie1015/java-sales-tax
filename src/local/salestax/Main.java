package local.salestax;


public class Main {

    public static void main(String[] args) {
	// first receipt
        System.out.println("*** RECEIPT #1 ***");

        Receipt receipt1 = new Receipt();

        receipt1.addToReceipt("book", 12.49);
        receipt1.addToReceipt("music CD", 14.99);
        receipt1.addToReceipt("chocolate bar", .85);

        receipt1.getTotalWithTax();

        System.out.println(receipt1.toString());

    // second receipt
        System.out.println("*** RECEIPT #2 ***");
        // create receipt
        Receipt receipt2 = new Receipt();
        // add products to receipt
        receipt2.addToReceipt("imported box of chocolates", 10.00);
        receipt2.addToReceipt("imported bottle of perfume", 47.50);
        // calculate total with taxes
        receipt2.getTotalWithTax();
        //print receipt
        System.out.println(receipt2.toString());

     // third receipt
        System.out.println("*** RECEIPT #3 ***");

        Receipt receipt3 = new Receipt();

        receipt3.addToReceipt("imported bottle of perfume", 27.99);
        receipt3.addToReceipt("bottle of perfume", 18.99);
        receipt3.addToReceipt("packet of headache pills", 9.75);
        receipt3.addToReceipt("imported box of chocolates", 11.25);

        receipt3.getTotalWithTax();

        System.out.println(receipt3.toString());
    }
}
