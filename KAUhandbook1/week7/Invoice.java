//Invoice class implements Payable
public class Invoice implements Payable
{
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	public Invoice( String part, String description, int count, double price )
	{
		partNumber = part;
		partDescription = description;
		setQuantity(count);	// validate and store quantity
		setPricePerItem(price);	// validate and store price per item
	}
	
	/*  뭔진 몰라도 중간에 21줄부터 68째줄까지 생략되있음 */
	
	@Override
	public String toString()
	{
		return String.format("%s: %s\n%s: %s (%s) \n%s: %d \n%s: $%,.2f",
				"invoice","part number",getPartNumber(), getPartDescription(),"quantity",
				getQuantity(),"price per item", getPricePerItems());
	}
	
	@Override
	public double getPaymentAmount()
	{
		return getQuantity * getPricePerItem(); //calculate total cost
	}
}
