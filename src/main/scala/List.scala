// Custom implementation of a linked list using algebraic data types
// This demonstrates recursive data structures and sum types

// MyList[+A] is a covariant generic type representing a list of elements of type A
// The + indicates covariance: if B is a subtype of A, then MyList[B] is a subtype of MyList[A]
sealed trait MyList[+A]

// Base case: empty list
// MyNil represents the end of the list (no elements)
// extends MyList[Nothing] - Nothing is the bottom type (subtype of everything)
case object MyNil extends MyList[Nothing]

// Recursive case: non-empty list
// Cons (construct) contains a head element and a tail (rest of the list)
// This creates a recursive structure: head :: tail
case class Cons[A](head: A, tail: MyList[A]) extends MyList[A]

// Recursive function to sum all integers in the list
// Pattern matching on the structure of the list
def sum(list: MyList[Int]): Int = list match {
  case MyNil => 0                           // Base case: empty list sums to 0
  case Cons(head, tail) => head + sum(tail) // Recursive case: head + sum of tail
}

// Recursive function to concatenate two lists
// Generic function works with any type A
def concat[A](list1: MyList[A], list2: MyList[A]): MyList[A] = list1 match {
  case MyNil => list2                                    // Base case: empty + list2 = list2
  case Cons(head, tail) => Cons(head, concat(tail, list2)) // Recursive: head :: (tail ++ list2)
}

@main def runListSum(): Unit = {
  // Creating a list: 1 :: 2 :: 3 :: Nil
  // This represents the list [1, 2, 3]
  val numbers: MyList[Int] = Cons(1, Cons(2, Cons(3, MyNil)))
  println(s"Soma: ${sum(numbers)}")  // Output: Soma: 6
}

@main def runListConcat(): Unit = {
  // Creating two separate lists
  val list1: MyList[Int] = Cons(1, Cons(2, MyNil))        // [1, 2]
  val list2: MyList[Int] = Cons(3, Cons(4, MyNil))        // [3, 4]
  
  // Concatenating lists using recursive function
  val concatenated: MyList[Int] = concat(list1, list2)    // [1, 2, 3, 4]
  println(s"Concatenado: $concatenated")  // Output: Concatenado: Cons(1,Cons(2,Cons(3,Cons(4,MyNil))))
}