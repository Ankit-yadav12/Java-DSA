public class backtracking {
    
    public static void permutation(String str,String newstr,boolean[] used){
        if(str.length()==newstr.length() ){
            System.out.println(newstr);
            return;
        }
        for(int i = 0;i<str.length();i++){
            if (used[i]) {
                continue;
            }
            used[i] = true;
            permutation(str, newstr + str.charAt(i), used);
            used[i] = false;
        }
    }

    public static void permutation(String str,String ans){
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for(int i = 0;i<str.length();i++){
            String  newstr= str.substring(0,i)+str.substring(i+1);
            permutation(newstr, ans+str.charAt(i));
        }  
    }
    
    public static void main(String[] args){
        String str = "Ank";
        boolean[] used = new boolean[str.length()];
        permutation(str, "",used);

        permutation(str, "");
    }
}
