package bbblast.model;

import java.util.Collection;
import java.util.Random;

import bbblast.utils.Position;
import bbblast.utils.PositionImpl;

/**
 * 
 * This class implements a Cannon.
 *
 */
public class CannonImpl implements Cannon {

    private int angle = 90;
    private final Position startingPosition;
    private final Collection<COLOR> colorsBubbles;
    private final Random randomGenerator;

    /**
     * @param colorsBubbles is a collection of COLOR, the cannon will only generate
     *                      bubbles of those colors.
     * @param p             the position at which bubbles will inially spawn.
     * 
     */
    public CannonImpl(final Collection<COLOR> colorsBubbles, final Position p) {
        this.colorsBubbles = colorsBubbles;
        this.startingPosition = new PositionImpl(p);
        this.randomGenerator = new Random();
    }

    /***
     * {@inheritDoc} The angle has to be between 5 and 175 degrees.
     */
    @Override
    public void move(final int angle) {
        if (angle >= 5 && angle <= 175) {
            this.angle = angle;
        }
    }

    /***
     * {@inheritDoc}
     */
    @Override
    public void shoot() {
        this.generateBubble();
        // TODO: Add angle
    }

    /***
     * {@inheritDoc}
     */
    @Override
    public void exchange() {
        // TODO Optional feature
    }

    /***
     * {@inheritDoc}
     */
    @Override
    public int getAngle() {
        return this.angle;
    }

    /***
     * This method generates the actual bubble.
     * 
     * @return the bubble generated
     */
    private Bubble generateBubble() {
        if (!colorsBubbles.isEmpty()) {
            final COLOR c = colorsBubbles.stream().skip(randomGenerator.nextInt(colorsBubbles.size())).findFirst()
                    .get();
            // TODO: Will this stream potentially skip all the colors?
            return new BubbleImpl(new PositionImpl(startingPosition), c);
        }
        return new BubbleImpl(new PositionImpl(startingPosition), COLOR.RED);
    }

}
