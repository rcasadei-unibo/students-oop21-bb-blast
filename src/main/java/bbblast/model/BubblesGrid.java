package bbblast.model;

import java.util.Collection;

import bbblast.utils.Position;

/**
 * 
 * The Interface which models a grid of Bubbles.
 *
 */
public interface BubblesGrid {

    /**
     * @return the collection of Bubbles inside the grid
     */
    Collection<Bubble> getBubbles();

    /**
     * @return the Y coordinate of the lowest row
     */
    double getLastRowY();

    /**
     * adds the Bubble, if it isn't already part of the BubblesGrid.
     * 
     * @param b the new Bubble
     */
    void addBubble(Bubble b);

    /**
     * removes the Bubble in the specified position.
     * 
     * @param p the position of the Bubble to remove
     */
    void removeBubble(Position p);

    /**
     * @param b the bubble to test if it can be attached to the grid.
     * @return true if bubble can be attached.
     */
    boolean isBubbleAttachable(Bubble b);

    /**
     * @param b the Bubble to search its neighbors.
     * @return the collection of same color neighbors as b.
     */
    Collection<Bubble> getSameColorNeighbors(Bubble b);

    /**
     * @param rows the number of rows down the bubbles are translated.
     */
    void moveBubblesDown(int rows);

}
