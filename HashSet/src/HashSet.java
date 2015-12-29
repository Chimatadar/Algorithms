import java.util.Iterator;

class Employee{
	private int id;
	private String name;
	
	public Employee(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
	}
	
	public String toString() {
		return "ID "+ this.id + " Name "+ this.name;
	}
}
public class HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.HashSet<Employee> emp=new java.util.HashSet<Employee>();
		emp.add(new Employee(1, "Shivakiran"));
		emp.add(new Employee(2, "Joey"));
		emp.add(new Employee(3, "Chandler"));
		
		Iterator<Employee> empIt=emp.iterator();
		while (empIt.hasNext()) {
			System.out.println(empIt.next());
			
		}
		

	}

}
