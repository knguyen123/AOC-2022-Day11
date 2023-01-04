import java.io.*;
import java.util.*;
public class day11{  
   public static void main(String[] args) throws FileNotFoundException{
      Scanner f = new Scanner(new File("items.txt")); 
      ArrayList<LinkedList<Integer>> m = new ArrayList<>();
      ArrayList<Integer> c = new ArrayList<>();
      for(int i =0; i < 8; i++){
         m.add(new LinkedList<>());
         c.add(0);
      }
      int index = 0;
      while(f.hasNextLine()){
         Scanner s = new Scanner(f.nextLine());
         while(s.hasNext()){
            m.get(index).addLast(Integer.parseInt(s.next())); 
         }
         index++;
      }
      for(int r = 0; r < 20; r++){
         for(int n = 0; n < 8; n++){
            op(m, c , n);
            test(m, n);
         }
      }
      for(int n = 0; n < 8; n++){
         System.out.println(c.get(n)+"");
      }
   }
   public static void op(ArrayList<LinkedList<Integer>> m, ArrayList<Integer> c, int n){
      for(int i = 0; i < m.get(n).size(); i++){
         c.set(n, c.get(n)+1);
         switch(n){
            case 0:
               m.get(n).set(i, (m.get(n).get(i)*11)/3);
               break;
            case 1:
               m.get(n).set(i, (m.get(n).get(i)+1)/3);
               break;
            case 2:
               m.get(n).set(i, (m.get(n).get(i)+6)/3);
               break;
            case 3:
               m.get(n).set(i, (m.get(n).get(i)*m.get(n).get(i))/3);
               break;
            case 4:
               m.get(n).set(i, (m.get(n).get(i)*7)/3);
               break;
            case 5:
               m.get(n).set(i, (m.get(n).get(i)+8)/3);
               break;
            case 6:
               m.get(n).set(i, (m.get(n).get(i)+5)/3);
               break;
            case 7:
               m.get(n).set(i, (m.get(n).get(i)+7)/3);
               break;
         } 
      }
   }
   public static void test(ArrayList<LinkedList<Integer>> m, int n){
      while(m.get(n).size()!=0){
         switch(n){
            case 0:
               if(m.get(n).getFirst()%2==0){
                  m.get(7).addLast(m.get(n).removeFirst());
               }else{
                  m.get(4).addLast(m.get(n).removeFirst());
               }
               break;
            case 1:
               if(m.get(n).getFirst()%13==0){
                  m.get(3).addLast(m.get(n).removeFirst());
               }else{
                  m.get(6).addLast(m.get(n).removeFirst());
               }
               break;
            case 2:
               if(m.get(n).getFirst()%3==0){
                  m.get(1).addLast(m.get(n).removeFirst());
               }else{
                  m.get(6).addLast(m.get(n).removeFirst());
               }
               break;
            case 3:
               if(m.get(n).getFirst()%17==0){
                  m.get(7).addLast(m.get(n).removeFirst());
               }else{
                  m.get(0).addLast(m.get(n).removeFirst());
               }               
               break;
            case 4:
               if(m.get(n).getFirst()%19==0){
                  m.get(5).addLast(m.get(n).removeFirst());
               }else{
                  m.get(2).addLast(m.get(n).removeFirst());
               }
               break;
            case 5:
               if(m.get(n).getFirst()%7==0){
                  m.get(2).addLast(m.get(n).removeFirst());
               }else{
                  m.get(1).addLast(m.get(n).removeFirst());
               }
               break;
            case 6:
               if(m.get(n).getFirst()%11==0){
                  m.get(3).addLast(m.get(n).removeFirst());
               }else{
                  m.get(0).addLast(m.get(n).removeFirst());
               }
               break;
            case 7:
               if(m.get(n).getFirst()%5==0){
                  m.get(4).addLast(m.get(n).removeFirst());
               }else{
                  m.get(5).addLast(m.get(n).removeFirst());
               }
               break;
         } 
      }
   }
}