package com.abhi.opencv;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

/**
 * Add opencv native lib path (path of libopencv_java2413.so)before running this main
 * vm args e.g. -Djava.library.path=$OPENCV_HOME/lib
 * @author abhishekajain
 *
 */
public class Dimensions {
	
	@SuppressWarnings("unused")
	private static long[] midpoint(long[] pointA, long[] pointB){
		long a = (pointA[0] + pointB[0]) /2;
		long b = (pointA[1] + pointB[1]) /2;

		long[] midPoint = {a, b};
		return midPoint;
	}
	
	public static void main(String[] args){
		System.out.println("Welcome to OpenCV " + Core.VERSION);
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m = Mat.eye(3, 3, CvType.CV_8UC1);
		System.out.println("m = " + m.dump());
//		load the image, convert it to grayscale, and blur it slightly
		String imageFile = "/home/isengard/Downloads/size-of-objects/images/example_01.png";
		Mat image = Highgui.imread(imageFile);
		Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2GRAY);
		Imgproc.GaussianBlur(image, image, new Size(7, 7), 0);
		
//		# perform edge detection, then perform a dilation + erosion to
//		# close gaps in between object edges
		Imgproc.Canny(image, image, 50, 100);
		Imgproc.dilate(image, image, new Mat());
		Imgproc.erode(image, image, new Mat());
		
//		# find contours in the edge map
		List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
		Imgproc.findContours(image.clone(), contours, new Mat(), Imgproc.RETR_EXTERNAL,
				Imgproc.CHAIN_APPROX_SIMPLE);
		List<Rect> list = new ArrayList<Rect>();
		for(MatOfPoint contour: contours){
			list.add(Imgproc.boundingRect(contour));
		}
		
		Stream<Rect>  stream = list.stream().sorted((e1, e2) -> Integer.compare(e1.x,e2.x));
			
		stream.forEach(rect -> {
			System.out.println("X axis "+rect.x);
			if(rect == null || rect.area()< 100){
				System.out.println("small image");
			}else{
				
				try{
					Mat orig = image.clone();
					System.out.println(rect.area());
					Point tlPoint = rect.tl();
					Point brPoint = rect.br();
					
					Point trPoint = Dimensions.tr(rect);
					Point blPoint = Dimensions.bl(rect);
					
					Core.line(orig, tlPoint, blPoint, new Scalar(255), 2);
					Core.putText(orig, ""+euclidean(tlPoint, blPoint), tlPoint, Core.FONT_ITALIC, 2, new Scalar(255, 255, 255));
					
					Core.line(orig, blPoint, brPoint, new Scalar(255), 2);
					Core.putText(orig, ""+euclidean(blPoint, brPoint), blPoint, Core.FONT_ITALIC, 2, new Scalar(255, 255, 255));
	
					Core.line(orig, brPoint, trPoint, new Scalar(255), 2);
					//Core.putText(orig, ""+euclidean(brPoint, trPoint), brPoint, Core.FONT_ITALIC, 2, new Scalar(255, 255, 255));
	
					Core.line(orig, trPoint, tlPoint, new Scalar(255), 2);
					//Core.putText(orig, ""+euclidean(trPoint, tlPoint), trPoint, Core.FONT_ITALIC, 2, new Scalar(255, 255, 255));
	
					Highgui.imwrite(imageFile+rect.x+".jpg", orig);
					
				}catch(Exception e){
					System.err.println(e);
				}				
				
			}
		});
	
	}
	
	

    private static Point tr(Rect rect) {
        return new Point(rect.x + rect.width, rect.y);
    }

    private static Point bl(Rect rect) {
        return new Point(rect.x , rect.y + rect.height);
    }

    private static double euclidean(Point p1, Point p2){

    	double  xDiff = p1.x-p2.x;
            double  xSqr  = Math.pow(xDiff, 2);

    	double yDiff = p1.y-p2.y;
    	double ySqr = Math.pow(yDiff, 2);

    	double output   = Math.sqrt(xSqr + ySqr);
    	
    	System.out.println("Distance = " + output);  
    	return output;
    }
}
