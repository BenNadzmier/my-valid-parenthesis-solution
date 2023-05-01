import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static boolean isValid(String s) {
        
        Character prev = '\0'; //instantiate an empty character to reference previous
        List<Character> cnd = new ArrayList<>(); //condition to pass true (if it is empty)
        
        for (int i=0;i<s.length();i++){
            if (pop(prev,s.charAt(i)) == false){
                cnd.add(s.charAt(i)); //if they don't match, add to list
                prev = s.charAt(i); //update the previous character
            } else if (pop(prev, s.charAt(i)) == true){
                cnd.remove(cnd.size()-1); //if match, remove the last element
                prev = cnd.isEmpty() ? '\0' : cnd.get(cnd.size() - 1); //update previous, empty if none
            }
        }
        if (cnd.isEmpty() == true){
            return true;
        } else return false;
    }
    
    public static boolean pop(char p, char c){
        
        if (p == '\0'){ //if empty, then automatically add
            return false;
        }
        
        if (p == '(' && c == ')'){ //check if they match: if true then "pop"
            return true;
        } else if (p == '{' && c == '}'){
            return true;
        } else if (p == '[' && c == ']'){
            return true;
        } else return false;
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a set of parenthesis/es: ");
        String input = sc.nextLine();
        sc.close();

        System.out.println("\nDo the parentheses close?: " + isValid(input));
    }
}