package Lesson5;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    public static void main(String[] args) {
        m1();
        m2();
    }

    public static void m1(){
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время m1: " + (System.currentTimeMillis() - timeStart));
    }
    public static void m2(){
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        long timeStart = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        System.out.println("Время разбивки m2: " + (System.currentTimeMillis() - timeStart));

        Thread t1 =  new Thread(()->{
            long timeStart1 = System.currentTimeMillis();
            for (int i = 0; i < HALF; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Время m2 a1: " + (System.currentTimeMillis() - timeStart1));
        });
        Thread t2 = new Thread(()->{
            long timeStart2 = System.currentTimeMillis();
            for (int i = 0; i < HALF; i++) {
//                a2[i] = (float)(a2[i] * Math.sin(0.2f + i/ 5) * Math.cos(0.2f + i/ 5) * Math.cos(0.4f + i/ 2));
//                Я считаю что корректнее будет использовать нижеприведенную формулу, тогда сравнение будет на равных,
//                время вычисления прогрессирует с увеличением значения i.
//                Но в этом случае время выполнения двух методов будет отличаться незначительно.
//                Иногда даже этот дольше, не знаю почему.
                a2[i] = (float)(a2[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            }
            System.out.println("Время m2 a2: " + (System.currentTimeMillis() - timeStart2));
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timeStart = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        System.out.println("Время склейки m2: " + (System.currentTimeMillis() - timeStart));

//        Расчет времени дополнительной операции в измененной формуле. Она занимает около 3мс и его можно не учитывать
        int asd;
        timeStart = System.currentTimeMillis();
        for (int i = 0; i < HALF; i++) {
            asd = i + HALF;
            asd = i + HALF;
            asd = i + HALF;
        }
        System.out.println(System.currentTimeMillis() - timeStart);
    }

}
