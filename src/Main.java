public class Main {

    static class thread1 extends Thread {
        @Override
        public void run() {
            ListLock<Integer> ll = new ListLock<>();
            //trying different methods
            ll.add(2);
            ll.add(6);
            ll.add(1, 17);
            ll.add(93);
            System.out.println("For ListLock {"+ll+"}");
            System.out.println(ll.size());
            System.out.println(ll.contains(6));
            ll.remove(3);
            System.out.println(ll.indexOf(6));
        }
    }
    static class thread2 extends Thread {
        @Override
        public void run() {
            MapSemaphore<Integer, String> ms = new MapSemaphore<>();

            ms.put(1, "Serega");
            ms.put(2, "Petr");
            ms.put(3, "Vitalya");

            System.out.println(ms);
            System.out.println(ms.values());
            System.out.println(ms.keySet());
            ms.remove(2);
            System.out.println(ms);
            System.out.println(ms.size());
        }
    }
    public static void main(String[] args) {

        thread1 ll = new thread1();
        ll.start();
        thread2 ms = new thread2();
        ms.start();


    }
}
