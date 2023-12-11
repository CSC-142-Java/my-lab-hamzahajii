package labs;

import java.awt.Color;
import java.awt.Graphics;


public class CirclesLab {

    public static void testDrawable(Viewer display, Drawable circles) throws Exception {

        Shapes circleShape = (Shapes) circles;


        //TODO: Set Location to (50, 50)
        circleShape.setLocation(50,50);

        // TODO : Clear then Pause for 250 milliseconds
        display.pause(250);

        // TODO : Move location by (50, 0) and draw Yellow Circles
        circleShape.move(50,100);
        circles.draw(Color.YELLOW);

        // TODO : Move location by (0, 100) and draw RED Circles
        circleShape.move(0,100);
        circles.draw(Color.RED);

        // TODO : Move location by (0, 100) and draw Circles with Fillable AZUL
        circleShape.move(0,100);
        circles.draw(Fillable.AZUL);

        // TODO : Pause for 250 milliseconds
        display.pause(250);
    }

    public static void testFillable(Viewer display, Fillable circles) throws Exception {

        Shapes circleShape = (Shapes) circles;
        //TODO: Set Location to (40, 40)
        circleShape.setLocation(40, 40);

        // TODO : Pause for 250 milliseconds
        display.pause(250);

        // TODO : Draw fillable RED Circles then move (-25,40)
        circles.fill(Color.RED);
        circleShape.move(-25, 40);

        // TODO : Draw fillable WHITE Circles then move (50,-50)
        circles.fill(Color.WHITE);
        circleShape.move(50,-50);

        // TODO : Draw fillable AZUL Circles
        circles.fill(Fillable.AZUL);

        // TODO : Pause for 250 milliseconds
        display.pause(250);

    }

    public static void main(String[] args) throws Exception{

        Viewer viewer01 = new Viewer(50, 50, 600, 600);
        Viewer viewer02 = new Viewer(800, 50, 400, 600);
        viewer01.setBackground(Color.BLACK);
        viewer02.setBackground(Color.BLACK);

        // Get Graphics graphic Object for Drawing in Window
        Graphics graphic01 = viewer01.getGraphics();
        Graphics graphic02 = viewer02.getGraphics();

        // TODO : Create Circles of a Fillable Type with graphics object 1
        Fillable fillableCircles = new Circles(graphic01);

        // TODO : Use testFillable to draw Fillable Circles
        testFillable(viewer01, fillableCircles);

        // TODO : Create Circles of a Drawable Type with graphics object 2
        Drawable drawableCircles = new Circles(graphic02);

        // TODO : Use testDrawable to draw Open Drawable Circles
        testDrawable(viewer02, drawableCircles);

    }
}


















