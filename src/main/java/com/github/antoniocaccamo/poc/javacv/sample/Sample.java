package com.github.antoniocaccamo.poc.javacv.sample;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.DoublePointer;

import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_face.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_face.*;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;

import picocli.CommandLine.Command;

/**
 * I couldn't find any tutorial on how to perform face recognition using OpenCV
 * and Java, so I decided to share a viable solution here. The solution is very
 * inefficient in its current form as the training model is built at each run,
 * however it shows what's needed to make it work.
 *
 * The class below takes two arguments: The path to the directory containing the
 * training faces and the path to the image you want to classify. Not that all
 * images has to be of the same size and that the faces already has to be
 * cropped out of their original images (Take a look here
 * http://fivedots.coe.psu.ac.th/~ad/jg/nui07/index.html if you haven't done the
 * face detection yet).
 *
 * For the simplicity of this post, the class also requires that the training
 * images have filename format: <label>-rest_of_filename.png. For example:
 *
 * 1-jon_doe_1.png 1-jon_doe_2.png 2-jane_doe_1.png 2-jane_doe_2.png ...and so
 * on.
 *
 * Source: http://pcbje.com/2012/12/doing-face-recognition-with-javacv/
 *
 * @author Petter Christian Bjelland
 */

@Command(name = "sample", mixinStandardHelpOptions = true

)
public class Sample implements Runnable {

    public void run() {
        System.out.println("Welcome to OpenCV " + Core.VERSION);
        Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));
        System.out.println("OpenCV Mat: " + m);
        Mat mr1 = m.row(1);
        mr1.setTo(new Scalar(1));
        Mat mc5 = m.col(5);
        mc5.setTo(new Scalar(5));
        System.out.println("OpenCV Mat data:\n" + m.dump());
    }
}