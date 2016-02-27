/*
 * Name: Joel Quainoo
 * ID: 110688594
 * CSE 214 Assignment One
 */
import java.util.Scanner;

public class Point2D extends OrderedDoublePair {
	OrderedDoublePair pair = new OrderedDoublePair();
	
	public Point2D(double x, double y){
		super(x,y);
	}

	//Return the distance of two ordered points
	public static double distance(OrderedDoublePair p, OrderedDoublePair q){
		return Math.sqrt(Math.pow((p.getX() - q.getX()), 2) + Math.pow((p.getY() - q.getY()), 2));	//returns euclidean distance <double>
	}
	
	//Return the list of points. takes in an OrderdDoublePair points as arguments
	public static UnilinkedList<OrderedDoublePair> fromArray(OrderedDoublePair[] points){
		UnilinkedList<OrderedDoublePair> list = new UnilinkedList<>();
		for(int i = 0; i < points.length; i++){
			list.add(points[i]);
		}
		return list;
	}
	
	public static UnilinkedList<OrderedDoublePair> from2DArray(double[][] points){
		UnilinkedList<OrderedDoublePair> list = new UnilinkedList<>();
		for(int i = 0; i < points.length; i++){
			for(int j = 0; j < points[i].length; j++){
				list.add(new OrderedDoublePair(points[i][j-1], points[i][j]));
			}
		}
		return list;
	}
	
	public static double getDist(OrderedDoublePair pair){
		return Math.sqrt(Math.pow(pair.getX(), 2) + Math.pow(pair.getY(), 2));
	}
	
	
	public static OrderedDoublePair centroid(UnilinkedList<OrderedDoublePair> points){
		OrderedDoublePair c;
		int xCount = 0, yCount = 0;
		double sumX = 0, sumY = 0;
		for(int i = 0; i < points.size(); i++){
			sumX += points.getUnilinkedListData().getX();  ; sumY += points.getUnilinkedListData().getY(); //re-implement this method
			xCount++; yCount++;
		}
		c = new OrderedDoublePair((sumX / xCount), (sumY / yCount));
		return c;	
	}
	
	public static OrderedDoublePair smallest(UnilinkedList<OrderedDoublePair> points){
		OrderedDoublePair getPointData, smallest = points.getUnilinkedListData();
		double shortestDist = distance(smallest, OrderedDoublePair.ORIGIN);
		for(int i = 0; i < points.size(); i++){
			getPointData = points.getUnilinkedListData();
			if(shortestDist > distance(getPointData, OrderedDoublePair.ORIGIN)){
				smallest = getPointData;
				shortestDist = distance(getPointData, OrderedDoublePair.ORIGIN);
			}
		}
		return smallest;
	}
	/**
	 * Return the longest distance from the origin
	 * @param points - which Unilinkedlist<E>
	 * @return an orderedPir of the points
	 */
	public static OrderedDoublePair largest(UnilinkedList<OrderedDoublePair> points){
		OrderedDoublePair getPointData, largest = points.getUnilinkedListData();
		double longDist = distance(largest, OrderedDoublePair.ORIGIN);
		for(int i = 0; i < points.size(); i++){
			getPointData = points.getUnilinkedListData();
			if(longDist <= distance(getPointData, OrderedDoublePair.ORIGIN)){
				largest = getPointData;
				longDist = distance(getPointData, OrderedDoublePair.ORIGIN);
			}
		}
		return largest;
	}
	
	public static OrderedDoublePair closerToCentroid(UnilinkedList<OrderedDoublePair> points){
		OrderedDoublePair getPointData, smallestToCentroid = points.getUnilinkedListData();
		UnilinkedList<OrderedDoublePair> list = new UnilinkedList<>();
		double shortestDist = distance(smallestToCentroid, centroid(list));
		for(int i = 0; i < points.size(); i++){
			getPointData = points.getUnilinkedListData();
			if(shortestDist > distance(getPointData, OrderedDoublePair.ORIGIN)){
				smallestToCentroid = getPointData;
				shortestDist = distance(getPointData, OrderedDoublePair.ORIGIN);
			}
		}
		return smallestToCentroid;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		String done = null;
		UnilinkedList<OrderedDoublePair> list = new UnilinkedList<>();
		Scanner input = new Scanner(System.in);
		String getPoints;
		boolean isDone = false;
		while(!isDone){
			System.out.println("Enter “x y” as points: ");
			getPoints = input.nextLine();
			if(!getPoints.equalsIgnoreCase("done")){
			String[] points = getPoints.split(" ");
			points[0] = points[0];
			points[1] = points[1];
			list.add(new OrderedDoublePair(Double.parseDouble(points[0]), Double.parseDouble(points[1])));
			}
			else
				isDone = true;
		}
		System.out.println("List is " + list);
		System.out.println("Centroid = " + centroid(list));
		System.out.printf("%s  is a point closest to the Centroid. ", closerToCentroid(list));
		list.deduplicate();
		System.out.println();
		System.out.println("Centroid of unique points = " + centroid(list));
		System.out.println("Nearest point to the origin = " + smallest(list));
		System.out.println("Farthest point to the origin = " + largest(list));
		OrderedDoublePair pair;
		for(int i = 0; i < list.size(); i++){
			pair = list.getUnilinkedListData();
			if((pair.getX() + pair.getY()) % 2 == 0)
				list.remove(pair);
		}
		System.out.println("After removing even-summed points, the list is: "+ list.toString());
		input.close();
		
	}

}
