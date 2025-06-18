package com.org.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    //When a thread enters outer(), it already holds the lock on this.
    //When it calls inner(), it re-enters the same lock.
    //No deadlock occurs — because Java allows reentrancy.
    public static void main(String[] args) {
        outer();
        System.out.println("reentrantLockTest");
        reentrantLockTest();
    }

    public static synchronized void outer() {
        System.out.println(Thread.currentThread().getName() + " entered in outer lock");
        inner();
    }

    public static synchronized void inner() {
        System.out.println(Thread.currentThread().getName() + " entered in inner lock");
    }

    static void reentrantLockTest(){
        Lock lock = new ReentrantLock();

        lock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            // critical section
            lock.lock();  // reentrant
            System.out.println(Thread.currentThread().getName());
            try {
                // nested critical section
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }
}
