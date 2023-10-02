package Animals;

class Monkey extends Animal implements Actions {
    boolean isFriendly;

    Monkey(String name, boolean isFriendly) {
        super(name);
        this.isFriendly = isFriendly;
    }

    @Override
    public void voice() {
        System.out.println(name + " кричить!");
    }

    @Override
    public void play() {
        System.out.println(name + " грається на гілці");
    }

    @Override
    public void uniqueInfo() {
        System.out.println(name + " є " + (isFriendly ? "дружелюбною" : "агресивною") + " мавпою.");
    }
}

