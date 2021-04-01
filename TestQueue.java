/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testqueue;

/**
 *
 * @author MELİSA
 */
public class TestQueue {
 
    public static void main(String[] args) {
        
        Queue queue = new Queue();
        
        for(int i=1 ; i<21; i++){
            queue.enqueue(i);
            
            while(!queue.empty())
                System.out.print(queue.dequeue() + " ");
        }
    }
    
}

class Queue {
    
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 8;
    
    
    public Queue(){
        this(DEFAULT_CAPACITY);
    }
    
    public Queue(int capacity){
        elements=new int[capacity];
    }
   
    public void enqueue(int v){
        
        if( size >= elements.length){
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements,0,temp,0,elements.length);
            elements = temp;
                    
        } 
        elements[size] = v;
        size++;
    }
    
    public int dequeue(){
        
        size--;
        return elements[0];
    }
    
    public boolean empty(){
        return size == 0;
    }
    
    public int getSize(){
        return size;
    }
}

    
    
    
