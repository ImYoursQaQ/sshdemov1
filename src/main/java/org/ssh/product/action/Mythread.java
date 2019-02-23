package org.ssh.product.action;

public class Mythread extends Thread {
    @Override
    public void run() {
        System.out.println("我被执行了。");
    }
}
