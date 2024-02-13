# Rust

This is notes about things specific to rust and things and that not needed to be memorized.

Everything is either a statement or an Expression.
- Expressions return a value, and statements do not


## [Attributes](https://doc.rust-lang.org/rust-by-example/attribute.html)
- Conditional compilation of code
- set crate name, version and type
- Disable lint warnings
- enable compiler features(macros, globs, imports etc)
- link to a foreign library
- mark functions as unit tests
- mark functions that will be part of a benchmark
- attribute like macros(API's, routes or other macros)
```
#[allow(dead_code)] // is an attribute that disables the `dead_code` lint
#![crate_type = "lib"] // This crate is a library
#![crate_name = "rary"] // The library is named "rary"
#[cfg(not(target_os = "linux"))] // And this function only gets compiled if the target OS is *not* linux
#[derive(Debug)] // Clone,Copy,Debug,Default,Eq,Hash,Ord,PartialEq,PartialOrd
struct Foo;
```

## Notes
To optimize speed, rust ensures size of data to be known at compile time. This is so that data can be added to stack rather than have the data in heap and pointer to it. And for speed, the code is translated to machine code. Which means rather than having a memory managed environment, the compiler ensures the developer uses the best combination of data for efficiency and introduces the concept of ownership and lifetimes to ensure the developer knows the exact lifecycle. 

Mutability is a property of either a borrow (&mut) or a binding (let mut).

- [Ownership](https://doc.rust-lang.org/book/ch04-01-what-is-ownership.html)
    
    You may have one or the other of these two kinds of borrows, but not both at the same time:

        one or more references (&T) to a resource,
        exactly one mutable reference (&mut T).
- [Lifetimes](https://web.mit.edu/rust-lang_v1.25/arch/amd64_ubuntu1404/share/doc/rust/html/book/first-edition/lifetimes.html)

    Lending out a reference to a resource that someone else owns can be complicated. For example, imagine this set of operations:

        - I acquire a handle to some kind of resource.
        - I lend you a reference to the resource.
        - I decide I’m done with the resource, and deallocate it, while you still have your reference.
        - You decide to use the resource.

Generics - Option<T>

[Traits](https://web.mit.edu/rust-lang_v1.25/arch/amd64_ubuntu1404/share/doc/rust/html/book/first-edition/drop.html)


## Closures
Is useful to wrap up a function and free variables for better clarity and reuse.
- let plus_one = |x: i32| x + 1;

We can force our closure to take ownership of its environment with the move keyword:
- let owns_num = move |x: i32| x + num;

## Crates and modules
```
mod english;
The declaration tell Rust to look for
either src/english.rs or src/english/mod.rs
```
[Un-Safe Rust](https://web.mit.edu/rust-lang_v1.25/arch/amd64_ubuntu1404/share/doc/rust/html/book/first-edition/unsafe.html)

Heap : In Rust, you can allocate memory on the heap with the Box<T> type. Here’s an example:
```
fn main() {
    let x = Box::new(5);
    let y = 42;
}
```

