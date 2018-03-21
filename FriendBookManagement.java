/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendbookmanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import testbst.BST;

/**
 *
 * @author AVRO
 */
public class FriendBookManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Welcome to Friend Book Management System");
        selectOperation();
    }

    public static void selectOperation() throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Keyword\n 1.Add\n 2.Delete\n 3.Search\n 4.Show All\n 5.Exit");
        int key = input.nextInt();
        switch (key) {
            case 1:
                System.out.println("Add");
                add();
                break;
            case 2:
                System.out.println("Delete");
                delect();
                break;
            case 3:
                System.out.println("Search");
                search();
                break;
            case 4:
                System.out.println("Show All");
                show();
                break;
            case 5:
                System.exit(0);
            default:
                selectOperation();

        }
    }

    public static void add() {
        BST<String> intTree = new BST<String>();
        // BST<Friend> friend1  = new BST<Friend>("","");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a username for adding");
        String username = input.nextLine();
        intTree.insert(username);
        System.out.println("Please Enter your address");
        String address = input.nextLine();
        intTree.insert(address);
        System.out.println("Please Enter your phone number");
        String number = input.nextLine();
        intTree.insert(number);
        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream("My.txt", true));
            printWriter.print(username + ",");
            printWriter.print(address+ ",");
            printWriter.print(number);

            printWriter.println();
            printWriter.close();
        } catch (Exception e) {
        }
        //System.out.println("what r u looking for?");
        //intTree.search(username);
    }

    //public static void add() {
    // TODO code application logic here
    public static void delect() {
        BST<String> intTree = new BST<String>();
       
        try {

          File inFile = new File("My.txt");

          if (!inFile.isFile()) {
            System.out.println("Parameter is not an existing file");
            return;
          }

          //Construct the new file that will later be renamed to the original filename. 
          File tempFile = new File("myTempFile.txt");

          BufferedReader br = new BufferedReader(new FileReader(inFile));
          PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

          String line = null;
          Scanner input=new Scanner(System.in);
          System.out.println("Enter name to remove:");
          String delete = input.nextLine();
          String lineToRemove = delete;

          //Read from the original file and write to the new 
          //unless content matches data to be removed.
          while ((line = br.readLine()) != null) {
            if (!line.trim().contains(lineToRemove)) {
              pw.println(line);
              pw.flush();
            }
          }

          pw.close();
          br.close();

          //Delete the original file
          if (!inFile.delete()) {
            System.out.println("Could not delete file");
            return;
          } 

          //Rename the new file to the filename the original file had.
          if (!tempFile.renameTo(inFile)) {
            System.out.println("Could not rename file");
          }

        } catch (FileNotFoundException ex) {
          ex.printStackTrace();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    

    public static void search() throws FileNotFoundException, IOException {
        BST<String> intTree = new BST<String>();
        try {
            Scanner input = new Scanner(new FileInputStream("My.txt"));
            Scanner find = new Scanner(System.in);
            String name = find.nextLine();
            while (input.hasNextLine()) {
                if (input.nextLine().contains(name)) {
                    System.out.println("found");
                } else {
                    System.out.println("Sorry!There is no name exist in the database");
                }
            }
            return;
        } catch (FileNotFoundException filenotfoundexception) {

        }

    }

    public static void show() {
        BST<String> intTree = new BST<String>();
        int index = 0;
        try {
            Scanner name = new Scanner(new FileInputStream("My.txt"));
          
            //String username = name.nextLine();
            //intTree.delete(username);

            while (name.hasNextLine()) {
                String catagory = name.nextLine();//just called a variable

                System.out.println(index + 1 + "-" +catagory);
                index++;
            }
            //System.out.println(index);
        } catch (Exception e) {
        }

    }
}
