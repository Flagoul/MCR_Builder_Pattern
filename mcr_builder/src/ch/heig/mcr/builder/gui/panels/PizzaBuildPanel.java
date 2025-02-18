package ch.heig.mcr.builder.gui.panels;

import ch.heig.mcr.builder.builder.PizzaBuilder;
import ch.heig.mcr.builder.exceptions.BaseAlreadyCreatedException;
import ch.heig.mcr.builder.exceptions.MissingBaseException;
import ch.heig.mcr.builder.gui.display.PizzaDisplay;
import ch.heig.mcr.builder.ingredient.*;

import javax.swing.*;
import java.awt.*;

/**
 * The panel in which the pizza being built is displayed.
 * Contains all the methods directly used by the buttons of the PizzaPanel.
 *
 * @author Sébastien Boson, Benjamin Schubert, Mathieu Urstein, Basile Vu
 */
public class PizzaBuildPanel extends JPanel {

    private final PizzaBuilder builder = new PizzaBuilder();
    private final PizzaDisplay display;

    public PizzaBuildPanel() {
        setPreferredSize(new Dimension(600, 600));
        display = new PizzaDisplay(this);
    }

    public void buildBase() {
        try {
            builder.buildBase();
        } catch (BaseAlreadyCreatedException e) {
            JOptionPane.showMessageDialog(this, "The dough is already present.");
        }
        repaint();
    }

    public void addTomato() {
        addIngredient(new TomatoSauce());
    }

    public void addBasil() {
        addIngredient(new Basil());
    }

    public void addOlives() {
        addIngredient(new Olive());
    }

    public void addMozzarella() {
        addIngredient(new Mozzarella());
    }

    public void addMushrooms() {
        addIngredient(new Mushroom());
    }

    public void addOnion() {
        addIngredient(new Onion());
    }

    public void bake() {
        builder.bake();
        repaint();
    }

    public void getProduct() {
        try {
            builder.getPizza();
            JOptionPane.showMessageDialog(this, "Pizza ok!");
        } catch (MissingBaseException e) {
            JOptionPane.showMessageDialog(this, "The dough is missing.");
        }
        repaint();
    }

    private void addIngredient(Ingredient i) {
        try {
            builder.addIngredient(i);
        } catch (MissingBaseException e) {
            JOptionPane.showMessageDialog(this, "The dough is missing.");
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        display.setGraphics(g);

        for (Ingredient i : builder.getProgress().getIngredients()) {
            i.accept(display);
        }
    }

    public void reinitialize() {
        builder.reset();
        repaint();
    }
}
