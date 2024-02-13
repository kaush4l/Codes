// [attributes](https://doc.rust-lang.org/rust-by-example/attribute.html)
// allow(dead_code) to suppress the warning 

// Using externation crate rand
// extern crate rand;

// Use keyword to bring the specific traits into local scope
// use rand::Rng;
use std::fmt::Debug;

// fn main() - the start point of the program
#[allow(dead_code)]
fn main() {
    // variable declaration and binding
    // The compiler infers the type of the variable from the value
    let (x, y) = (1, 2);
    
    // variable declaration with explicit type
    let z: i32 = 3;

    // Supported types
    // u, i ,f - unsigned, signed, float
    // 8, 16, 32, 64 - bit size
    // isize, usize - pointer size
    // i8,i16,i32,i64,u8,u16,u32,u64,isize,usize,f32,f64

    // All varaibles are immutable and constant by default
    // To make a variable mutable, use the mut keyword
    let mut a = 5;
    a = 6;

    // Un-initialized variables are not allowed. Will throw a compile time error
    let b: i32;
    {
        // Shadowing - Re-declaring a variable with the same name
        a = 7;
    }
    // a is 6 again

    type Name = String;

    let type_name: Name = "Hello".to_string();
    
    let add_fn : fn(i32) -> i32 = add_one;
    println!("add_fn(5) = {}", add_fn(5));

    let arr = [0, 1, 2, 3, 4]; // arr: [i32; 5]
    let complete = &arr[..]; // A slice containing all of the elements in `arr`.
    let middle = &arr[1..4]; // A slice of `arr`: only the elements `1`, `2`, and `3`.

    // Tuple
    let tup: (i32, &str) = (1, "hello");

    let ifcondition = 5;

    // if-else
    if ifcondition == 5 {
        println!("ifcondition is five!");
    } else if ifcondition == 6 {
        println!("ifcondition is six!");
    } else {
        println!("ifcondition is not five or six :(");
    }

    // loop
    let mut counter = 0;
    let result = loop {
        counter += 1;
        if counter == 10 {
            break counter * 2;
        }
    };

    let mut done = false; // mut done: bool
    // while
    while !done {
        if true {
            done = true;
        }
    }

    // for
    for (x = 0; x < 10; x++) {
        printf( "%d\n", x );
    }
    for x in 0..10 {
        println!("{}", x); // x: i32
    }
    for (index, value) in (5..10).enumerate() {
        println!("index = {} and value = {}", index, value);
    }

    let mut v = vec![1, 2, 3, 4, 5]; // v: Vec<i32>
    for i in &v {
        println!("A reference to {}", i);
    }
    for i in &mut v {
        println!("A mutable reference to {}", i);
    }
    for i in v {
        println!("Take ownership of the vector and its element {}", i);
    }

    // match
    let x = 1;
    match x {
        e @ 1 ... 5 => println!("got a range element {}", e),
        6 | 7 => println!("six or seven"),
        8 => println!("eight"),
        _ => println!("anything"),
    }

    // Reference and mutable reference // Borrowing
    fn foo(v1: &Vec<i32>, v2: &mut Vec<i32>) -> i32 {
        // Do stuff with `v1` and `v2`.
        // Return the answer.
        42
    }
    let v1 = vec![1, 2, 3];
    let v2 = vec![1, 2, 3];
    let answer = foo(&v1, &v2);

    let stat: &'static str = "Hello, world.";

    struct Electron {} // Use empty braces...
    struct Proton;     // ...or just a semicolon.

    // Use the same notation when creating an instance.
    let x = Electron {};
    let y = Proton;
    // let z = Electron; // Error
}

// Function declaration
fn add_one(x: i32) -> i32 {
    x + 1 // No semicolon means return
    // return x + 1; // This is also valid
}

// Diverges are Function with no return value
fn diverges() -> ! {
    panic!("This function never returns!");
}

// <'a> is a lifetime parameter
fn skip_prefix<'a, 'b>(line: &'a str, prefix: &'b str) -> &'a str {
    // ...
}
struct Foo<'a> {
    x: &'a i32,
}
impl<'a> Foo<'a> {
    fn x(&self) -> &'a i32 { self.x }
}

// Structs, Traits, impl
struct Circle {
    x: f64,
    y: f64,
    radius: f64,
}
trait HasArea {
    fn area(&self) -> f64;
}
impl HasArea for Circle {
    fn area(&self) -> f64 {
        std::f64::consts::PI * (self.radius * self.radius)
    }
}

enum Message {
    Quit,
    ChangeColor(i32, i32, i32),
    Move { x: i32, y: i32 },
    Write(String),
}

fn takes_anything<T>(x: T) {
    // Do something with `x`.
}

// Traits
fn foo<T: Clone, K: Clone + Debug>(x: T, y: K) {
    x.clone();
    y.clone();
    println!("{:?}", y);
}

fn bar<T, K>(x: T, y: K) where T: Clone, K: Clone + Debug {
    x.clone();
    y.clone();
    println!("{:?}", y);
}

// Static dispatch
// The following code will generate a function for each type
// fn do_something_i32(x: i32) {
// fn do_something_f64(x: f64) {
fn do_something<T: Foo>(x: T) {
    x.method();
}
// Rust provides dynamic dispatch through a feature called ‘trait objects’. Trait objects, like &Foo or Box<Foo>, are normal values that store a value of any type that implements the given trait, where the precise type can only be known at runtime.