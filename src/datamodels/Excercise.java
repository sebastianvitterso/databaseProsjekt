package datamodels;



public class Excercise {
	private final int excercise_id;
	private String name;
	private String description;
	private int machine_id;
	
	public Excercise(int excercise_id, String name, String description, int machine_id) {
		this.excercise_id = excercise_id;
		this.name = name;
		this.description = description;
		this.machine_id = machine_id;
	}
	
	public int getExcercise_id() {
		return excercise_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getMachine_id() {
		return machine_id;
	}
	
	public void setMachine_id(int machine_id) {
		this.machine_id = machine_id;
	}
}
