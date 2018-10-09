package sortTriangle;

public class Triangle implements Comparable {
    private String name;
    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private double area;

    public Triangle(String name, double firstSide, double secondSide, double thirdSide) {
        this.name = name;
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;

        double p = (firstSide + secondSide + thirdSide) / 2;
        this.area = Math.sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide));
    }

    public String getName() {
        return name;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "[Triangle " + name + "]: " +  area + " cm";
    }

    @Override
    public int compareTo(Object o) {
        double compareArea=((Triangle)o).getArea();
        return (int) (compareArea - this.area);
    }
}
