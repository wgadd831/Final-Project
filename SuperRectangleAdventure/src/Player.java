

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

import processing.core.PImage;

/**
 * The Player controlled by the user
*/
public class Player extends MovingImage {

	
	private static final long serialVersionUID = 1L;
	public static final int PLAYER_WIDTH = 17;
	public static final int PLAYER_HEIGHT = 30;

	private double xVelocity, yVelocity;
	private boolean onASurface;
	private boolean leftSideOnWall;
	private boolean rightSideOnWall;
	private boolean canUncrouch;
	private double friction;
	private double gravity;
	private double jumpStrength;
	private double wallJumpStrengthUp;
	private double wallJumpStrengthSideways;

	/**
	 *  Creates an instance of the Player object 
	 *  @param x the x-coordinate of Player
	* 	@param y the y-coordinate of the Player
	*/
	public Player(PImage img, int x, int y) {
		super(img, x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
		xVelocity = 0;
		yVelocity = 0;
		onASurface = false;
		leftSideOnWall = false;
		rightSideOnWall = false;
		canUncrouch = true;
		gravity = .6;
		friction = .8;
		jumpStrength = 8;
		wallJumpStrengthUp = -12.5;
		wallJumpStrengthSideways = 15;
	}

	// METHODS
	public void walk(int dir) {
		if (xVelocity <= 10 && xVelocity >= -10)
			xVelocity += 2*dir;
	}

	/**
	 *Allows the player to jump if they are not touching a wall 
	 *and touching the floor
	 */
	public void jump() {
		if (onASurface && !(leftSideOnWall || rightSideOnWall))
			yVelocity -= jumpStrength;
	}
	
	/**
	 *Allows the player to wall jump if they are touching a wall 
	 */
	public void wallJump() {
		if(leftSideOnWall)
		{
			yVelocity = wallJumpStrengthUp;
			xVelocity = wallJumpStrengthSideways;
		}
	
		if(rightSideOnWall)
		{
			yVelocity = wallJumpStrengthUp;
			xVelocity = -wallJumpStrengthSideways;
		}
	}
	
	public double getPlayerWidth() {
		return PLAYER_WIDTH;
	}
	
	/**
	 *makes player crouch
	 */
	public void crouch() {
		super.height = PLAYER_HEIGHT/2;
		friction = .6;
	}
	
	/**
	 *makes player uncrouch
	 */
	public void uncrouch() {
		if(canUncrouch)
		{
			super.height = PLAYER_HEIGHT;
			friction = .8;
		}
		
	}
	
	
	/**
	 *All of the things the player does w/ out user input
	 */
	public void act(ArrayList<Shape> obstacles) {
		double xCoord = getX();
		double yCoord = getY();
		double width = getWidth();
		double height = getHeight();
		double yCoordStanding = getY() - 30;
		// ***********Y AXIS***********

		yVelocity += gravity; // GRAVITY
		double yCoord2 = yCoord + yVelocity;
		double yCoord2Standing = yCoordStanding + yVelocity;

		Rectangle2D.Double strechY = new Rectangle2D.Double(xCoord,Math.min(yCoord,yCoord2),width,height+Math.abs(yVelocity));
		Rectangle2D.Double strechYStanding = new Rectangle2D.Double(xCoord,Math.min(yCoordStanding,yCoord2Standing),width,PLAYER_HEIGHT+Math.abs(yVelocity));

		onASurface = false;
		canUncrouch = true;

		for (Shape s : obstacles) {
			
			if (s.intersects(strechYStanding)) {
				canUncrouch = false;
			}
		}
		
		if (yVelocity > 0) {
			Shape standingSurface = null;
			for (Shape s : obstacles) {
				if (s.intersects(strechY)) {
					onASurface = true;
					standingSurface = s;
					yVelocity = 0;
				}
			}
			if (standingSurface != null) {
				Rectangle r = standingSurface.getBounds();
				yCoord2 = r.getY()-height;
			}
		} 
		
		else if (yVelocity < 0) {
			Shape headSurface = null;
			for (Shape s : obstacles) {
				if (s.intersects(strechY)) {
					headSurface = s;
					yVelocity = 0;
				}
			}
			if (headSurface != null) {
				Rectangle r = headSurface.getBounds();
				yCoord2 = r.getY()+r.getHeight();
			}
		}

		if (Math.abs(yVelocity) < .5)
			yVelocity = 0;

		// ***********X AXIS***********


		xVelocity *= friction;

		double xCoord2 = xCoord + xVelocity;

		Rectangle2D.Double strechX = new Rectangle2D.Double(Math.min(xCoord,xCoord2),yCoord2,width+Math.abs(xVelocity),height);
		
		leftSideOnWall = false;
		rightSideOnWall = false;

		if (xVelocity > 0) {
			Shape rightSurface = null;
			for (Shape s : obstacles) {
				if (s.intersects(strechX)) {
					rightSideOnWall = true;
					rightSurface = s;
					xVelocity = 0;
				}
			}
			if (rightSurface != null) {
				Rectangle r = rightSurface.getBounds();
				xCoord2 = r.getX()-width;
			}
		} else if (xVelocity < 0) {
			Shape leftSurface = null;
			for (Shape s : obstacles) {
				if (s.intersects(strechX)) {
					leftSideOnWall = true;
					leftSurface = s;
					xVelocity = 0;
				}
			}
			if (leftSurface != null) {
				Rectangle r = leftSurface.getBounds();
				xCoord2 = r.getX()+r.getWidth();
			}
		}


		if (Math.abs(xVelocity) < .5)
			xVelocity = 0;

		moveToLocation(xCoord2,yCoord2);

	}


}


