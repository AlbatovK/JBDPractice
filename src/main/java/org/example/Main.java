package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, InterruptedException {
//        Sample obj = new Sample();
//        Class<? extends Sample> cls = obj.getClass();
//        System.out.println(cls.getName());
//        Constructor<? extends Sample> constructor = cls.getConstructor();
//        System.out.println(constructor.getParameterCount());
//
//        Method[] methods = cls.getMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName() + " " + method.getReturnType());
//        }
//
//        System.out.println();
//        obj.printString();
//        Field field = cls.getDeclaredField("str");
//        field.setAccessible(true);
//        field.set(obj, "New String");
//        obj.printString();
//
//        Method privateMethod = cls.getDeclaredMethod("privateMethod");
//        privateMethod.setAccessible(true);
//        privateMethod.invoke(obj);


//        Thread thread = new MyThread();
//        thread.start();
//        System.out.println("Hello from main");
//        Thread thread1 = new MyThread();
//        thread1.setName("MyThread");
//        thread1.start();

//        Runnable task = () -> {
//            try {
//                System.out.println("Work in another thread started");
//                Thread.sleep(20000);
//                System.out.println("Work in another thread ended");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//
//        Thread thread2 = new Thread(task);
//        thread2.setDaemon(true);
//        thread2.start();
//        System.out.println("Work in main started");
//        Thread.sleep(10000);
//        System.out.println("Work in main ended");
//        thread2.interrupt();

//        Runnable task = () -> {
//            try {
//                System.out.println("Start Thread");
//                Thread.sleep(5000);
//                System.out.println("Finished");
//            } catch (InterruptedException e)  {
//                e.printStackTrace();
//            }
//        };
//        Thread thread = new Thread(task);
//        thread.start();
//        thread.join(3000);
//
//        System.out.println("Work in main");


        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            RunnableTask task = new RunnableTask(String.valueOf(i));
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}


class RunnableTask implements Runnable {
    private final String taskName;

    public RunnableTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("Task " + taskName + " is complete");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Start");
            Thread.sleep(2000);
            System.out.println("hello from " + this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Sample {
    private final String str;

    public Sample() {
        this.str = "Java Reflection API";
    }

    public void printString() {
        System.out.println(this.str);
    }

    private void privateMethod() {
        System.out.println("Private method");
    }
}
