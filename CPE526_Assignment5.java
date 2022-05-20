package cpe526_assignment5;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*


*/
public class CPE526_Assignment5 {

    static ArrayList<Integer> factors = new ArrayList<Integer>();
    static int iteration;

    
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        
        System.out.print("Please give a number: ");
        int n = in.nextInt();
        
        firstMethod( n );
        
        if(factors.isEmpty()){
            System.out.println(n+" is a prime number.");   
        } else {
            System.out.println(n+" is a composite number.");  
            System.out.print("Factors are: ");
            String F = "";
            for(int i=0; i< factors.size();i++){
               F += factors.get(i)+", ";
            }
           StringBuffer sb= new StringBuffer(F);
           sb.deleteCharAt(sb.length()-2);  
           System.out.println(sb);
        }
        
        System.out.println("With 1st method number of iteration is:"+ iteration);

        
        factors.clear();
        secondMethod(n);
        
        if(factors.isEmpty()){
            System.out.println("With 2st method number of iteration is:"+ iteration);  // prime  
        }else{
            System.out.println("With 1st method number of iteration is:"+ iteration); // composite
        }
        
    }
    
    public static void firstMethod(int n ){
        int i;

        if(n <= 2){
            return;
        }
            
        for( i = 2; i < n ; i++){
            if(n%i == 0 ){
                if(!factors.contains(i)  )
                    factors.add(i);
            }           
        }
        iteration = i-2;

    }
    
    public static void secondMethod(int n){
        int b = (int) Math.sqrt(n);
        int i = 2;    
        
        while( n > 1 && i <= b){
            while(n%i == 0){
                if(!factors.contains(i))
                    factors.add(i);
                n = n/i;
                b = (int) Math.sqrt(n);
            }
            i++;
        }
        
            iteration = i; 
        
        
   
    }
    
}
