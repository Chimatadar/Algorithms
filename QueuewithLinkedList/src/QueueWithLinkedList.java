import java.util.LinkedList;

abstract class Animal{
private String name;
private int order;

public Animal(String name)
{
	this.name=name;
}

public int getOrder()
{
	return order;
}
public void setOrder(int order) {
	this.order=order;
}

public  boolean isOlderThan(Animal animal) {
	return this.order<animal.order;
}
}

class Dog extends Animal{

	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}

class Cat extends Animal{

	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}

public class QueueWithLinkedList {
	int order=0;
    LinkedList<Dog> dogs=new LinkedList<Dog>();
    LinkedList<Cat> cats=new LinkedList<Cat>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog1=new Dog("tommy");
		Dog dog2=new Dog("Jimmy");
		
		Cat cat1=new Cat("SmellyCat");
		Cat cat2=new Cat("pheobe");
		QueueWithLinkedList queue=new QueueWithLinkedList();
		queue.enquque(dog1);
		queue.enquque(dog2);
        queue.enquque(cat2);
        queue.enquque(dog2);
        System.out.println(queue.dequeueCat());
	}

	public void enquque(Animal animal) {
		animal.setOrder(order);
		order++;
		
		if(animal instanceof Dog)
			dogs.addLast((Dog)animal);
		else {
			cats.addLast((Cat)animal);
		}
	}
	
	public Animal dequeueAll() {
		if(dogs.isEmpty())
			return dequeueCat();
		if(cats.isEmpty())
			return dequeueDog();
		
		Dog dog=dogs.peek();
		Cat cat=cats.peek();
		if(dog.isOlderThan(cat))
		{
			return dequeueDog();
		}
		else {
			return dequeueCat();
		}
		
	}
	
	public Dog dequeueDog() {
		return  dogs.poll();
	}
	
	public Cat dequeueCat() {
		return cats.poll();
	}
	
	
	
	
}
