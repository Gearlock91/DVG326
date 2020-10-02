package ovn2.hoover;

import java.util.LinkedList;
import java.util.List;



public class Hoover {
	private Position currentPosition = new Position(0, 300);
	private List<Position> garbagePositions = new LinkedList();
	private int xMax; //The right boundary of the domain (i.e. the width of the area that the hoover will move in)
	private int xDelta = 10; //How much the hoover will move each time
	
	public Hoover() {
	}
	
	public Position getPosition() {
		return currentPosition;
	}
	
	//Moves hoover 10 'units' to the right
	public void moveHooverRight() {
		int currentXPos = currentPosition.getxPos();
		//If the hoover reaches the right boundary of the domain, make it appear to the very left (x=0) again
		if (currentXPos > (xMax-xDelta)) {
		currentPosition.setxPos(0);
		}
		else { //Otherwise move the hoover 10 'units' to the right
		currentPosition.setxPos(currentXPos+xDelta);
		}
		checkForHit();
	}
	
	//Moves hoover 10 'units' up
	public void moveHooverUp() {
		int currentYPos = currentPosition.getyPos();
		currentPosition.setyPos(currentYPos-xDelta);
		System.out.println("I moved up!");
	}
	
	//Moves hoover 10 'units' down
	public void moveHooverDown() {
		int currentYPos = currentPosition.getyPos();
		currentPosition.setyPos(currentYPos+xDelta);
		System.out.println("I moved down!");
	}
	
	public void addGarbagePosition(Position garbagePosition) {
		garbagePositions.add(garbagePosition);
	}
	
	public List<Position> getGarbagePositions() {
		return garbagePositions;
	}
	
	private void checkForHit(){
		
		for (Position garbagePosition : garbagePositions){
		
			if ((currentPosition.getxPos() == garbagePosition.getxPos()) &&
			 (currentPosition.getxPos() == garbagePosition.getxPos())) {
			System.out.println("HIT GARBAGE!!!");
			}
		}
	}
	
	public void setxMax(int xMax){
		this.xMax = xMax;
	}
}

