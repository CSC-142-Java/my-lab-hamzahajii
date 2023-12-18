 package labs;

        import java.awt.Color;
        import java.awt.Graphics;


public class Circles extends Shapes implements Fillable, Drawable{

    private final Color     color;
    private final Graphics  graphic;

    public Circles(Graphics _graphics){
        this.graphic = _graphics;
        this.color   = Color.LIGHT_GRAY;
    }


    public Circles(Graphics _graphics, int x, int y){
        super(x, y);
        this.graphic = _graphics;
        this.color   = Color.LIGHT_GRAY;
    }

    @Override
    public void draw(Color color) {
        graphic.setColor(color);
        for (int i = 1; i < 11; i++) {
            graphic.drawOval(x, y, 20 * i, 20 * i);
        }
        System.out.println();
    }


    @Override
    public void fill(Color color) {
        graphic.setColor(color);
        for (int i = 1; i < 7; i++) {
            graphic.fillOval(x * i, y * i, 10 * i, 10 * i);
        }
    }
}
