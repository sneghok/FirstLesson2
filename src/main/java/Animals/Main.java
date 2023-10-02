package Animals;

public class Main {
    public static void main(String[] args) {
        Lion lion = new Lion("Лев Симба", 5);
        Elephant elephant = new Elephant("Слон Дамбо", "grey");
        Monkey monkey = new Monkey("Мавпа Кінг-Конг", true);

        ZooVisitor zooVisitor = new ZooVisitor();

        zooVisitor.visitAnimal(lion);
        zooVisitor.visitAnimal(elephant);
        zooVisitor.visitAnimal(monkey);
    }
}
