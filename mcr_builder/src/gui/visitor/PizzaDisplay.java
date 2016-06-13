package gui.visitor;

import ingredient.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Basile Vu on 13.06.2016.
 */
public class PizzaDisplay implements FoodDisplay {

    private final JPanel panel;
    private Graphics graphics;

    private BufferedImage doughImg;
    private BufferedImage onionImg;
    private BufferedImage mozzarellaImg;
    private BufferedImage tomatoSauceImg;
    private BufferedImage olivesImg;
    private BufferedImage mushroomsImg;
    private BufferedImage basilImg;

    public static String IMG_FOLDER = "design/pizza/exports/images/";

    public PizzaDisplay(JPanel panel) {
        this.panel = panel;
    }

    private void loadImages() {
        doughImg = loadImage("bread_top_sesame.png");
        onionImg = loadImage("onion.png");
        mozzarellaImg = loadImage("mozzarella.png");
        tomatoSauceImg = loadImage("tomato_sauce.png");
        olivesImg = loadImage("olives.png");
        mushroomsImg = loadImage("mushrooms.png");
        basilImg = loadImage("basil.png");
    }

    private BufferedImage loadImage(String name) {
        try {
            return ImageIO.read(new File(IMG_FOLDER + name));
        } catch (IOException e) {
            System.err.println(name + " could not be loaded");
        }
        return null;
    }

    @Override
    public void visit(Dough dough) {
        drawImage(doughImg, 1);
    }

    @Override
    public void visit(Onion onion) {
        drawImage(onionImg, 0.9);
    }

    @Override
    public void visit(Mozzarella mozzarella) {
        drawImage(mozzarellaImg, 0.9);
    }

    @Override
    public void visit(TomatoSauce tomatoSauce) {
        drawImage(tomatoSauceImg, 0.9);
    }

    @Override
    public void visit(Olives olives) {
        drawImage(olivesImg, 0.9);
    }

    @Override
    public void visit(Mushrooms mushrooms) {
        drawImage(mushroomsImg, 0.9);
    }

    @Override
    public void visit(Basil basil) {
        drawImage(basilImg, 0.9);
    }

    private void drawImage(BufferedImage image, double scaleRatio) {
        Image rescaled = image.getScaledInstance(
                (int) (0.75 * panel.getWidth() * scaleRatio),
                (int) (0.3 * panel.getHeight() * scaleRatio),
                Image.SCALE_DEFAULT);
        graphics.drawImage(rescaled, (int) (0.125 * panel.getWidth()), (int)(0.6 * panel.getHeight()), null);
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
