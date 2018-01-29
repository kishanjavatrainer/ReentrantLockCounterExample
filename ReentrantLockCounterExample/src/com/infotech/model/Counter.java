package com.infotech.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	private final Lock lock = new ReentrantLock();

	private int count = 0;

	// Thread Safe Increment
	public void increment() {
		lock.lock();
		try {
			count = count + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(lock != null){
				lock.unlock();
			}
		}
	}
	
	public int getCount() {
		return count;
	}
}
