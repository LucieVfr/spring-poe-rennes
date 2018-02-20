package poe.spring.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Bonjour, %s!";
    private final AtomicLong counter = new AtomicLong();
    
  @RequestMapping("/hi/name/{name}/lastname/{lastname}")
  public Greeting hi(@PathVariable(value="name") String name, @PathVariable(value = "lastname") String lastname) {
  return new Greeting(1, "Bonjour" + " " + name + " " + lastname);

//    @RequestMapping("/bonjour") //J'écoute sur cette URL
//    public Greeting greeting(@RequestParam(value="name", defaultValue="Lucie") String name) {
//        return new Greeting(counter.incrementAndGet(),
//                            String.format(template, name));
    }
}

//Reçois des infos http et en envoie, c'est magique

//@RequestMapping("/hi/name/{name}/lastname/{lastname}")
// public Greeting hi(@PathVariable(value="name") String name, @PathVariable(value = "lastname") String lastname) {
// return new Greeting(1, "hi" + name);
//}
//}