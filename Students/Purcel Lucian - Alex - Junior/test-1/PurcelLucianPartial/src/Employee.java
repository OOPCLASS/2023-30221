
public class Employee {

	private static int nextId = 0;
	private int id;
	private String name;
	private String position;

	public Employee(String name, String position) {
		this.setId(nextId++);
		this.name = name;
		this.setPosition(position);
	}

	public void displayInfo() {
		System.out.println("Employee ID: " + getId());
		System.out.println("Name: " + name);
		System.out.println("Position: " + getPosition());
	}
    
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
