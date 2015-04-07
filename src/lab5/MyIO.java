/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Oleksiy.Rudenko@gmail.com
 */
public class MyIO {
    static Scanner ui=new Scanner(System.in);

    public static int getInteger(String echo) { // throws IOException {
        System.out.print(echo);
        int ret;
        String input=ui.nextLine();
        try {
            ret = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ret = 0;
        }
        // System.out.print(ret);
        return ret;
    }

    public static String getString(String echo) {
        System.out.print(echo);
        String input=ui.nextLine();
        return input;
    }
    
}
