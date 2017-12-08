package com.calebpower.demo.sjd;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Core {

  public static void main(String[] args) {
    
    /*
     * Important Note:
     * 
     * This main method is of course static. When obtaining the resource
     * resource stream from within an instance (non-static) method, you
     * would instead need to retrieve the input stream by calling
     * `getClass().getResourceAsStream("/resources/context.txt")`.
     * 
     */
    System.out.println();
    printBar("Printing From Resource");
    try {
      InputStream stream = Core.class.getResourceAsStream("/content.txt");
      Scanner scanner = new Scanner(new BufferedInputStream(stream));
      
      //This is also an example of displaying output directly from the file stream.
      while(scanner.hasNext()) System.out.println(scanner.nextLine());
      scanner.close(); //always close your streams
      
    } catch(Exception e) {
      System.out.println("Something terrible happen when trying to read from the\n"
                       + "resource. When done panicking, please let Caleb know.");
    }
    printBar(null);
    
    if(args.length == 1) {
      printBar("Reading From File");
      try {
        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);
        
        /*
         * This is an example of loading everything into memory first. This is
         * good when reading files from the command-line, because it's bad
         * practice to rely on an external configuration file more than necessary.
         */
        String rawData = new String();
        while(scanner.hasNext()) rawData += scanner.nextLine();
        scanner.close(); //always close your streams
        System.out.println(rawData);
        
      } catch(Exception e) {
        System.out.println("That file could not be read. Make sure it's readable!");
      }
      printBar(null);
    } else {
      System.out.println("If you would like to read from an external file,\n"
                       + "make sure that you specify the filename in \"quotes\"\n"
                       + "as the first argument when entering the program.\n");
    }
    
    System.out.println("Don't forget to check out the pom.xml file in the source\n"
                     + "code. That's gonna be your best friend when shading jars\n"
                     + "with Maven. There are more options than displayed here.");
  }
  
  /**
   * String magic, prints a header (or footer) bar, with
   * or without a title. Footer bars (with the title as
   * null) are blessed with an extra line break.
   *  
   * @param title the optional title
   */
  public static void printBar(String title) {
    int i;
    for(i = 0; i < 28 - (title == null ? 0 : (title.length() + 2) / 2); i++) System.out.print("=");
    if(title != null) System.out.print(" " + title + " ");
    for(; i > 0; i--) System.out.print("=");
    System.out.println();
    if(title == null) System.out.println();
  }
  
}
