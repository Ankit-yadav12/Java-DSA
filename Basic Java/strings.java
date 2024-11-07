//import java.util.*;
public class strings {

    public static void ShortestPath(String str){
        float x = 0, y=0;
        for(int i = 0;i<str.length();i++){
            switch(str.charAt(i)){
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                default:
                    System.out.println("Invalid direction: " + str.charAt(i));
                break;
            }
        }
        float sDistance =  (float)Math.sqrt(x*x+ y*y);
        System.out.println("Smallest distance for given path is : " + sDistance);
    }
   
    public static void stringCompression(String str){
        StringBuilder compressedStr = new StringBuilder("");
        int i = 0;
        while(i<str.length()){
            int count = 1;
            char temp = str.charAt(i);
            compressedStr.append(str.charAt(i));
            
            while(i+1<str.length() && str.charAt(i+1)==temp ){
                count++;
                i++;
            }
            if(count>1){
                compressedStr.append(count);
            }
            i++;
        }
        System.out.println(compressedStr);
    }
   
    public static void main(String args[]){
        //string declaration
        // char ch = 'a';
        String name = "ankit";
        String name2 = "ankur";
        String name3 = new String("Ankit");
        String sirName = "yadav";
        String array[]= { "ankit", "ankur", "arpit", "aniruddh", "rajai"};

        // //input output
        // System.out.print("enter pass: ");
        // @SuppressWarnings("resource")
        // Scanner input = new Scanner(System.in);
        // String pass = input.next();
        // System.out.println(pass);

        //String concatenation
        String fullName = name +" " +sirName;
        System.out.println(fullName);

        //String traversal (charAt)
        for(int i = 0; i<fullName.length();i++){
            System.out.print(fullName.charAt(i)+" ");
        }

        //Palindrome
        String str="";
        for(int i=name.length()-1;i>=0;i--){
            char ch = name.charAt(i);
            str +=ch;
        }
        System.out.println();
        System.out.println(str);

        //String equal or not
        System.out.println(name==name2);
        System.out.println(name.equals(name3));
        System.out.println(name.equalsIgnoreCase(name3));

        //String comparison (larger or smaller) lexicographic order
        System.out.println(name.compareTo(name3));
        System.out.println(name.compareToIgnoreCase(name3));
        System.out.println(name.compareTo(name2));
        String largest = array[0];
        for(int i = 0 ; i<array.length;i++){
            if(array[i].compareTo(largest)>0)
                largest= array[i];
        }
        System.out.println(largest);

        //Shortest distance
        ShortestPath("NNEES");

        //String builder
        StringBuilder sb = new StringBuilder("");
        for (char i = 'a';i<='z';i++){
            sb.append(i);
        }
        System.out.println(sb);
        System.out.println(sb.length());

        //capitalize first character of each word in a string.
        String randomLine = "the name is ankit yadav.";
        StringBuilder capital = new StringBuilder("");
        for(int i = 0;i<randomLine.length();i++){
            if(i ==0)
                capital.append(Character.toUpperCase(randomLine.charAt(i)));
            else if(randomLine.charAt(i)==' '){
                capital.append(randomLine.charAt(i));
                i++;
                capital.append(Character.toUpperCase(randomLine.charAt(i)));
            }else
                capital.append(randomLine.charAt(i));
        }
        System.out.println(capital);

        //string compression
        stringCompression("aaabbcccccdee");
    }
}
