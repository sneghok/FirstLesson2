package planet;

public class PlanetVisibilityCalculator {
    private static final double SPEED_OF_LIGHT = 299792.458;  // in kilometers per second

    public static void main(String[] args) {
        for (Planet planet : Planet.values()) {
            double timeToInvisibility = calculateTimeToInvisibility(planet);
            System.out.printf("Time for %s to become invisible: %.2f seconds\n", planet, timeToInvisibility);
        }
    }

    private static double calculateTimeToInvisibility(Planet planet) {
        return (planet.getDistanceFromEarth() + planet.getDistanceFromSun()) / SPEED_OF_LIGHT;
    }
}
