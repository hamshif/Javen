package com.imagine.gid.thunk.abstracts;

abstract class Thunk<T>
{
	private T value;
	private Computer<T> computer;
	
	public Thunk()
	{
		computer = new Computer<T>(this);
	}
	
	public T get()
	{
		value = computer.getValue();	
		return value;
	}

	abstract protected T compute();
}
