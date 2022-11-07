package uz.team.sabredu.configs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorConfig {

    private static final ExecutorService executorService =
            Executors.newFixedThreadPool(10);


    public static void run() {
        executorService.submit(() -> System.out.println("::::::::::TREAD POOL STARTED::::::::::"));
    }

    public static void submit(Runnable runnable) {
        executorService.submit(runnable);
    }

}
