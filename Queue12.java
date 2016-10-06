//ID: <A13058299>
//LOGIN: <cs12ucd>

import java.util.*;

public class Queue12<E> implements BoundedQueue<E>
{
	// private variables to be used in this class
	private int head;
	private int tail;
	private int capacity;
	private int size;
	private ArrayList<E> array12;
	
	//Constructor to set the private variables
	public Queue12(int cap) 
	{
		if (cap <= 0)
			throw new IllegalArgumentException();
		
		capacity = cap;
		head = 0;
		tail = 0;
		size = 0;
		
		array12 = new ArrayList<E>(capacity);
		// Populates the array with nulls
		for (int i = 0; i < cap; i++)
			array12.add(i, null);
	}

	@Override
	public int capacity()
	{
		//returns capacity
		return this.capacity;
	}

	@Override
	public int size() 
	{
		//returns size
		return this.size;
	}

	@Override
	public boolean enqueue(E e) 
	{
		//checks if full
		if ( size() >= capacity() )
			return false;
		//checks for null input
		if ( e == null)
			throw new NullPointerException();
		//adds to end of the queue
		array12.set(tail, e);
		tail++;
		size++;
		
		return true;
	}

	@Override
	public E dequeue() 
	{
		//checks if empty
		if ( size() <= 0)
			return null;
		//saves value of the front of queue
		E tmp = array12.get(head);
		//makes copy of the queue
		ArrayList<E> copy = array12;
		//removes value from front of the queue
		array12.set(head, null);
		//shifts all values forward by one
		for (int i = head; i < size(); i++)
		{
			E copyHead = copy.get(i+1);
			array12.set(i, copyHead);	
		}
		size--;
		tail--;
		//returns updated queue
		return tmp;	
	}

	@Override
	public E peek() 
	{
		//checks if queue is empty
		if ( size() <= 0)
			return null;
		//gets value at the front of the queue
		E tmp = array12.get(head);
		//returns the front value
		return tmp;
		
	}
}
