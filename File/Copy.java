package File;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Copy {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Usage: java Copy <input> <output>");
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter input file name: ");
      args[0] = scanner.nextLine();
      System.out.print("Enter output file name: ");
      args[1] = scanner.nextLine();
      scanner.close();
    }

    File input = new File(args[0]);
    File output = new File(args[1]);

    Charset utf8 = Charset.forName("UTF-8");
    try {
      FileReader reader = new FileReader(input, utf8);
      FileWriter writer = new FileWriter(output, utf8);
      int c;
      while ((c = reader.read()) != -1) {
        writer.write(c);
      }
      reader.close();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
