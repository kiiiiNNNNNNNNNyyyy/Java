public class Animal {
    
    private int brain;
    private int body;
    private int size;
    private int weight;
    private String name;
    
	public Animal(int brain, int body, int size, int weight, String name) {
		this.brain = brain;
		this.body = body;
		this.size = size;
		this.weight = weight;
		this.name = name;
	}

	public int getBrain() {
		return brain;
	}

	public void setBrain(int brain) {
		this.brain = brain;
	}

	public int getBody() {
		return body;
	}

	public void setBody(int body) {
		this.body = body;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public void eat() {
        System.out.println("Animal.eat called");
    }

    public void move(int speed) {
        System.out.println("Animal is movin at " + speed);
    }
}