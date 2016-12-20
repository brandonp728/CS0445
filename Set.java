package cs445.a1;

public class Set<T> implements SetInterface<T>{
	
	private T[] arry;
	private int size;
	
	public Set(int capacity)
	{
		size=0;
		arry = (T[])new Object[capacity];
	}
	
	public Set()
	{
		size=0;
		arry = (T[])new Object[30];
	}
	
	
	public int getCurrentSize() {
		return size;
	}
	
	
	public boolean isEmpty() {
		if(size==0)
		{
			return true;
		}
		return false;
	}

	
	public boolean add(Object newEntry) throws SetFullException, IllegalArgumentException {
		boolean added=false;
		if((newEntry!=null) && !this.contains(newEntry) && (size<arry.length))
		{
			arry[size] = (T) newEntry;
			size++;
			added=true;
		}
		else if(newEntry==null)
		{
			throw new IllegalArgumentException();
		}
		else if(size==arry.length)
		{
			throw new SetFullException();
		}
		return added;
	}
	
	public boolean remove(Object entry) throws IllegalArgumentException {
		boolean removed=false;
		if(this.contains(entry))
		{
			for(int i=0; i<size; i++)
			{
				if(arry[i]==entry)
				{
					arry[i] = null;
					size--;
					removed=true;
				}
			}
		}
		else if(!this.contains(entry))
		{
			return removed;
		}
		else if(entry==null)
		{
			throw new IllegalArgumentException();
		}
		return removed;
	}

	@Override
	public T remove() {
		T temp=null;
		if(size>=1)
		{
			temp=arry[size-1];
			arry[size-1]=null;
			size--;
		}
		else if(size==0)
		{
			return temp;
		}
		return temp;
	}

	@Override
	public void clear() {
		if(!this.isEmpty())
		{
			for(int i=0; i<arry.length; i++)
			{
				arry[i]=null;
			}
		}
	}

	@Override
	public boolean contains(Object entry) throws IllegalArgumentException {
		if(entry==null)
		{
			throw new IllegalArgumentException();
		}
		else{
		for(int i=0; i<arry.length; i++)
		{
			if(arry[i]==entry)
			{
				return true;
			}
		}
		}
		return false;
	}

	@Override
	public T[] toArray() {
		T[] tempArry = (T[]) new Object[30];
		int nonNullVals=0;
		for(int i=0; i<arry.length; i++)
		{
			if(arry[i]!=null)
			{
				nonNullVals++;
			}
		}
		tempArry = (T[]) new Object[nonNullVals];
		for(int i=0; i<tempArry.length; i++)
		{
			if(arry[i]!=null)
			{
				tempArry[i] = arry[i];
			}
		}
		return tempArry;
	}

}
