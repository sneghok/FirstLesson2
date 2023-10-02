package Animals;

class ZooVisitor {
    public void visitAnimal(Animal animal) {
        System.out.println("\nТварина: " + animal.name);
        if (animal instanceof Actions) {
            Actions actions = (Actions) animal;
            actions.voice();
            actions.play();
            actions.uniqueInfo();
        }
    }
}
