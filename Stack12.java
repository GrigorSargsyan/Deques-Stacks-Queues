//ID: <A13058299>
//LOGIN: <cs12ucd>

import java.util.*;

public class Stack12<E> implements BoundedStack<E>
{
	// private variables to be used in this class
	private int capacity;
	private int head;
	private int tail;
	private int size;
	private ArrayList<E> array12;

	//Constructor to set the private variables
	public Stack12(int cap) 
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
	public boolean push(E e) 
	{
		// checks if full
		if ( size() >= capacity() )
			return false;
		// checks for null input
		if ( e == null)
			throw new NullPointerException();
		
		//adds to the top of stack
		array12.set(head, e);
		head++;
		size++;
		return true;
	}

	@Override
	public E pop() 
	{
		//checks if empty
		if ( size() <= 0)
			return null;
		
		//saves values of the top
		E tmp = array12.get(head - 1);
		//removes top from stack
		array12.set(head - 1, null);
		head--;
		size--;
		//returns the previous value of the top
		return tmp;	
		
	}

	@Override
	public E peek() 
	{
		//checks if empty
		if ( size() <= 0)
			return null;
		//gets value of the top
		E tmp = array12.get(head - 1);
		//returns value of the top
		return tmp;
	}

}
