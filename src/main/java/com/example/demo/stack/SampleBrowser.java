package com.example.demo.stack;

/**
 * @author zg
 * @date 2018/11/10
 */
public class SampleBrowser {

    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("www.baidu.com");
        browser.open("www.google.com");
        browser.open("www.coolshell.cn");
        browser.open("www.apache.org");
        System.out.println("回退1:");
        browser.goback();
        System.out.println("回退2:");
        browser.goback();
        browser.open("www.manhua.com");

        System.out.println("前进1:");
        browser.forward();
        System.out.println("前进2:");
        browser.forward();

    }

    private String currentPage;
    private LinkedListBasedStack backPage;
    private LinkedListBasedStack forwardPage;

    public SampleBrowser() {
        this.backPage = new LinkedListBasedStack();
        this.forwardPage = new LinkedListBasedStack();
    }

    public SampleBrowser(LinkedListBasedStack backPage, LinkedListBasedStack forwardPage) {
        this.backPage = backPage;
        this.forwardPage = forwardPage;
    }

    public void open(String url) {
        backPage.push(this.currentPage);
        this.currentPage = url;
        System.out.println(url);
        forwardPage.reset();
    }

    public void goback() {
        if (!canGoback()) {
            System.out.println("无法后退");
        }
        forwardPage.push(this.currentPage);
        String url = backPage.pop();
        this.currentPage = url;
        System.out.println(url);
    }

    public void forward() {
        if (!canGoforward()) {
            System.out.println("无法前进");
        }
        backPage.push(this.currentPage);
        String url = forwardPage.pop();
        this.currentPage = url;
        System.out.println(url);
    }

    public boolean canGoforward() {
        if (forwardPage.getSize() == 0) {
            return false;
        }
        return true;
    }

    public boolean canGoback() {
        if (backPage.getSize() == 0) {
            return false;
        }
        return true;
    }

    public static class LinkedListBasedStack {
        private int size;
        private Node top;

        public void reset() {
            this.top = null;
            this.size = 0;
        }

        public void push(String value) {
            Node newNode = new Node(value, null);
            if (top == null) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
            ++size;
        }

        public String pop() {
            if (top == null) {
                return null;
            } else {
                String value = top.data;
                top = top.next;
                --size;
                return value;
            }
        }

        public int getSize() {
            return size;
        }

        public void printAll() {
            Node p = top;
            while (p.next != null) {
                System.out.print(p.data + "->");
                p = p.next;
            }
            System.out.println();
        }
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}
