
import java.util.*;

public class Demo{ 
  //#Map 
    //#key -> value 
    //#put (key k,value )-> add ,update 
    //#get(Object key)-> get the element
    //#remove(Object key)-> remove element 
    //#containsKey(Object k)-> key is exist or not 
    //#containsValue(Object k)-> value is exist or not 
    //#keySet()-> set of key 
    //#values()-> set of value 
    //#entrySet()-> key,value pair 
 
 //# Hashmap -> unordered 
 //#  LinkedHashMap ->insertion order 
 // # TreeMap -> sorted by the key
 // # Hashtable 
 
  //# Stack -> 


     public static void main(String[] args) {

      basicConcept();
    //   HashMap<String,Integer> ageMap = new HashMap<>();
    //     ageMap.put(null,35);
        
    //     ageMap.put("Person2",25);
     
    //     ageMap.put("Person3",25);

    //     ageMap.put("Person4",39);
        
        
    //     //ageMap.remove("Person1");



    // System.out.println(ageMap);

    // Stack<String> stack = new Stack<>();

    //   stack.push("Apple");
    //   stack.push("Orange");
    //   stack.push("Cherry");

    //  String item= stack.pop();

    //  System.out.println(item);

    //  System.out.println(stack.peek());
    //  System.out.println(stack);

     //# Queue 
    //  Queue <String> queue = new LinkedList<>();

    //   queue.add("Apple") offer();
    //   queue.add("Orange");
    //   queue.add("Cherry");

    //  String item= queue.remove() poll();

    //  System.out.println(item);

    //  System.out.println(queue.peek());
    //  System.out.println(queue);
  //#PriorityQueue 

// PriorityQueue<Integer> pq= new PriorityQueue<>();
 
//   pq.add(30);
//  pq.add(10);
//  pq.add(20);

//   int item = pq.poll()//# remove;

//  System.out.println(item);

//      System.out.println(pq.peek());
//      System.out.println(pq);
//    }   


// for (Type variable :collection ){

// }

  ArrayList <String> fruits = new ArrayList<>();

    fruits.add("apple");
    fruits.add("orange ");
    fruits.add("banana");

    // for(String fruit : fruits ){
    //   System.out.println(fruit);
    // }

//Iterator 
// iterator()

// hasNext()
// next()
// remove()

  // Iterator<String> iterator= fruits.iterator();

  // while(iterator.hasNext()){
  //   String fruit =iterator.next();
  //   System.out.println(fruit);
  // }

// ArrayList<Integer> number = new ArrayList<>();
//           number.add(1);
//           number.add(2);
//           number.add(3);
//           number.add(4);
//           number.add(5);
//           number.add(6);

//   Iterator<Integer> iterator= number.iterator();

//   while(iterator.hasNext()){
//     Integer num =iterator.next();
//     System.out.println(num);
//     if(num % 2 == 0){
//       iterator.remove();
//     }
//   }
//   System.out.println(number);

// @FunctionalInterface 

  // interface Greeting {
  //   void sayHello(String name ); //One Abstract Method 
  //   default void log(String msg ){
  //     System.out.println(msg);
  //   }
  // }

  // (parameter) -> {body }

  // () -> System.out.println("hello ");

  // x -> x +2 

  // (x,y )-> x+y;

  // (x,y)->{
  //   int sum =x +y;
  //   return sum ;
  // }







     }




  // public static  void basicConcept(){
  //    Calculator add = new Calculator(){
  //     @Override 
  //     public int calculate(int a ,int b ){
  //       return a +b;
  //     }
  //    };

  //    Calculator multiplication  = (a,b) -> a *b;

  //     int sum = add.calculate(5,4);

  //     int multi= multiplication.calculate(3,4);

  //     System.out.println(sum);
  //     System.out.println(multi);

  // }

 }
  //  @FunctionalInterface
  // interface Calculator{
  //   int calculate(int a ,int b );

  //   default void printResult(int result){
  //     System.out.println("Result"+ result);
  //   }

  //   static void info(){
  //     System.out.println("This is a Calculator Interface");
  //   }
  // }


