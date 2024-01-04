package ruitao.threadPool;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;

@ToString
@Getter
@Log
class Customer implements Runnable {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(this);
        log.info("HelloThreadPool");
    }
}
