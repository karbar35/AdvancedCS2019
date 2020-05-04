// Declare the APLine class
class APLine
{
 /** State variables. Any numeric type; object or primitive. */
    private int a;
    private int b;
    private int c;
    

 /** Constructor with 3 int parameters. */
    public APLine(int a1, int b1, int c1) {
        a = a1;
        b = b1;
        c = c1;
    }
 /** Determine the slope of this APLine. */
    public double getSlope() {
        return -1.0 * a / b;
    }
 /** Determine if coordinates represent a point on this APLine. */
    public boolean isOnLine(int x, int y) {
        if(a*x + b*y + c == 0) return true;
        return false;
    }
    
    public static void main(String[] args) {
        APLine line1 = new APLine(5, 4, -17);
        double slope1 = line1.getSlope();        // slope1 is assigned -1.25
        boolean onLine1 = line1.isOnLine(5, -2); // true because 5(5) + 4(-2) + (-17) = 0
        
        System.out.println("slope1: " + slope1);
        System.out.println("onLine1: " + onLine1);

        APLine line2 = new APLine(-25, 40, 30);
        double slope2 = line2.getSlope();        // slope2 is assigned 0.625
        boolean onLine2 = line2.isOnLine(5, -2);
        System.out.println("slope2: " + slope2);
        System.out.println("onLine2: " + onLine2);


    }
}
