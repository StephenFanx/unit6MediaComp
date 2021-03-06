import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  

    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void cropAndCopy(Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol,
     int endSourceCol, int startDestRow, int startDestCol)
    {
        // put your code here
        Pixel[][] sourcepixels = sourcePicture.getPixels2D();
        Pixel[][] destpixels = this.getPixels2D();
        
        int destrow = startDestRow;
        int destcol = startDestCol;
        
        for (int row = startSourceRow; row <= endSourceRow; row++)
        {
            for (int col = startSourceCol; col <= endSourceCol; col++)
            {
                destpixels[destrow][destcol].setColor(sourcepixels[row][col].getColor());
                destcol++;
            }
            
            destcol = 0;
            destrow++;
        }
    }

    /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set the green and red to 0 and keeps the blue the same*/
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }
  
  /** Method to negate all the pixels in a picture*/
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(255 - pixelObj.getGreen());
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }
  }
  
    /** Method to change the colors of the picture into shades of gray*/
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int average = (pixelObj.getGreen() + pixelObj.getBlue() + pixelObj.getRed())/3;
        
        pixelObj.setGreen(average);
        pixelObj.setRed(average);
        pixelObj.setBlue(average);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    
    System.out.println(count);
  }
  
    /** Method that mirrors the arms of a snowman
    * so that it has 4 arms*/
  public void mirrorArms()
    {
        // put your code here
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel1 = null;
        Pixel bottomPixel1 = null;
        Pixel topPixel2 = null;
        Pixel bottomPixel2 = null;
        int height = pixels.length;
        int width = pixels[0].length;
        
        for (int row = 160; row < 220; row++)
        {
            for (int col = 20; col < 170; col++)
            {
                topPixel1 = pixels[row][col];
                bottomPixel1 = pixels[(height - 160)/2 + row][col];
                bottomPixel1.setColor(topPixel1.getColor());
                
                topPixel2 = pixels[row][col + 220];
                bottomPixel2 = pixels[(height - 160)/2 + row][col + 220];
                bottomPixel2.setColor(topPixel2.getColor());
            }
        }
    }
  
        /** Method that mirrors a seagull on a picture so that there are 2*/
  public void mirrorGull()
    {
        // put your code here
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for (int row = 235; row < 320; row++)
        {
            for (int col = 235; col < 340; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 100];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
      Picture astronaut = new Picture("Astronaut-in-India.jpg");
      Picture astronaut2 = new Picture("Astronaut-in-India.jpg");
      
      this.copy(astronaut,0,0);
      astronaut.mirrorVertical();
      this.copy(astronaut,0,550);
      astronaut.keepOnlyBlue();
      this.copy(astronaut,365,0);
      astronaut2.zeroBlue();
      astronaut2.mirrorHorizontal();
      this.copy(astronaut2,365,550);
      this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  

    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void mirrorVerticalRightToLeft()
    {
        // put your code here
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width-1-col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }
  
    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void mirrorHorizontal()
    {
        // put your code here
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height-1-row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *  that describes the operation of the method
     *
     * @pre     preconditions for the method
     *          (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *          (what the method guarantees upon completion)
     * @param   y   description of parameter y
     * @return  description of the return value
     */
    public void mirrorHorizontalBotToTop()
    {
        // put your code here
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height-1-row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }

    
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
