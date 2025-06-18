package com.org.intermediate;

public class ClassAndObjectLevelLock {

    public static void main(String[] args) {
        ClassAndObjectLevelLock obj1 = new ClassAndObjectLevelLock();
        ClassAndObjectLevelLock obj2 = new ClassAndObjectLevelLock();

        // Two threads on different objects → no blocking on object-level
        new Thread(obj1::objectLevelLock).start();
        new Thread(obj2::objectLevelLock).start();

        // Two threads on class-level → blocking occurs
        new Thread(ClassAndObjectLevelLock::classLevelLock).start();
        new Thread(ClassAndObjectLevelLock::classLevelLock).start();
    }

    public static synchronized void classLevelLock() {
        System.out.println(Thread.currentThread().getName() + " acquired class-level lock");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }finally {
            System.out.println("Waiting...");
        }
    }

    public synchronized void objectLevelLock() {
        System.out.println(Thread.currentThread().getName() + " acquired object-level lock");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
    }
}
