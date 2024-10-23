package com.xoxltn.async_method;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Log4j2
@Component
public class AppRunner implements CommandLineRunner {

    private final GithubLookupService gitHubLookupService;

    public AppRunner(GithubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        //. start the clock
        long start = System.currentTimeMillis();

        //. kick of multiple, async lookups
        CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");
        CompletableFuture<User> page4 = gitHubLookupService.findUser("kayzweller");

        //. wait until they are all done
        CompletableFuture.allOf(page1, page2, page3, page4).join();

        //. print results, including elapsed time
        log.info("⏱️ elapsed time: {}ms", System.currentTimeMillis() - start);
        log.info("--> {}", page1.get());
        log.info("--> {}", page2.get());
        log.info("--> {}", page3.get());
        log.info("--> {}", page4.get());
        log.info("✅ done!✨");
    }

}
