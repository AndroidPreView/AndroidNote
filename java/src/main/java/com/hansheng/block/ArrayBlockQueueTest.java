package com.hansheng.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hansheng on 2016/7/8.
 * put(anObject):��anObject�ӵ�BlockingQueue��,���BlockQueueû�пռ�,����ô˷������̱߳����ֱ��BlockingQueue�����пռ��ټ���.
 */
public class ArrayBlockQueueTest {

    public static void main(String... args){
        final BlockingQueue queue=new ArrayBlockingQueue(3);
        for(int i=0;i<2;i++){
            new Thread(){
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep((long) (Math.random()*1000));
                            System.out.println(Thread.currentThread().getName()+"׼��������");
                            queue.put(1);
                            System.out.println(Thread.currentThread().getName()+"�Ѿ���������,����Ŀǰ��"+queue.size()+"������");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
        new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"׼��ȡ����");
                        queue.take();
                        System.out.println(Thread.currentThread().getName()+"�Ѿ�ȡ������,����Ŀǰ��"+queue.size()+",������");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
