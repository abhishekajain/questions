package com.abhi.example;

public class RectangleUtil {
	
	public static class Rectangle {

	    // "zero" rectangle
	    public static final Rectangle NO_RECTANGLE = new Rectangle();

	    // coordinates of bottom left corner
	    private int leftX;
	    private int bottomY;

	    // dimensions
	    private int width;
	    private int height;

	    public Rectangle() {}

	    public Rectangle(int leftX, int bottomY, int width, int height) {
	        this.leftX = leftX;
	        this.bottomY = bottomY;
	        this.width  = width;
	        this.height = height;
	    }

	    public int getLeftX() {
	        return leftX;
	    }

	    public int getBottomY() {
	        return bottomY;
	    }

	    public int getWidth() {
	        return width;
	    }

	    public int getHeight() {
	        return height;
	    }
	}
	
	static Rectangle commonRectangle(Rectangle rect1, Rectangle rect2){
		
		return Rectangle.NO_RECTANGLE;
	}
	
	public static class Line{
		
		int m;
		int b;
		
		Line(int x1, int y1, int x2, int y2){
			this.m = (y2-y1)/(x2-x1);
			this.b = y1-(this.m*x1);
		}
		//y1=m1x1+b1 y2=m2x2+b2
		public static int[] intersection(Line l1, Line l2){
			int x = (l2.b-l1.b)/(l1.m-l2.m);
			int y = l1.m*x+l1.b;
			int[] result = {x,y};
			return result;
		}
	}

}
