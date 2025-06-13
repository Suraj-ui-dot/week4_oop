// File: AnimalSounds.java

// Base class
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Subclass Cat
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

// Subclass Cow
class Cow extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Moo! Moo!");
    }
}

// Main class
public class AnimalSounds {
    public static void main(String[] args) {
        // Create an array of Animal references
        Animal[] animals = new Animal[3];

        // Store different animal objects
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Cow();

        // Use polymorphism to call makeSound()
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}

