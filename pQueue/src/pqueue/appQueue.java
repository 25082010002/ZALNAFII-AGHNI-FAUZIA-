package pqueue;
import java.util.Scanner;
class Order{
    String name;
    String item;
    int price;
    int qty;
    Order(String n, String  i, int p, int q){
        name=n; item=i; price=p; qty=q;
    }
    String getName(){ return name; }
    String getItem(){ return item; }
    int getPrince(){ return price; } // buatkan class sendiri seperti barang
    int getQty() { return qty; }
}
class Node{
    Order order;
    Node next; // lin
    Node(){}
}
class Queue{
    Node front,rear;
    int count,total;
    Queue(){}
    void enqueue(Node OrderNode){
        if(rear==null){
            front=rear=OrderNode;
        }else{
            rear.next=OrderNode;
            rear=OrderNode;
        }
        total=total+(OrderNode.order.price*OrderNode.order.qty);
    }
    void dequeue(){
        Node t=front;
        if(t==null){  //queue empty
            System.out.println("Queue is empty");
        }else if(t.next==null){  //queueu only 1 item
            front=rear=null;
        }else{
            front=front.next;
            t.next=null;
        }
        if(t==null){
            System.out.println("Empty queue");
        }else{
            System.out.println(t.order.item+ "out....");
        }
    }
    void view(){
        System.out.println("Order Queue");
        for(Node t=front; t!=null; t=t.next){
            System.out.print("["+t.order.name+",");
            System.out.print(t.order.item+","+t.order.price+",");
            System.out.print(t.order.qty+"]");
        }
        System.out.println("");
    }
}
public class appQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();
        int choice=0;
        do{
            System.out.println("App Order Queue");
            System.out.println("1.Order\n2.Process\n3.View");
            System.out.println("4.Exit");
            System.out.print("choice = ");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Buyer's Name = ");
                    String buyer = sc.next();
                    int buyAgain = 0; // ← kontrol loop
                    do {
                        // Loop memilih barang
                        System.out.println("List of Goods");
                        System.out.println("1. Shoes\n2. Sandals");
                        System.out.println("3. Jackets");
                        System.out.print("Choice = ");
                        int choice2 = sc.nextInt();
                        String item = "";
                        if (choice2==1) item = "Shoes";
                        else if (choice2==2) item = "Sandals";
                        else if (choice2==3) item = "Jackets";
                        System.out.print("Price = ");
                        int prc = sc.nextInt();
                        System.out.print("Quantity = ");
                        int qty = sc.nextInt();
                        Order ord  = new Order(buyer, item, prc, qty);
                        Node  node = new Node();
                        node.order = ord;
                        queue.enqueue(node);
                        // Tanya beli lagi?
                        System.out.println("Buy Again? ");
                        System.out.println("1. yes\n2. no ");
                        System.out.print("choice = ");
                        buyAgain = sc.nextInt(); // ← update nilai loop
                    } while(buyAgain == 1); // ← ulangi selama jawab 1
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.view();
                    break;
                case 4: System.out.println("Thank you");
            }
        }while(choice!=4);
    }
    
}
