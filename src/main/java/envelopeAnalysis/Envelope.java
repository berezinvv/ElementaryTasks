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

    public boolean isFitIntoOther(Envelope second) {

        if ((second.getWidth() <= this.getWidth() && second.getHeight() <= this.getHeight()) || (second.getWidth() > this.getWidth() &&
                this.getHeight() >= (2 * this.getHeight() * second.getHeight() * this.getWidth() + (Math.pow(this.getHeight(), 2) - Math.pow(second.getHeight(), 2)) * Math.sqrt(Math.pow(this.getHeight(), 2) + Math.pow(second.getHeight(), 2) - Math.pow(this.getWidth(), 2))) / (Math.pow(second.getWidth(), 2) + Math.pow(second.getHeight(), 2)))) {
            return true;
        }
        return false;
    }
}
