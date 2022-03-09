/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gradleproject5;

/**
 *
 * @author Cristian
 */
public class Utility {
    public static String[] Repeated(String text){
        String min = text.toLowerCase();
        String[] words = min.split(" ");
        int times = 0;
        int timeplus = 0;
        int big = 0;
        int b= 0;
        String[] sinrep = new String[words.length]; 
        for (int a = 0; a < words.length - 1; a++){  
            if (!words[a].equals(words[a+1])){  
                sinrep[b++] = words[a];  
            }
        }
        for (int y = 0; y < sinrep.length; y++){
            for (String n: words){
                if(n.equals(sinrep[y])){
                    times ++;
                }
            }
            if(times > timeplus){
                timeplus = times;
                big = y;
            }
            times = 0;
        }
        String[] word = {words[big], String.valueOf(timeplus)};
        return word;
    }
    public static String[] RepeatedWords(String text){
        String min = text.toLowerCase();
        String[] words = min.split(" ");
        int times = 0;
        int b= 0;
        String[] sinrep = new String[words.length]; 
        for (int a = 0; a < words.length - 1; a++){  
            if (!words[a].equals(words[a+1])){  
                sinrep[b++] = words[a];  
            }
        }
        String[] total = new String[2*(words.length)];
        int c = 0;
        for (int i = 0; i < b - 1; i++) {
            for (String n : words) {
                if (n.equals(sinrep[i])) {
                    times ++;
                }
            }
            total[c] = sinrep[i];
            c++;
            total[c] = String.valueOf(times);
            c++;
            times = 0;
        }
        String[] totalfinal = new String[c];
        System.arraycopy(total, 0, totalfinal, 0, totalfinal.length);
    return totalfinal;
    }
}
