package JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        //MyCache myCache = new MyCache();
        MyCacheLock myCache = new MyCacheLock();
        new MyCacheLock();
        //写入
        for (int i = 0; i < 5; i++) {
            final int tmp =i;
            new Thread(()->{
                myCache.put(tmp+"",tmp+"");
            },String.valueOf(i)).start();
        }
        //读取
        for (int i = 0; i < 5; i++) {
            final int tmp =i;
            new Thread(()->{
                myCache.get(tmp+"");
            },String.valueOf(i)).start();
        }
    }
}

//自定义缓存
class MyCache{
    private volatile Map<String,Object> map =new HashMap<>();

    //写，存
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+"写入OK");
    }

    //读，取
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取OK");
    }
}
//加锁的
class MyCacheLock{
    private volatile Map<String,Object> map =new HashMap<>();
    //读写锁
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //写入时，同时只有一个线程写
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();//开锁
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();//关锁
        }

    }

    //读，取
    public void get(String key){
        readWriteLock.writeLock().lock();//开锁
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}