// Code maintenance update

public class Main {

    public static void main(String[] args) {

        // Create an object of Animal class
        Animal animal = new Animal("Generic", 3);
        System.out.println("=== Animal Info ===");
        System.out.println(animal);
        animal.makeSound();

        // Create Dog object (inherits Animal)
        Dog dog = new Dog("Buddy", 5, "Labrador");
        System.out.println("\n=== Dog Info ===");
        System.out.println(dog);
        dog.makeSound();

        // Create Cat object (inherits Animal)
        Cat cat = new Cat("Whiskers", 2, "White");
        System.out.println("\n=== Cat Info ===");
        System.out.println(cat);
        cat.makeSound();

        // Show polymorphism in action
        System.out.println("\n=== Polymorphism Example ===");
        Animal a1 = new Dog("Max", 4, "Beagle");
        Animal a2 = new Cat("Luna", 3, "Gray");

        a1.makeSound(); // Dog version
        a2.makeSound(); // Cat version

        // Upcasting example
        Animal upcastedDog = dog;
        upcastedDog.makeSound(); // still uses Dog's method
        
        // Interface + Polymorphism Example
        System.out.println("\n=== Interface Implementation Example ===");

        Bird parrot = new Bird("Rio", 2, "Macaw");
        System.out.println(parrot);
        parrot.makeSound();

        // Using interface reference
        SoundBehavior sb = parrot;
        sb.makeSound();
        System.out.println("\n=== Inheritance Structure Demonstration Completed ===");
        
     // NEW LINES FOR UPDATE (for Git test)
        System.out.println("\n--- Summary ---");
        System.out.println("Demonstrated inheritance, polymorphism, and interface implementation.");
        System.out.println("Code execution completed successfully!");
        System.out.println("Update done for Git testing.");
    }
}

// Base class
class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    public String toString() {
        return "Animal{name='" + name + "', age=" + age + "}";
    }
}

//Interface for sound behavior
interface SoundBehavior {
 void makeSound();
}

// Child class 1
class Dog extends Animal implements SoundBehavior {

    String breed;

    Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    void makeSound() {
        System.out.println(name + " barks!");
    }

    public String toString() {
        return "Dog{name='" + name + "', age=" + age + ", breed='" + breed + "'}";
    }
}

// Child class 2
class Cat extends Animal implements SoundBehavior {

    String color;

    Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    void makeSound() {
        System.out.println(name + " meows!");
    }

    public String toString() {
        return "Cat{name='" + name + "', age=" + age + ", color='" + color + "'}";
    }
}
//New Advanced class implementing Interface
class Bird extends Animal implements SoundBehavior {
 String species;

 Bird(String name, int age, String species) {
     super(name, age);
     this.species = species;
 }

 public void makeSound() {
     System.out.println(name + " chirps melodiously!");
 }

 public String toString() {
     return "Bird{name='" + name + "', age=" + age + ", species='" + species + "'}";
 }
}

//Updated: small edit for Git test

