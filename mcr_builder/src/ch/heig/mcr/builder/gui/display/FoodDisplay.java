package ch.heig.mcr.builder.gui.display;

import ch.heig.mcr.builder.ingredient.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

/**
 * Allows ingredients displaying. The classes extending this class can choose which element the can display and how.
 *
 * @author Sébastien Boson, Benjamin Schubert, Mathieu Urstein, Basile Vu
 */
public abstract class FoodDisplay {

    protected final JPanel panel;
    protected Graphics graphics;
    protected RescaleOp op;
    protected BufferedImage tempImg;

    public FoodDisplay(JPanel panel) {
        this.panel = panel;
        float[] scales = {0f, 0f, 0f, 1f};
        float[] offsets = new float[4];
        op = new RescaleOp(scales, offsets, null);
    }

    /**
     * Sets the graphics used for the display. Must be called EVERYTIME before drawing an ingredient (before the
     * ingredient.accept(the food display).
     * @param graphics The graphics used to draw the ingredient images.
     */
    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    /**
     * Loads all the images required to display ingredients used by the builder.
     */
    protected abstract void loadImages();

    /**
     * Loads an image, given its path.
     * @param path The path to the image.
     * @return The loaded image.
     */
    protected BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println(path + " could not be loaded");
        }
        return null;
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param dough The ingredient to display.
     */
    public void visit(Dough dough) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param bottomBread The ingredient to display.
     */
    public void visit(BottomBread bottomBread) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param middleBread The ingredient to display.
     */
    public void visit(MiddleBread middleBread) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param topBread The ingredient to display.
     */
    public void visit(TopBread topBread) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param meat The ingredient to display.
     */
    public void visit(Meat meat) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param salad The ingredient to display.
     */
    public void visit(Salad salad) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param onion The ingredient to display.
     */
    public void visit(Onion onion){
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param pickle The ingredient to display.
     */
    public void visit(Pickle pickle) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param cheddar The ingredient to display.
     */
    public void visit(Cheddar cheddar) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param egg The ingredient to display.
     */
    public void visit(Egg egg) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param gruyere The ingredient to display.
     */
    public void visit(Gruyere gruyere) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param tomato The ingredient to display.
     */
    public void visit(Tomato tomato) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param ketchup The ingredient to display.
     */
    public void visit(Ketchup ketchup) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param mayo The ingredient to display.
     */
    public void visit(Mayo mayo) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param mozzarella The ingredient to display.
     */
    public void visit(Mozzarella mozzarella) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param basil The ingredient to display.
     */
    public void visit(Basil basil) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param tomatoSauce The ingredient to display.
     */
    public void visit(TomatoSauce tomatoSauce) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param olives The ingredient to display.
     */
    public void visit(Olive olives) {
        throw new NotImplementedException();
    }

    /**
     * Defines what will the display will do with the ingredient (how to display it).
     * @param mushrooms The ingredient to display.
     */
    public void visit(Mushroom mushrooms) {
        throw new NotImplementedException();
    }
}
