package org.ssh.product.action;

import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        Thread thread = new Mythread();
        thread.setName("测试");
        thread.start();
    }
}
