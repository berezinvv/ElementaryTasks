package envelopeAnalysis;

public class Envelope {
    private double width;
    private double height;

    public Envelope(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public static boolean compareEnvelope(Envelope first, Envelope second) {

        if ((second.getWidth() <= first.getWidth() && second.getHeight() <= first.getHeight()) || (second.getWidth() > first.getWidth() &&
                first.getHeight() >= (2 * first.getHeight() * second.getHeight() * first.getWidth() + (Math.pow(first.getHeight(), 2) - Math.pow(second.getHeight(), 2)) * Math.sqrt(Math.pow(first.getHeight(), 2) + Math.pow(second.getHeight(), 2) - Math.pow(first.getWidth(), 2))) / (Math.pow(second.getWidth(), 2) + Math.pow(second.getHeight(), 2)))) {
            return true;
        }
        return false;
    }
}
