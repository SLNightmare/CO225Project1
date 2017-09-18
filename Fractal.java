/*
	author Hashan Kavinda
	E/14/181 ~ CO225 Project1	
*/

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;

class Fractal extends JPanel { 

    public static int width, height;
    public static int maxIterations;
    public static String zero;
    public static double xLeft,xRight,yUp,yDown;
    public static double jReal,jImg; 

    public Fractal(int width, int height) { 
        this.width  = width; 
        this.height = height; 
        setPreferredSize(new Dimension(width, height));
    }

    private static void printPoint(Graphics2D frame, Color c, Point p) {
        frame.setColor(c); 
        frame.draw(new Line2D.Double(p.getX(), p.getY(),p.getX(), p.getY())); 
    }

    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        Complex c = new Complex(0,0);
        int newM,newJ;
        
        if(zero.equals("Mandelbrot")){
            for(int i=0;i<800;i++) {
                for(int j=0;j<800;j++){
                    Point p = new Point(i, j);
                    int x = c.calPosition(p).checkMandelbrot();
                    newM = (int)x*1000/maxIterations;
                    if(newM == 1000){
                        printPoint((Graphics2D)g, Color.BLACK, new Point(i,j));
                    }else if(x<5){
                        printPoint((Graphics2D)g, Color.getHSBColor(newM*3.1428f,newM/2.2367f*100,newM),new Point(i,j));
                    }else if(x<10){
                        printPoint((Graphics2D)g, Color.getHSBColor(x/2.2367f*100,x,x*3.1428f),new Point(i,j));
                    }else if(x<15){
                        printPoint((Graphics2D)g, Color.getHSBColor(x,x*3.1428f,x/2.2367f*100),new Point(i,j));
                    }else if(x<25){
                        printPoint((Graphics2D)g, Color.getHSBColor(x*3.1428f,x/2.2367f*100,x),new Point(i,j));
                    }else if(x<50){
                        printPoint((Graphics2D)g, Color.getHSBColor(x/2.2367f*100,x,x*3.1428f),new Point(i,j));
                    }else if(x<75){
                        printPoint((Graphics2D)g, Color.getHSBColor(x*3.1428f,x/2.2367f*100,x),new Point(i,j));
                    }else if(x<100){
                        printPoint((Graphics2D)g, Color.getHSBColor(x,x*3.1428f,x/2.2367f*100),new Point(i,j));
                    }else if(x<150){
                        printPoint((Graphics2D)g, Color.getHSBColor(x/2.2367f*100,x,x*3.1428f),new Point(i,j));
                    }else if(x<250){
                        printPoint((Graphics2D)g, Color.getHSBColor(x,x*3.1428f,x/2.2367f*100),new Point(i,j));
                    }else if(x<400){
                        printPoint((Graphics2D)g, Color.getHSBColor(x*3.1428f,x/2.2367f*100,x),new Point(i,j));
                    }else if(x<700){
                        printPoint((Graphics2D)g, Color.getHSBColor(x/2.2367f*100,x,x*3.1428f),new Point(i,j));
                    }else if(x<1000){
                        printPoint((Graphics2D)g, Color.getHSBColor(x*3.1428f,x/2.2367f*100,x),new Point(i,j));
                    }                      
                }    
            } 
        }else if(zero.equals("Julia")){    
            for(int i=0;i<800;i++) {
                for(int j=0;j<800;j++){
                    Point p = new Point(i, j);
                    int x = c.calPosition(p).checkJulia(new Complex(jReal,jImg));
//                    newJ = (int)x*maxIterations/1000;
                    
                    if(x<5){                        
                        printPoint((Graphics2D)g, Color.getHSBColor(x*3.1428f,x/2.2367f*100,x),new Point(i,j));
                    }else if(x<10){
                        printPoint((Graphics2D)g, Color.getHSBColor(x/2.2367f*100,x,x*3.1428f),new Point(i,j));
                    }else if(x<15){
                        printPoint((Graphics2D)g, Color.getHSBColor(x,x*3.1428f,x/2.2367f*100),new Point(i,j));
                    }else if(x<25){
                        printPoint((Graphics2D)g, Color.getHSBColor(x*3.1428f,x/2.2367f*100,x),new Point(i,j));
                    }else if(x<50){
                        printPoint((Graphics2D)g, Color.getHSBColor(x/2.2367f*100,x,x*3.1428f),new Point(i,j));
                    }else if(x<75){
                        printPoint((Graphics2D)g, Color.getHSBColor(x*3.1428f,x/2.2367f*100,x),new Point(i,j));
                    }else if(x<100){
                        printPoint((Graphics2D)g, Color.getHSBColor(x,x*3.1428f,x/2.2367f*100),new Point(i,j));
                    }else if(x<150){
                        printPoint((Graphics2D)g, Color.getHSBColor(x/2.2367f*100,x,x*3.1428f),new Point(i,j));
                    }else if(x<250){
                        printPoint((Graphics2D)g, Color.getHSBColor(x,x*3.1428f,x/2.2367f*100),new Point(i,j));
                    }else if(x<400){
                        printPoint((Graphics2D)g, Color.getHSBColor(x*3.1428f,x/2.2367f*100,x),new Point(i,j));
                    }else if(x<700){
                        printPoint((Graphics2D)g, Color.getHSBColor(x/2.2367f*100,x,x*3.1428f),new Point(i,j));
                    }else if(x<1000){
                        printPoint((Graphics2D)g, Color.getHSBColor(x*3.1428f,x/2.2367f*100,x),new Point(i,j));
                    }
                }    
            } 
        }
    }
    
    public static void main(String [] args) {
        
        zero = args[0];
                
        if(args[0].equals("Mandelbrot")){
            if(args.length == 1){
                xLeft = -1;
                xRight = 1;
                yUp = 1;
                yDown = -1;
                maxIterations = 1000;
            }else if(args.length == 5){
                xLeft = Double.parseDouble(args[1]);
                xRight = Double.parseDouble(args[2]);
                yUp = Double.parseDouble(args[3]);
                yDown = Double.parseDouble(args[4]);
                maxIterations = 1000;
            }else if(args.length == 6){
                xLeft = Double.parseDouble(args[1]);
                xRight = Double.parseDouble(args[2]);
                yUp = Double.parseDouble(args[3]);
                yDown = Double.parseDouble(args[4]);
                maxIterations = Integer.parseInt(args[5]);
            }
        }
        if(args[0].equals("Julia")){
            if(args.length == 1){
                xLeft = -1;
                xRight = 1;
                yUp = 1;
                yDown = -1;
                maxIterations = 1000;
                jReal = -0.4;
                jImg = 0.6;
            }else if(args.length == 4){
                xLeft = -1;
                xRight = 1;
                yUp = 1;
                yDown = -1;
                maxIterations = Integer.parseInt(args[3]);
                jReal = Double.parseDouble(args[1]);
                jImg = Double.parseDouble(args[2]);;
            }
        }
        
        JFrame frame = new JFrame(zero + " set"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        frame.setContentPane(new Fractal(800, 800)); 

        frame.pack(); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true); 
    }
    
}