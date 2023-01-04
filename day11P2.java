import java.io.*;
import java.util.*;
public class day11P2{  
   public static void main(String[] args) throws FileNotFoundException{
      Scanner f = new Scanner(new File("items.txt")); 
      ArrayList<LinkedList<Long>> m = new ArrayList<>();
      ArrayList<Integer> c = new ArrayList<>();
      for(int i =0; i < 8; i++){
         m.add(new LinkedList<>());
         c.add(0);
      }
      int index = 0;
      while(f.hasNextLine()){
         Scanner s = new Scanner(f.nextLine());
         while(s.hasNext()){
            m.get(index).addLast((long)Integer.parseInt(s.next())); 
         }
         index++;
      }
      for(int r = 0; r < 10000; r++){
         for(int n = 0; n < 8; n++){
            op(m, c , n);
            test(m, n);
         }
      }
      for(int n = 0; n < 8; n++){
         System.out.println(c.get(n)+"");
      }
   }
   public static void op(ArrayList<LinkedList<Long>> m, ArrayList<Integer> c, int n){
      for(int i = 0; i < m.get(n).size(); i++){
         c.set(n, c.get(n)+1);
         switch(n){
            case 0:
               m.get(n).set(i, m.get(n).get(i)*11%9699690);//9699690 = the multiple of all the primes that are the mod value (2*13*3*17*19*7*11*5)
               break;
            case 1:
               m.get(n).set(i, m.get(n).get(i)+1%9699690);//(a%xn)%n = a%n where x is equal to the product of the other numbers and it is just a constant
               break;
            case 2:
               m.get(n).set(i, m.get(n).get(i)+6%9699690); //if (a%bc)=n, then n%b = a%b & n%c = a%c 
               break;
            case 3:
               m.get(n).set(i, m.get(n).get(i)*m.get(n).get(i)%9699690); //(a%bc)%b = a%b & (a%bc)%c = a%c
               break;
            case 4:
               m.get(n).set(i, m.get(n).get(i)*7%9699690);
               break;
            case 5:
               m.get(n).set(i, m.get(n).get(i)+8%9699690);
               break;
            case 6:
               m.get(n).set(i, m.get(n).get(i)+5%9699690);
               break;
            case 7:
               m.get(n).set(i, m.get(n).get(i)+7%9699690);
               break;
         } 
      }
   }
   public static void test(ArrayList<LinkedList<Long>> m, int n){
      while(m.get(n).size()!=0){
         switch(n){
            case 0:
               if(m.get(n).getFirst()%2L==(long)0){
                  m.get(7).addLast(m.get(n).removeFirst());
               }else{
                  m.get(4).addLast(m.get(n).removeFirst());
               }
               break;
            case 1:
               if(m.get(n).getFirst()%13L==(long)0){
                  m.get(3).addLast(m.get(n).removeFirst());
               }else{
                  m.get(6).addLast(m.get(n).removeFirst());
               }
               break;
            case 2:
               if(m.get(n).getFirst()%3L==(long)0){
                  m.get(1).addLast(m.get(n).removeFirst());
               }else{
                  m.get(6).addLast(m.get(n).removeFirst());
               }
               break;
            case 3:
               if(m.get(n).getFirst()%17L==(long)0){
                  m.get(7).addLast(m.get(n).removeFirst());
               }else{
                  m.get(0).addLast(m.get(n).removeFirst());
               }               
               break;
            case 4:
               if(m.get(n).getFirst()%19L==(long)0){
                  m.get(5).addLast(m.get(n).removeFirst());
               }else{
                  m.get(2).addLast(m.get(n).removeFirst());
               }
               break;
            case 5:
               if(m.get(n).getFirst()%7L==(long)0){
                  m.get(2).addLast(m.get(n).removeFirst());
               }else{
                  m.get(1).addLast(m.get(n).removeFirst());
               }
               break;
            case 6:
               if(m.get(n).getFirst()%11L==(long)0){
                  m.get(3).addLast(m.get(n).removeFirst());
               }else{
                  m.get(0).addLast(m.get(n).removeFirst());
               }
               break;
            case 7:
               if(m.get(n).getFirst()%5L==(long)0){
                  m.get(4).addLast(m.get(n).removeFirst());
               }else{
                  m.get(5).addLast(m.get(n).removeFirst());
               }
               break;
         } 
      }
   }
}