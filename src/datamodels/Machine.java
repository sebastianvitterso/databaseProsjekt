package datamodels;

public class Machine {
	private final int machine_id;
	private String name;
	private String description;
	
	public Machine(int machine_id, String name, String description) {
		this.machine_id = machine_id;
		this.name = name;
		this.description = description;
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
	
	
}
