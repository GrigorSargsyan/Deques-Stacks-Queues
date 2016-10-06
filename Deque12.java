//ID: <A13058299>
//LOGIN: <cs12ucd>

import java.util.*;

public class Deque12<E> implements BoundedDeque<E>
{
	// private variables to be used in this class
	private int capacity;
	private int head;
	private int tail;
	private int size;
	private ArrayList<E> array12;
	
	//Constructor to set the private variables
	public Deque12(int cap)
	{
		if (cap < 0)
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
	public boolean addFront(E e) 
	{
		//checks if full
		if ( capacity() == size() )
			return false;
		//checks for null input
		if ( e == null)
			throw new NullPointerException();
		
		head--;
		//Keeps head between indices 0 and capacity - 1
		if(head == -1)
			head = capacity - 1;
		//Sets value of head
		array12.set(head, e);
		size++;
		return true;
		
	}

	@Override
	public boolean addBack(E e) 
	{
		//checks if full
		if ( capacity() == size() )
			return false;
		//Sets value of head
		if ( e == null)
			throw new NullPointerException();
		//Sets value of tail
		array12.set(tail, e);
		
		tail++;
		//Keeps tail between indices 0 and capacity - 1
		if(tail == capacity) 
			tail = 0;
		
		size++;
		return true;
	}

	@Override
	public E removeFront() 
	{
		//checks if empty
		if ( size <= 0) 
			return null;
		
		E tmp = array12.get(head);
		//removes head
		array12.set(head, null);
		head++;
		size--;
		//returns value of original head
		return tmp;
	}

	@Override
	public E removeBack() 
	{
		//checks if empty
		if ( size <= 0 )
			return null;
		tail--;
		if ( tail < 0)
			tail = capacity - 1;
		
		E tmp = array12.get(tail);
		//removes tail
		array12.set(tail, null);
		size--;
		//returns value of original tail
		return tmp;
	}

	@Override
	public E peekFront() 
	{
		//checks if empty
		if ( size == 0 )
			return null;
		else
			return array12.get(head);
	}

	@Override
	public E peekBack() 
	{
		//checks if tail has looped around
		if ( --tail < 0)
			return array12.get(capacity - 1);
		else
			return array12.get(tail--);
	}

}
