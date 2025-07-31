class Animal {
    String name;
    
    Animal(String animalName){
        name=animalName;
        System.out.println("Animal Is Crated->"+name);
    }

    void makeSound(){
        System.out.println("Animal is making sound");
    }
    
}

class  Dog extends Animal{
    String breed;

    Dog(String dogName,String dogBreed){
        super(dogName);
        breed=dogBreed;
        System.out.println("Dog Is Crated->"+breed);

    }

    void makeSound(){
        super.makeSound();
        System.out.println("Dog is barking");
    }
    void showInfo(){
        System.out.println("Name: "+super.name);
        System.out.println("Breed: "+breed);
    
    }
}