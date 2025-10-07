
    interface Animal{
        void speak();
    }

    class Dog implements Animal{
        public void speak(){
            System.out.println("Au au!");
        }
    }

    class Cat implements Animal{
        public void speak(){
            System.out.println("Miau!");
        }
    }

    class Rooster implements Animal{
        public void speak(){
            System.out.println("Có, có!");
        }
    }

    class Pig implements Animal{
        public void speak(){
            System.out.println("Porco imundo!");
        }
    }

    class AnimalFactory{
        public static Animal createAnimal(String type){
            if (type.equalsIgnoreCase("dog"))
                return new Dog();
            else if (type.equalsIgnoreCase("cat"))
                return new Cat();
            else if (type.equalsIgnoreCase("rooster"))
                return new Rooster();
            else if (type.equalsIgnoreCase("pig"))
                return new Pig();
            else return null;
        }

         public static void main(String[] args) {
            Animal animal = AnimalFactory.createAnimal("cat");
            animal.speak();
            Animal animal2 = AnimalFactory.createAnimal("pig");
            animal2.speak();
        }
    }
