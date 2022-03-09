/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment8;

/**
 *
 * @author Cristian
 */
public class Assignment8 {
    String text;
    Assignment8(String input){
        this.text = Azar(input);
    }
    public String Azar(String text){
        String[] words = text.split(" ");
        String[][] words2 = new String[words.length][];
        int [] lengthword = new int[words.length];
        int x = 0;
        for(String n: words){
            words2[x] = n.split("");
            String [] lengthword2 = n.split("");
            
            lengthword[x] = lengthword2.length;
            x++;
            
        }
        String[] words3 = new String[words.length];
        for(int  w = 0; w < words2.length; w++){
            int[] minmax = SignoPuntuacion(words2[w], lengthword[w]);
            if((minmax[1]- minmax[0]) > 1){
                String[] random= RandomWord(words2[w], lengthword[w], minmax[1],minmax[0]);
                words3[w] = String.join("", random);
            }
            else{
                String[] random = words2[w];
                words3[w] = String.join("", random);
            }
        }
        String Ret = String.join(" ", words3);
    return Ret;
    }
    public int[] SignoPuntuacion(String[] word, int length){
        int min = 1;
        int max = length-1;
        boolean min2 = false;
        boolean max2 = false;
        String[] sig = {"!","?","?","?",".",",", "(",")","[","]","{","}"};
        while(min2 != true){
            int x =0;
            for(String y: sig){
                if(y.equals(word[x])){
                    min ++;
                }
                else{
                    min2 = true;
                }
            }
            x++;
        }
        while(max2 != true){
            int m = max;
            for(String n: sig){
                if(n.equals(word[m])){
                    max --;
                }
                else{
                    max2 = true;
                }
            }
            m--;
        }
        int[] w= {min, max};
        return w;
    }
    public String[] RandomWord(String[] word, int length, int max,int min){
        int[] cam = new int[max - min];
        String[] cam2 = new String[max - min];
        for(int i = 0; i< cam.length;){
            int num = (int) (Math.random()*(max-1)+min);
            boolean norep = true;
            for(int j: cam){
                if(num == j){
                    norep = false;
                }
            }
            if(norep == true){
                cam[i] = num;
                cam2[i] = word[num];
                i++;
            }
        }
        for (String x : cam2) {
            word[min] = x;
            min++;
        }
        return word;
    }
    @Override
    public String toString(){
        return text;
    }
}
