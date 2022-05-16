public class Main {

    static boolean isWork = true;

    public static void main(String[] args) {

        int result = (int) (Math.random() * 1000000000);
        System.out.println(result);
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 0;
                    while (isWork) {
                        System.out.println(i);
                        Thread.sleep(1000);
                        i++;
                    }
                } catch (Exception e) {

                }
            }
        });
        timer.start();

        Thread timer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (isWork) {
                        int i = (int) (Math.random() * 1000000000);
                        if (result == i) {
                            isWork = false;
                            System.out.println(i);
                        }
                    }
                } catch (Exception e) {

                }
            }
        });
        timer2.start();
    }
}
