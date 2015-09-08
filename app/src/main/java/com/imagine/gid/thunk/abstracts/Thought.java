package com.imagine.gid.thunk.abstracts;

import android.util.Log;

public class Thought extends Thunk<Integer>
{
	@Override
	protected Integer compute() 
	{
		return Integer.valueOf((int) (Math.random()*10));
	}
}
