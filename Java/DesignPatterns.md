# Design Patterns

Patterns to tackle commonly faced coding problems. These are different from algorithms and are used to make the code structure more efficient and reusable. So design patterns are divifed into 3 categories based on the intent or the purpose.

## Creational Pattern
Provides object creation mechanism to increase flexibility and reusability of the code.
```
Factory method, Abstract factory, Builder, Prototype, Singleton
```

## Structural Pattern
Explain how to assemble objects and classes into larger structures while keeping structure flexible and efficient
```
Adapter. Bridge, Composite, Decorator, Facade, Flyweight, Proxy
```

## Behavioral Pattern
Takes care of effective communication and the assignment of responsibilities between object
```
Chain of responsibility, Command, Iteratorm, Mediator, Memento, Observer, State, Strategy, Template, Visitor
```


---

# Creational Patterns
## Factory Pattern:
Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
Eg: java.util.Calendar.getInstance()

```
interface Vechicle {// metods to implement}
class Car implements Vechicle {// Implements methods}
class Bike implement Vechilce (// Implements methods)
class VechicleFactory {
    getInstance() {
        if(Business logic) {
            return new Car();
        } else {
            return new Bike();
        }
    }
}
```

## Prototype Pattern:
Prototype is a creational design pattern that allows cloning objects, even complex ones, without coupling to their specific classes.

Eg: java.lang.Object.clone()

```
interface Person {
    Person clone();
}

class Tom implements Person {
    private final String NAME = "Tom";

    @Override
    public Person clone() {
        return new Tom();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Dick implements Person {
    private final String NAME = "Dick";

    @Override
    public Person clone() {
        return new Dick();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Harry implements Person {
    private final String NAME = "Harry";

    @Override
    public Person clone() {
        return new Harry();
    }

    @Override
    public String toString() {
        return NAME;
    }
}

class Factory {
    private static final Map<String, Person> prototypes = new HashMap<>();

    static {
        prototypes.put("tom", new Tom());
        prototypes.put("dick", new Dick());
        prototypes.put("harry", new Harry());
    }

    public static Person getPrototype(String type) {
        try {
            return prototypes.get(type).clone();
        } catch (NullPointerException ex) {
            System.out.println("Prototype with name: " + type + ", doesn't exist");
            return null;
        }
    }
}

public class PrototypeFactory {
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String type : args) {
                Person prototype = Factory.getPrototype(type);
                if (prototype != null) {
                    System.out.println(prototype);
                }
            }
        } else {
            System.out.println("Run again with arguments of command string ");
        }
    }
}

```
```
>java PrototypeFactory tom dick jack

Tom
Dick
Prototype with name: jack, doesn't exist

```
## [Singleton Pattern](https://refactoring.guru/design-patterns/singleton):
Singleton is a creational design pattern, which ensures that only one object of its kind exists and provides a single point of access to it for any other code.
Eg: java.lang.getRuntime(), getSecuritymanager()

This can also be said as static creation method, which returns the same cached object.

There are different types of this creation. 
### Native Singleton (Single threaded)
- Make the class final to stop extending and creating a child class. 
- Make a static instance variable and getInstance method so that they are loaded first and keeping only one instance in memory
```
public final class Singleton {
    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
```
```
public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
}
```
Result:

FOO

FOO

But this behaves in correctly when using multi threaded program. This is because when creating of new object both threads can call the getInstance simultaneously and thery by producing duplicate.

### For multithreaded:
```
public class DemoMultiThread {
    public static void main(String[] args) {
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start(); // thread.sleep makes sure another thread can call the mthod before object is initalized
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}
```
RESULT:

FOO

BAR

### Thread safe 
```
public final class Singleton {
    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        // The approach taken here is called double-checked locking (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instances as a result.
        //
        // It may seem that having the `result` variable here is completely
        // pointless. There is, however, a very important caveat when
        // implementing double-checked locking in Java, which is solved by
        // introducing this local variable.
        //
        // You can read more info DCL issues in Java here:
        // https://refactoring.guru/java-dcl-issue
        Singleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
```

## [Abstract Factory](https://refactoring.guru/design-patterns/abstract-factory)
This lets us produce group of related objects. Read from the link.

## [Builder Factory](https://refactoring.guru/design-patterns/builder)
This is creation of object step by step. 
We can do builder object.set and set various parameters and upon a final build or get method, run the business logic and return the object that needs to be created.

---
# Structural Design patterns
## Adapter
This is to make incompatable interfaces colloborate.
Eg: java.util.Arrays.asList(), .Collectors.toList(), .Collectors.toSet()

To extend or return different result type that fits into the caller method which makes it easier of adding of new features and developement.

## [Bridge pattern](https://refactoring.guru/design-patterns/bridge/java/example)
Bridge is a structural design pattern that divides business logic or huge class into separate class hierarchies that can be developed independently.
Can become complex to implement but makes code much more structured.

## [Composite pattern](https://refactoring.guru/design-patterns/composite)
Composite is a structural design pattern that allows composing objects into a tree-like structure and work with the it as if it was a singular object.

## [Decorator pattern](https://refactoring.guru/design-patterns/composite) also called wrapper
Decorator is a structural pattern that allows adding new behaviors to objects dynamically by placing them inside special wrapper objects.

## [Facade pattern](https://refactoring.guru/design-patterns/facade/java/example)
Facade is a structural design pattern that provides a simplified (but limited) interface to a complex system of classes, library or framework.
Moving all the dependencies to one place and providing a facade layer on top so that all the complex logic sits behind the facade and will take care of working the products together. 

## Flyweight 
Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.

## [Proxy pattern](https://refactoring.guru/design-patterns/proxy)
Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.

So rather than all object directly accessing the database, proxy provides a layer called proxy

---
# [Behavioral Patterns](https://refactoring.guru/design-patterns/behavioral-patterns)
Read about all from the link above.

## [Chain of responsibility](https://refactoring.guru/design-patterns/chain-of-responsibility/java/example)
Chain of Responsibility is behavioral design pattern that allows passing request along the chain of potential handlers until one of them handles request.
Each steps taking care of its own resposibility. 

Eg: logging in will check DB for user, get authorization level, access and display requested details.

## [Command](https://refactoring.guru/design-patterns/chain-of-responsibility)
Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.

So we can have same action from multiple places so we call same command from multiple places. 

## Iterator
Iterator is a behavioral design pattern that lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.). So it must provide a way to traverse all the elements without repeating the same elements again.

## Mediator
Mediator is a behavioral design pattern that reduces coupling between components of a program by making them communicate indirectly, through a special mediator object.

## Observer
Also known as: Event-Subscriber, Listener
Observer is a behavioral design pattern that allows some objects to notify other objects about changes in their state.

Resources:
- [Link 1](https://refactoring.guru/design-patterns)
- [Link 2](https://sourcemaking.com/design_patterns)

