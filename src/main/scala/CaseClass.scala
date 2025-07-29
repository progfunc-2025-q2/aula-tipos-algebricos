package caseClass

// Case classes are special classes in Scala that provide many useful features automatically:
// - Immutable by default
// - Automatic toString, equals, and hashCode methods
// - Companion object with apply method (no need for 'new')
// - Pattern matching support
// - Copy method for creating modified copies
case class Point(x: Double, y: Double)

@main def testPoint = {
    // Creating case class instances - no 'new' keyword needed
    // The compiler generates a companion object with an apply method
    val p1 = Point(3.0, 4.0)
    val p2 = Point(5.0, 6.0)

    // Automatic toString method provides readable output
    println(p1)  // Output: Point(3.0,4.0)
    
    // Case class parameters are automatically public val fields
    // Direct access to immutable properties
    println(p1.x)  // Output: 3.0
    println(p1.y)  // Output: 4.0
    
    // Structural equality - compares content, not reference
    // Automatic equals method compares all fields
    println(p1 == p2)  // Output: false (different coordinates)

    // Copy method creates a new instance with modified fields
    // Original instance remains unchanged (immutability)
    val p3 = p1.copy(y = 5.0)  // Copy p1 but change y to 5.0

    // Demonstrating immutability - original objects are unchanged
    println(p1)  // Output: Point(3.0,4.0) - unchanged
    println(p2)  // Output: Point(5.0,6.0) - unchanged
    println(p3)  // Output: Point(3.0,5.0) - new instance with modified y
}