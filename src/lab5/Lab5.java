/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;
import java.io.*;
import java.util.*;
/**
 *
 * @author Oleksiy.Rudenko@gmail.com
 */
public class Lab5 {
//
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Lab05
        //Цель работы: изучить механизм организации ввода/вывода на языке Java2.
        //
        //Задание: 1. Изучить библиотеку классов для организации потокового ввода/вывода.
        //2. Написать программу на языке Java2, которая обрабатывает содержимое текстового 
        //    файла согласно варианту задания.
        //
        //11. Прочитать из текстового файла последовательность строк. 
        //    Выбрать и сохранить в другом файле 
        //    m последних слов в каждой из последних n строк 
        //    (значения m и n задаются набором на клавиатуре).
        int m=MyIO.getInteger("How many latest words from a line to take (test value == 6)? "),
            n=MyIO.getInteger("How many latest lines to process (test value == 5)? ");
        
        // read n last lines
        LimitedQueue<String> queue=new LimitedQueue<String>(n);
        
        /* String s0="aaaa";
        String s1="bbbb";
        String s2="cccc";
        queue.add(s0);
        queue.add(s1);
        queue.add(s2);
        queue.add(s2);
        queue.add(s0);
        queue.add(s1);
        queue.add(s0);
        System.out.println(queue.dump()); */
        
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        String subPath="src/lab5/";
        
        // reuse LimitedQueue for word processing!!!!!!
        
        String line=null;
        BufferedReader br = new BufferedReader(new FileReader(subPath + "source.txt"));
        try {
            while ((line=br.readLine())!=null) {
                queue.add(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if (br!=null)
                br.close();
        }
        System.out.println("File read result:\n"+queue.dump());
        
        // prepare output data
        ArrayList<String> out = new ArrayList<String>();
        for (String s : queue) {
            // ArrayList<String> str = new ArrayList<String>();
            ArrayList<String> word=new ArrayList<String>(Arrays.asList(s.split(" ")));
            if (word.size()>m)
                word.subList(0, word.size()-m).clear();
            out.add(String.join(" ", word));
            /*
            out.add( (word.size()>m) 
                    ? word.subList(word.size()-m,word.size()).clear()
                    : String.join(" ", word)); */
        }
        System.out.println("Data to write:\n"+queue.dump());
        int i=0;
        for (String str: out) {
            System.out.println((i++)+" : " + str);
        }
        
        // write data
        BufferedWriter bw = new BufferedWriter(new FileWriter(subPath + "source_processed.txt", false));
        i=0;
        for (String str: out) {
            bw.write(str);
            if (++i<out.size())
                bw.newLine();
        }
        bw.close();
        
    }
    
}
