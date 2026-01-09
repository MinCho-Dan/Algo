public class Person implements Comparable<Person> {
	
	int age;
	int no;
	
	
	public Person() {}


	public Person(int age, int no) {
		super();
		this.age = age;
		this.no = no;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	@Override
	public String toString() {
		return "Person [age=" + age + ", no=" + no + "]";
	}


	@Override
	public int compareTo(Person o) {
		return o.getAge() - this.getAge();
	}
	
	
	

}
