package planet;

import lombok.Getter;

@Getter
public enum Planet {
    MERCURY("Mercury", 57910000, 91691000),
    VENUS("Venus", 108200000, 41400000),
    EARTH("Earth", 149600000, 0),
    MARS("Mars", 227900000, 78360000),
    JUPITER("Jupiter", 778300000, 628730000),
    SATURN("Saturn", 1427000000, 1275000000),
    URANUS("Uranus", 2871000000L, 2725000000L),
    NEPTUNE("Neptune", 4497100000L, 4351000000L);

    private final String name;
    private final double distanceFromSun;  // in kilometers
    private final double distanceFromEarth;  // in kilometers

    Planet(String name, double distanceFromSun, double distanceFromEarth) {
        this.name = name;
        this.distanceFromSun = distanceFromSun;
        this.distanceFromEarth = distanceFromEarth;
    }
}