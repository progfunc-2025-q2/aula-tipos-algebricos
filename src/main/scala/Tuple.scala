package tuple

// Tuples are immutable data structures that can hold multiple values of different types
// They are product types - algebraic data types that combine multiple values
// Product types are types that have multiple components, called fields or elements
// Algebraic data types are types defined by a combination of other types, using products and sums

// A 2-tuple (pair) representing a point in 2D space
// Type: (Double, Double)
// Syntax: (element1, element2)
// Access: ._1, ._2, ... (1-indexed)
val point = (3.0, 4.0)

// A 3-tuple with mixed types: Int, String, Boolean
// Type: (Int, String, Boolean)
// Syntax: (element1, element2, element3)
// Access: ._1, ._2, ._3 (1-indexed)
val mixedTuple = (42, "Hello", true)

@main def testPoint = {
    // Accessing tuple elements using ._1, ._2, etc. (1-indexed)
    println(s"Point coordinates: x = ${point._1}, y = ${point._2}")
    
    // Using tuple values in calculations
    // Demonstrating how to use tuple elements in expressions
    println(s"Distance from origin: ${math.sqrt(point._1 * point._1 + point._2 * point._2)}")

    // Tuples are immutable - we create a new tuple instead of modifying the original
    // Showing immutability by creating an updated tuple
    val updatedPoint = (point._1 + 1, point._2 + 1)
    println(s"Updated Point coordinates: x = ${updatedPoint._1}, y = ${updatedPoint._2}")
   
}

@main def testMixedTuple = {
    // Demonstrating mixed-type tuple access
    println(s"Mixed Tuple: ${mixedTuple._1}, ${mixedTuple._2}, ${mixedTuple._3}")
    
    // Runtime type information for each element
    // Shows that tuples can contain heterogeneous types
    // Demonstrating how to get the class name of each element's type
    println(s"Type of first element: ${mixedTuple._1.getClass.getSimpleName}")
    println(s"Type of second element: ${mixedTuple._2.getClass.getSimpleName}")
    println(s"Type of third element: ${mixedTuple._3.getClass.getSimpleName}")
}