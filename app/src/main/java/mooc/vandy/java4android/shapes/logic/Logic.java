package mooc.vandy.java4android.shapes.logic;

import java.util.Locale;

import mooc.vandy.java4android.shapes.ui.OutputInterface;

import static java.lang.String.format;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /*
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough)
     */
    private final OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    @Override
    public void process() {
        // Get which calculation should be computed.  Do not worry
        // about the specifics of this right now.
        Shapes shapeForCalculations = mOut.getShape();

        // Store the values returned by the User Interface.
        double mLength = mOut.getLength();
        double mWidth = mOut.getWidth();
        double mHeight = mOut.getHeight();
        double mRadius = mOut.getRadius();

        // Determine which calculation to process right now.  Again,
        // do not worry about the specifics of how this works for now.
        switch (shapeForCalculations) {
            case Box:
                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " by "
                        + mHeight
                        + " box has a volume of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", boxVolume(mLength, mWidth, mHeight)));
                mOut.println();

                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " by "
                        + mHeight
                        + " box has a surface area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", boxSurfaceArea(mLength, mWidth, mHeight)));
                mOut.println();
                // If you are paying attention, you will notice that
                // there is no 'break;' here like there is in other
                // places, meaning that if 'Box' was selected, it will
                // run the two sets of print statements above and the
                // two statements below until the 'break;' statement.
            case Rectangle:
                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " rectangle has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rectanglePerimeter(mLength, mWidth)));
                mOut.println();

                mOut.print("A "
                        + mLength
                        + " by "
                        + mWidth
                        + " rectangle has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rectangleArea(mLength, mWidth)));
                mOut.println();
                break;
            case Sphere:
                mOut.print("A sphere with radius " + mRadius + " has a volume of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", sphereVolume(mRadius)));
                mOut.println();

                mOut.print("A sphere with radius " + mRadius + " has surface area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", sphereSurfaceArea(mRadius)));
                mOut.println();
                // Same here as with 'Box' above. If 'Sphere' is picked, it will run the
                // two sets of print statements above and the two below until the 'break;'
            case Circle:
                mOut.print("A circle with radius " + mRadius + " has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", circleCircumference(mRadius)));
                mOut.println();

                mOut.print("A circle with radius " + mRadius + " has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", circleArea(mRadius)));
                mOut.println();
                break;
            case Triangle:
                mOut.print("A right triangle with base "
                        + mLength
                        + " and height "
                        + mWidth + " has a perimeter of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rightTrianglePerimeter(mLength, mWidth)));
                mOut.println();

                mOut.print("A right triangle with base "
                        + mLength
                        + " and height "
                        + mWidth
                        + " has area of: ");
                mOut.println(format(Locale.getDefault(), "%.2f", rightTriangleArea(mLength, mWidth)));
                mOut.println();
                break;
            default:
                break;
        }
    }

    public static double rectangleArea(double length, double width){
        double area=length * width;
        return area;
    }
    public static double rectanglePerimeter(double length, double width){
        double perimeter=2*(length + width);
        return perimeter;
    }
    public static double circleArea(double radius){
        double area= radius*radius*Math.PI;
        return area;
    }
    public static double circleCircumference(double radius){
        double perimeter=radius*2*Math.PI;
        return perimeter;
    }
    public static double rightTriangleArea(double base, double height){
        double area=(1/2)*height * base;
        return area;
    }
    public static double rightTrianglePerimeter(double base, double height){
        double perimeter=base + height+Math.sqrt(Math.pow(base,2)+Math.pow(height,2));
        return perimeter;
    }
    public static double boxVolume(double length, double width, double depth){
        double volume = length * width* depth;
        return volume;
    }
    public static double boxSurfaceArea(double length, double width, double depth){
        double surfaceArea = 2*(length * width)+2*(length * depth)+2*(depth * width);
        return surfaceArea;
    }
    public static double sphereVolume(double radius){
        double volume =(4/3)*Math.PI*Math.pow(radius,3);
        return volume;
    }
    public static double sphereSurfaceArea(double radius){
        double surfaceArea =4*Math.PI*Math.pow(radius,2);
        return surfaceArea;
    }

    
}
