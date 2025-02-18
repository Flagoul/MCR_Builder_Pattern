package ch.heig.mcr.builder.gui.panels;

import ch.heig.mcr.builder.builder.BurgerBuilder;
import ch.heig.mcr.builder.exceptions.*;
import ch.heig.mcr.builder.gui.display.BurgerDisplay;
import ch.heig.mcr.builder.ingredient.*;

import javax.swing.*;
import java.awt.*;

/**
 * The panel in which the burger being built is displayed.
 * Contains all the methods directly used by the buttons of the BurgerPanel.
 *
 * @author Sébastien Boson, Benjamin Schubert, Mathieu Urstein, Basile Vu
 */
public class BurgerBuildPanel extends JPanel {

    private final BurgerBuilder builder;
    private final BurgerDisplay display;

    public BurgerBuildPanel() {
        setPreferredSize(new Dimension(600, 600));
        builder = new BurgerBuilder();
        display = new BurgerDisplay(this);
    }

    public void addBottomBread() {
        try {
            builder.buildBase();
        } catch (BaseAlreadyCreatedException e) {
            JOptionPane.showMessageDialog(this, "The bottom bread is already present.");
        }
        repaint();
    }

    public void addMiddleBread() {
        addIngredient(new MiddleBread());
    }

    public void addTopBread() {
        try {
            builder.buildTop();
        } catch (MissingBaseException e) {
            JOptionPane.showMessageDialog(this, "The bottom bread is missing.");
        } catch (TopAlreadyCreatedException e) {
            JOptionPane.showMessageDialog(this, "The top bread is already present.");
        }
        repaint();
    }

    public void addMeat() {
        addIngredient(new Meat());
    }

    public void addTomato() {
        addIngredient(new Tomato());
    }

    public void addSalad() {
        addIngredient(new Salad());
    }

    public void addOnion() {
        addIngredient(new Onion());
    }

    public void addPickle() {
        addIngredient(new Pickle());
    }

    public void addEgg() {
        addIngredient(new Egg());
    }

    public void addCheddar() {
        addIngredient(new Cheddar());
    }

    public void addGruyere() {
        addIngredient(new Gruyere());
    }

    public void addKetchup() {
        addIngredient(new Ketchup());
    }

    public void addMayo() {
        addIngredient(new Mayo());
    }

    public void bake() {
        builder.bake();
        repaint();
    }

    public void getProduct() {
        try {
            builder.getBurger();
            JOptionPane.showMessageDialog(this, "Burger ok!");
        } catch (MissingBaseException e) {
            JOptionPane.showMessageDialog(this, "The bottom bread is missing.");
        } catch (MissingTopException e) {
            JOptionPane.showMessageDialog(this, "The top bread is missing.");
        }
        repaint();
    }

    private void addIngredient(Ingredient i) {
        try {
            builder.addIngredient(i);
        } catch (MissingBaseException e) {
            JOptionPane.showMessageDialog(this, "The bottom bread is missing.");
        } catch (TopAlreadyPlacedException e) {
            JOptionPane.showMessageDialog(this, "Can't add ingredients anymore.");
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        display.reset();
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
