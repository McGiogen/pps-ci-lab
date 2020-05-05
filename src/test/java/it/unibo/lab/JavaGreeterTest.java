package it.unibo.lab;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class JavaGreeterTest {

  @Test
  public void sayHello() {
    JavaGreeter greeter = new JavaGreeter(); // MyClass is tested

    // assert statements
    assertTrue("Message must start with 'hello' word", greeter.sayHello().toLowerCase().startsWith("hello"));
    assertTrue(1==2);
  }
}
