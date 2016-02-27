/*Name: Joel Quainoo
 * ID: 110688594
 * CSE 214 Assignment One
 */
/**
 * OrderedDoublePair.java class contains:
 	 * default constructor
 	 * 
 	 *Constructor which takes in integer values public OrderedDoublePair(int x, int y) 
 	 *@param x  
 	 *@param y
 	 *
	 * Constructor which takes in double values public OrderedDoublePair(double x, double y)
	 * @param x
	 * @param y
	 * 
	 * Getters method (public double getX() && public double getY()) for the private fields (x,y) 
	 * @return x, y  -- Get the current x and y of this OrderedDoublePair()
	 * 
	 * Setter (public void setX(double x)) method for private field x 
	 * @param x
	 * 
	 * Setter (setY) method for private field Y 
	 * @param y
	 * 
	 * A method equals() which takes in an Object and returns a boolean of two ordered pair point.
	 * example: (2.0,3.0) & (2.0,3.0) are considered equal.  
	 * 
	 * A method equalsIgnoreOrder() which takes in an Object and returns a boolean of two ordered pair point ignoring order.
	 * example: (2.0,3.0) & (3.0,2.0) are considered equal. 
	 * 
	 * A toString() method. Returns a string of the points.
	 *
	 * A hashCode() method that returns (31 * result + (int) (temp ^ (temp >>>  32));
*/

public class OrderedDoublePair {
	private double x; //x coordinate
	private double y; //y coordinate
	private static final double x_coordinate = 0; // x coordinate constant for OrderedDoublePair
	private static final double y_coordinate = 0;
	protected static OrderedDoublePair ORIGIN = new OrderedDoublePair(x_coordinate, y_coordinate);
	
	public OrderedDoublePair(){
		
	}
	
	public OrderedDoublePair(int x, int y){
		this.x = (double) x;
		this.y = (double) y;
		
	}
	
	public OrderedDoublePair(double x, double y){
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public OrderedDoublePair getORIGIN() {
		return ORIGIN;
	}

	public void setORIGIN(OrderedDoublePair ORIGIN) {
		OrderedDoublePair.ORIGIN = ORIGIN;
	}

	public boolean equals(Object points){
		return (points instanceof OrderedDoublePair && (this.x == ((OrderedDoublePair)points).x) && (this.y == ((OrderedDoublePair)points).y));
	}
	
	public boolean equalsIgnoreOrder(Object points){
		return (points instanceof OrderedDoublePair && (this.x == ((OrderedDoublePair)points).y) && (this.y == ((OrderedDoublePair)points).x));
	}
	
	public String toString(){
		return "(" + this.x + "," + this.y + ")";
	}
	
    @Override
    public int hashCode() { 
    	int result;
        long temp = Double.doubleToLongBits (x);
        result = (int)  (temp ^ (temp >>>  32));
        temp = Double.doubleToLongBits (y);
        return 31 * result + (int) (temp ^ (temp >>>  32));
    }
	
}
