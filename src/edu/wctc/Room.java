package edu.wctc;

import java.util.ArrayList;

public class Room implements paintable {

    private static int roomCount;
    private int roomNum;

    private ArrayList<Wall> wallList;

    public Room(double length, double width, double height) throws BadWidthException, BadHeightException {
        wallList = new ArrayList<Wall>();

        Wall wallA = new Wall(length, height);
        wallList.add(wallA);
        Wall wallB = new Wall(length, height);
        wallList.add(wallB);
        Wall wallC = new Wall(width, height);
        wallList.add(wallC);
        Wall wallD = new Wall(width, height);
        wallList.add(wallD);
    }

    public double getArea() {
        double area = 0;

        for (int i = 0; i < wallList.size(); i++) {
            Wall w = wallList.get(i);
            area += w.getArea();
        }

        return area;
    }

    public Room(int roomNum) {
        this.roomNum = roomNum;
        roomCount++;
    }

    @Override
    public String toString() {
        return "This is the number of rooms " + roomNum + "." + "and the total area =" + getArea() ;
    }

    @Override
    public double getPremiumCost() {
        double CostOfPaint = getArea()*paintable.PREMIUM_PAINT_COST_PER_GALLON;
        return CostOfPaint;
    }

    @Override
    public double getStandardCost() {
        double CostOfPaintStandard = getArea()*paintable.STANDARD_PAINT_COST_PER_GALLON;
        return CostOfPaintStandard;
    }
}
