

public class stringSearch {

//main class
    public static void main(String[] args) {
        String name = " ANKIT YADAV ";
        
        char target ='A';

        // function call 
        boolean ans = ls(name ,target);
        System.out.println(ans);
    }

// function for performing linear seach
    static boolean ls (String str , char target){
        if (str.length() ==0)
            return false;

        for (int i = 0; i<str.length();i++){
            char element = str.charAt(i);
            if (element == target)
                return true;
        }

// this is executed if none of the above statements work
        return false;

    }
}
