public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal()
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0;
    for (int[] rowArray : matrix)
    {
      for (int item : rowArray)
      {
        total = total + item;
      }
    }
    return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
  
  /**
  * An example of a method - replace this comment with your own   *  that describes the operation of the method
  *
  * @pre     preconditions for the method
  *          (what the method assumes about the method's parameters and class's state)
  * @post    postconditions for the method
  *          (what the method guarantees upon completion)
  * @param   y   description of parameter y
  * @return  description of the return value
  */
  public int getCount(int number)
    {
        // put your code here
        int total = 0;
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[0].length; col++)
            {
                if (matrix[row][col] == number)
                {
                    total += 1;
                }
            }
        }
        
        return total;
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
  public int getLargest()
    {
        // put your code here
        int largest = 0;
        
        for (int row = 0; row < matrix.length; row++)
        {
            for (int col = 0; col < matrix[0].length; col++)
            {
                if (matrix[row][col] > largest)
                {
                    largest = matrix[row][col];
                }
            }
        }
        
        return largest;
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
    public int getColTotal(int column)
    {
        // put your code here
        int total = 0;
        
        for (int i = 0; i < matrix[0].length; i++)
        {
            total += matrix[i][column];
        }
        
        return total;
    }

}