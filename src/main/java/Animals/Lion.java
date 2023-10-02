package Animals;

public class Lion extends Animal implements Actions {
    int age;
    Lion(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public void voice() {
        System.out.println(name + " реве!");
    }

    @Override
    public void play() {
        System.out.println(name + " грається з м'ячем");
    }

    @Override
    public void uniqueInfo() {
        System.out.println(name + " має вік " + age + " років.");
    }
}
