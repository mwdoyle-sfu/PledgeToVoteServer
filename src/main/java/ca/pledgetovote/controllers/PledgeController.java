package ca.pledgetovote.controllers;

import ca.pledgetovote.model.Pledge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PledgeController {
    private List<Pledge> pledges = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong();

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello Sping Boot world!";
    }

    @PostMapping("/pledges")
    public Pledge createNewPledge(@RequestBody Pledge pledge) {
        //set pledge to have next ID:
        pledge.setId(nextId.incrementAndGet());

        pledges.add(pledge);
        return pledge;
    }
}
