package com.imagine.gid.thunk.abstracts;

import android.util.Log;
import android.widget.Toast;

public class Computer<T> 
{
	private static final String TAG = "Computer";
	
	private Thunk<T> thunk;
	private T value;
	private Computer<T> computer;
	
	public Computer(Thunk<T> thunk)
	{
		Log.d(TAG, "constructed");
		this.thunk = thunk;
		computer = this;
	}

	public T getValue() 
	{
		Log.d(TAG + ".getValue()", "");
		value = computer.computeValue();
		return value;
	}

	protected T computeValue() 
	{
		Log.d(TAG + ".computeValue()", "");
		value = thunk.compute();
		computer = new DumbComputer<T>(thunk, value);
		return value;
	}
	
	//this is for maximal encapsulation
	private class DumbComputer<T> extends Computer<T>
	{
		private static final String TAG = "DumbComputer";
		private T value;
		
		public DumbComputer(Thunk<T> thunk, T value) 
		{
			super(thunk);
			Log.d(TAG, "constructed");
			this.value = value; 
		}

		//overriding so that value will be calculated only once.
		@Override
		protected T computeValue() 
		{
			Log.d(TAG, "");
			return value;
		}
	}

}


