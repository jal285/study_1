package javaconcurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalService();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed ! Reuslt was:: "+result);

    }
}
