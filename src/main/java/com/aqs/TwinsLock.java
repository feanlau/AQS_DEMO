package com.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * aqs demo
 * 设置一个同步工具，该工具在同一时刻，只允许至多两个线程同时访问，超过两个线程访问将被阻塞
 * 由于至多两个线程同时访问，所以用共享式同步状态获取
 *
 * @author feanlau
 */
public class TwinsLock implements Lock {
    /**
     * 设置初始状态status为2
     */
    private final Sync sync = new Sync(2);

    /**
     * 加锁，每调用一次，同步状态-1
     */
    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }

    /**
     * 释放锁，每调用一次，同步状态+1
     */
    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }

}
