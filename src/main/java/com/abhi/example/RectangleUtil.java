package com.abhi.example;

import org.junit.Test;

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

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "X"+this.leftX+"Y"+this.bottomY+"W"+this.width+"H"+this.height;
		}	    
	}
	/**
	 * left = max(r1.left, r2.left)
	 * bottom = max(r1.bottom, r2.bottom)
	 * 
	 * right = min(r1.right, r2.right)
	 * top = min(r1.top, r2.top)

	 */
	static Rectangle commonRectangleAlgo(Rectangle rect1, Rectangle rect2){
		int leftX = Math.max(rect1.leftX, rect2.leftX);
		int bottomY = Math.max(rect1.bottomY, rect2.bottomY);
		
		int rightX = Math.min(rect1.leftX+rect1.width, rect2.leftX+rect2.width);
		int topY = Math.min(rect1.bottomY+rect1.height, rect2.bottomY+rect2.height);
		
		if (leftX < rightX && bottomY < topY) {
			return new Rectangle(leftX, bottomY, rightX-leftX, topY-bottomY);
		}
		return Rectangle.NO_RECTANGLE;
	}
	
	static Rectangle commonRectangle(Rectangle rect1, Rectangle rect2){
		//find which one is in the left
		if(rect1.leftX<=rect2.leftX){//rect1 in the left
			return commonRectangleSorted(rect1, rect2);
		}else{//rect2 in the left
			return commonRectangleSorted(rect2, rect1);
		}		
	}
	
	static Rectangle commonRectangleSorted(Rectangle rect1, Rectangle rect2){
		int x = Integer.MIN_VALUE;
		int y = Integer.MIN_VALUE;
		int width = Integer.MIN_VALUE;
		int height = Integer.MIN_VALUE;
		if(rect1.bottomY<=rect2.bottomY){ 
			x = rect2.leftX;
			y = rect2.bottomY;
			if((rect2.leftX+rect2.width)<(rect1.leftX+rect1.width) && (rect2.bottomY+rect2.height)<(rect1.bottomY+rect1.height)){
				width = rect2.width;
				height = rect2.height;
			}else if((rect2.leftX+rect2.width)<(rect1.leftX+rect1.width)){
				width = rect2.width;
				height = rect1.bottomY+rect1.height-rect2.bottomY;
			}else if((rect2.bottomY+rect2.height)<(rect1.bottomY+rect1.height)){
				width = rect1.leftX+rect1.width-rect2.leftX;
				height = rect2.height;
			}else{
				width = rect1.leftX+rect1.width-rect2.leftX;
				height = rect1.bottomY+rect1.height-rect2.bottomY;
			}
		}else{
			x = rect2.leftX;
			y = rect1.bottomY;
			if((rect2.leftX+rect2.width)>(rect1.leftX+rect1.width) && (rect2.bottomY+rect2.height)>(rect1.bottomY+rect1.height)){
				width = rect1.leftX+rect1.width-rect2.leftX;
				height = rect1.bottomY+rect1.height-rect1.bottomY;
			}else if((rect2.leftX+rect2.width)>(rect1.leftX+rect1.width)){
				width = rect1.leftX+rect1.width-rect2.leftX;
				height = rect2.bottomY+rect2.height-rect1.bottomY;
			} else if((rect2.bottomY+rect2.height)>(rect1.bottomY+rect1.height)){
				width = rect2.leftX+rect2.width-rect2.leftX;
				height = rect1.height;
			}else{
				width = rect2.width;
				height = rect2.bottomY+rect2.height-rect1.bottomY;
			}
		}
		
		if(height>0 &&  width>0){
			return new Rectangle(x, y, width, height);
		}
		
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
	
	@Test
	public void testCommonRectangle(){
		Rectangle rect1 = new Rectangle(0, 0, 3, 3);
		Rectangle rect2 = new Rectangle(1, -1, 5, 3);
		Rectangle rect = commonRectangle(rect1, rect2);
		System.out.println(rect);
	}
	
	@Test
	public void testCommonRectangleAlgo(){
		Rectangle rect1 = new Rectangle(0, 0, 3, 3);
		Rectangle rect2 = new Rectangle(1, -1, 5, 3);
		Rectangle rect = commonRectangleAlgo(rect1, rect2);
		System.out.println(rect);
	}

}
