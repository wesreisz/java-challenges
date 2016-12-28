package com.wesleyreisz.demo.bookstore.greeting;

import com.wesleyreisz.demo.bookstore.greeting.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by wesleyreisz on 12/28/16.
 */
@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world")String name){
        return new Greeting(counter.getAndIncrement(),String.format("Hello %s", name));
    }
}
