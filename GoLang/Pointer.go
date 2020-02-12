package main

import "fmt"

func main() {
    x := 10
    noPointer(x) // Just calls the function and this fucntion does nothing
    fmt.Println(x)
    pointer(&x) // Sending pointer to the memory location so any operation on the variable is saved in the memory
    fmt.Println(x)
}

func noPointer(x int) {
    x = 7 // Local variable. No accessible outside this fiunction
}

func pointer(x *int) {
    *x = 7 // Changes the memory location of the variable being sent
}
