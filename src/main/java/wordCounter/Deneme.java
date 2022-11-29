package wordCounter;

import java.util.ArrayList;
import java.util.Arrays;

public class Deneme {
    public static void main(String[] args) {

        String str = "bana sana senden bana sana kime kimden kime sana";
        String[] arr = str.split(" ");
        System.out.println(Arrays.toString(arr));
        ArrayList<String> brr = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int counter = 1;
            String s = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (s.equals(arr[j]))
                    counter++;
            }
            if (!brr.contains(s)){
                brr.add(s);
                System.out.println(s + " toplamda " + counter + " defa var");
            }

        }





    }
}
