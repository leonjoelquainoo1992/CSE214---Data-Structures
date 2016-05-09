
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class Laptop<E> {
	private String brand;
	private double procSpeed;
	private int memory;
	private int hdd;
	
	public Laptop(String brand, double procSpeed, int memory, int hdd){
		this.brand = brand;
		this.procSpeed = procSpeed;
		this.memory = memory;
		this.hdd = hdd;
	}

	public String getBrand() {
		return brand;
	}

	public double getProcSpeed() {
		return procSpeed;
	}

	public int getMemory() {
		return memory;
	}

	public int getHdd() {
		return hdd;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setProcSpeed(double procSpeed) {
		this.procSpeed = procSpeed;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	
	public String toString(){
		return "{"+ brand + ": " + procSpeed + " processor, " + memory +"GB RAM, " + hdd + "GB HDD}";
	}
		@SuppressWarnings("resource")
		public static void main(String[] args) {
	        java.util.Scanner scanner = new java.util.Scanner(System.in);
	        System.out.println("Input data type (must be ’int’ or ’laptop’):");
	        String inputDataType = scanner.nextLine().trim();
	        if (!inputDataType.equals("int") && !inputDataType.equals("laptop")) 
				throw new IllegalArgumentException("Invalid data type specified.");
	        switch (inputDataType) {
	            case "int":
	                ArrayList<Integer> integers = readIntegerInputs(scanner);
	                Sorter<Integer> intSorter = new Quicksorter<>(intComparator,integers);
	                intSorter.sort();
	                System.out.println(getStringJoinedBy(integers, ", "));
	                break;
	            case "laptop":
	                ArrayList<Laptop> laptops = readLaptopInputs(scanner);
	                Sorter<Laptop> laptopSorter = new Quicksorter<>(brandComparator, laptops);
	                laptopSorter.sort();
	                System.out.print("Sorted by brand name:\n\t");
	                System.out.println(getStringJoinedBy(laptops, "\n\t"));
	                System.out.println();
	                laptopSorter.setComparator(processorComparator);
	                laptopSorter.sort();
	                System.out.print("Sorted by processor speed:\n\t");
	                System.out.println(getStringJoinedBy(laptops, "\n\t"));
	                System.out.println();
	                laptopSorter.setComparator(memoryComparator);
	                laptopSorter.sort();
	                System.out.print("Sorted by RAM:\n\t");
	                System.out.println(getStringJoinedBy(laptops, "\n\t"));
	                System.out.println();
	                laptopSorter.setComparator(hddComparator);
	                laptopSorter.sort();
	                System.out.print("Sorted by hard disk capacity:\n\t");
	                System.out.println(getStringJoinedBy(laptops, "\n\t"));
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid data type specified.");
	        }
	}

		private static Comparator<Laptop> processorComparator = new Comparator<Laptop>(){
			@Override
			public int compare(Laptop o1, Laptop o2) {
				if(o1.procSpeed == o2.procSpeed)
					return 0;
				else if(o1.procSpeed > o2.procSpeed)
					return 1;
				else
					return -1;
			}
		};
		
		private static Comparator<Laptop> memoryComparator = new Comparator<Laptop>(){
			@Override
			public int compare(Laptop o1, Laptop o2) {
				if(o1.memory == o2.memory)
					return 0;
				else if(o1.memory > o2.memory)
					return 1;
				else
					return -1;
			}
		};
		
		private static Comparator<Laptop> hddComparator = new Comparator<Laptop>(){
			@Override
			public int compare(Laptop o1, Laptop o2) {
				if(o1.hdd == o2.hdd)
					return 0;
				else if(o1.hdd > o2.hdd)
					return 1;
				else
					return -1;
			}
		};
		
		private static Comparator<Laptop> brandComparator = new Comparator<Laptop>(){
			@Override
			public int compare(Laptop o1, Laptop o2) {
				if(o1.brand.charAt(0) == o2.brand.charAt(0))
					return 0;
				else if(o1.brand.charAt(0) < o2.brand.charAt(0))
					return 1;
				else
					return -1;
			}
			
		};
		private static Comparator<Integer> intComparator = new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 == o2)
					return 0;
				else if(o1 < o2)
					return 1;
				else
					return -1;
			}
		};
	
		private static ArrayList<Integer> readIntegerInputs(Scanner scanner) {
			ArrayList<Integer> list = new ArrayList<>();
			String str;
				System.out.print("Provide integers (one per line)  (type 'end' to finish list): ");
				str = scanner.nextLine();
				while(!str.equals("end")){
				list.add(Integer.parseInt(str));
				str=scanner.nextLine();
				}
			return list;
		}

		private static String getStringJoinedBy(ArrayList<?> list, String string) {
			String str = "";
			if(string.equals("\n\t")){
				for(int i = 0; i < list.size(); i++){
					str += list.get(i)+"\n\t";
				}
			}
			else
				for(int i = 0; i < list.size(); i++){
						str += list.get(i)+",";
				}
			return str;
		}
		
		private static ArrayList<Laptop> readLaptopInputs(Scanner scanner){
			ArrayList<Laptop> laptops = new ArrayList<>();
			String input = scanner.nextLine();
			
			while((!input.equals("end"))){
					System.out.print("Provide laptops (one per line) in the format 'brand,processor-speed,RAM,HDD' (type 'end' to finish "
						+ "list): ");
					String[] str = input.split(",");
					laptops.add(new Laptop(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3])));
					input = scanner.nextLine();
			}
			return laptops;
		}
		

}
