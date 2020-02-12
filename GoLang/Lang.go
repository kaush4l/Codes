package main

import (
  "fmt"
  "time"
)

func main() {

    //DATA TYPES
    var str = "String"
    var bool = true     // true | false
    var integer int = 5 // byte | int | float32 | float64 | complex128
    fmt.Println(str , bool, integer)

    //INITIALIZING VARIABLES
    var a, b int = 1, 2
    var (
      c = 3
      d = 4
    )
    e, f := 5, 6
    fmt.Println(a, b, c, d, e, f)

    //SUPPORTED OPERATIONS
    fmt.Println(a + b, c - b, c * d, d / f, e % d) // Arithematic +, -, *, /, %
    fmt.Println(b > a, b < c, d >= c, c <= d, f == e, a != f) //Relational >, <, =, ! and combinations
    fmt.Println(bool && !bool, bool || !bool) // Logical &&, ||, !

    //Go supports POINTERS
    fmt.Println(str) //Variable
    fmt.Println(&str)//Variable location or pointer
    //Why pointer and usage of pointer in Pointer.go

    // Printf fucntion from fmt library
    fmt.Printf("%f \n" , bool) // A custom print function that can be used as -type -arg
    fmt.Printf("%T \n" , bool) // %f = format .3f, %T = type of the variable
    fmt.Printf("%t \n" , bool) // %t = shows us boolean, %d = shows integer
    fmt.Printf("%b \n" , b) // %b = binary of a number
    fmt.Printf("%d \n" , bool) // /n needed as this prints in the same line
    fmt.Printf("%c \n" , 85) // ASCII character
    fmt.Printf("%x \n" , 15) // Hex code
    fmt.Println(time.Now()) // time library provided

    // CONTROL STRUCTURE
    // There is only if loop in GoLang. All variations of loops(do-while, forEach, while) are done using for loop
    for i := 0 ; i < 5; i++ { //For loop
      fmt.Println(i)
    }

    // While loop kind of way
    i:=0
    for i < 10 {
      fmt.Println(i)
      i++
    }

    // DECISION MAKING
    age := 26
    if age > 21 { // If else
      fmt.Println("You are eligible to vote")
    } else {
      fmt.Println("Kid :P")
    }

    switch age { //Switch case
      case 18 : fmt.Println("So it's time to decide!! You got the power to vote!!") // Unline Java, the case has break after all cases.
      case 21 : fmt.Println("Since you can vote, you are now eligible for alcohol :P")  // So if we want the decision making to continue, we use the keyword fallthrough
      case 24 : fmt.Println("Hopefully you are looking for job")
      case 27 : fmt.Println("Are you ready for the next adventure")
      default : fmt.Println("But no matter what, movies and chill!!!")
    }

    // DATA STRUCTURES
    // Arrays
    var array[10] int // or array := []or[...]or[5] {1,2,3,4,5}
    for i :=0; i < 10; i++{
      array[i] = i * 2
    }
    for _, value := range array { // ForEach loop the '_' can be replaced by variable which indicates the index or the count of the loop
      fmt.Println(value) // The element of the array
    }
    fmt.Println(array)

    //Array operations (similar to python)
    slicedArr := array[1:4] // [1, 2, 3] also [:4] or [1:] works
    fmt.Println(slicedArr)
    // Most methods are availale throughout
    // Like make, len, cap. Usage : len(slicedArr), copy(this, tothis), make([]int, 5 ,10), append(arr, values.....)

    // Map is same as HashMap in Java
    Student := make(map[string] int) // make is kind of constructor. In this Sting is the key and int is the value
    Student["Kaushal"] = 95 //Key are specific and if looked for any unavailable key it returns 0 based value of the value\
    fmt.Println(Student)
    fmt.Println(Student["Kaushal"])
    fmt.Println(len(Student)) // 1
    delete(Student, "Kaushal")
    fmt.Println(len(Student)) // 0

    SuperHeros := map[string]map[string]string { // Map inside a map ',' necessary after every inner line
      "Superman" : map[string] string{
        "RealName" : "Clark Kent",
        "SuperPower" : "Pow",
      },
      "Batman" : map[string]string{
        "RealName" : "Bruce Wyne",
        "SuperPower" : "I am Batmannn (Intensifies)",
      },
    }
    fmt.Println(SuperHeros)

    //Functions
    fmt.Println("5! ", rec(5))
    // Simiar to some programs, Go can work with multiple arguments
    fmt.Println(addAll(10, 20, 30, 40, 50))

    // CONTROL STRUCTURES
    // Go specific keywords DEFER, RECOVER, PANIC

    // Defer : defers the execution of the program untill the surrounding program executes to a LIFO stack
    // Typically used in DB or clean up processes

    // Panic : is similar to throwing an exception in other languages. Stop the world execution type.

    // Recover : is used to recover the program from panic. Generally used with defer statement to recover panic

    defer firstRun()
    defer secondRun()
    // Even if both are defered, second prints first because the execution occurs in LIFO

    // Since Go is not strictly orject oriented, it works on something called struct which works like object
    Sherlock := Book{ author: "Author Conan Doyle", title: "The adventures of Sherlock Holmes" }
    // or directly Book{"Author Conan Doyle", "The adventures of Sherlock Holmes"}
    fmt.Println(Sherlock.bookDetails()) // Works because now the method is availble for the structure
}

// Functions
func rec(a int) int { // signature - name(pram type) returnType
  if(a < 2) {
    return 1
  }
  return a * rec (a - 1) // Recursive function
}

func firstRun () {fmt.Println("FirstRun")}
func secondRun () {fmt.Println("SecondRun")}
func addAll(args ...int) int { // Function to accept variable arguments
  sum := 0
  for _, value := range args {
    sum += value
  }
  return sum
}

type Book struct {
    author string
    title string
}

// func bookDetails(book Book) string { // This is like creating a generic function
func (book *Book) bookDetails() string { // The book *Book is like extending and the fuction is available in the object
    return "The book " + book.title + " is written by " + book.author
}
