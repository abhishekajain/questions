package com.abhi.opencv;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 * Add opencv native lib path (path of libopencv_java2413.so)before running this main
 * vm args e.g. -Djava.library.path=$OPENCV_HOME/lib
 * @author abhishekajain
 *
 */
public class HelloCv {
	
	public static void main(String[] args) {
		System.out.println("Welcome to OpenCV " + Core.VERSION);
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m = Mat.eye(3, 3, CvType.CV_8UC1);
		System.out.println("m = " + m.dump());
	}
}
