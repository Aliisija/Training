package com.accenture.op.task_domain.controllers;

import com.accenture.op.task_domain.services.GreetingPage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingController {
        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        @RequestMapping({"/greeting","","/"})
        public GreetingPage greeting(@RequestParam(value="name", defaultValue="World") String name) {
            return new GreetingPage(counter.incrementAndGet(),
                    String.format(template, name));
        }

}
