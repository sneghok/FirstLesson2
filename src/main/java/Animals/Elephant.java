package Animals;

class Elephant extends Animal implements Actions {
    String color;

    Elephant(String name, String color) {
        super(name);
        this.color = color;
    }

    @Override
    public void voice() {
        System.out.println(name + " трубить!");
    }

    @Override
    public void play() {
        System.out.println(name + " грається у воді");
    }

    @Override
    public void uniqueInfo() {
        System.out.println(name + " має колір " + color + ".");
    }
}

