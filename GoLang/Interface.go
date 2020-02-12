package main

import (
  "fmt"
  "math"
)

func main () {
   Rect := Rectangle{10, 5}
   Circ := Circle{4}
   fmt.Println(getArea(Rect))
   fmt.Println(getArea(Circ))
}

type Shape interface {
    area() float64
}

func getArea(shape Shape) float64{
    return shape.area()
}

type Rectangle struct {
    width float64
    height float64
}

type Circle struct {
    radius float64
}

func (rect *Rectangle) area() float64 {
    return rect.width * rect.height
}

func (circ *Circle) area() float64 {
    return math.Pi * math.Pow(circ.radius, 2)
}
