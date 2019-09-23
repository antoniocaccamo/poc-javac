package com.github.antoniocaccamo.poc.javacv;

import com.github.antoniocaccamo.poc.javacv.sample.Sample;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;


@Command(name = "poc-javacv",
        version = {"1.0.0"},
        description = "...",
        mixinStandardHelpOptions = true,
        subcommands = {
            Sample.class
        }
        
)
@Slf4j
public class JavaCV implements Runnable {

    @Value("${micronaut.application.name}")
    private String name;

    //@Value("${app.file}")
    //private String file;

    //@Option(names = {"-v", "--verbose"}, description = "...")
    //boolean verbose;

    //@Inject
    //DataSource dataSource;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(JavaCV.class, args);
    }

    public void run() {
        picocli.CommandLine.usage(this, System.out);
    }
}
