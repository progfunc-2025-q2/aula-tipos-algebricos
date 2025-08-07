package patternFlavors

// Case class that represents a person
// Demonstrates simple product type with two fields
case class Person(name: String, age: Int)

/**
 * Demonstrates variable destructuring
 * Extracts fields from a case class directly into variables
 */
@main def variableDestructuring(): Unit = {
  val person = Person("Alice", 30)
  
  // Destructuring: extracts fields from the case class
  // Creates variables 'name' and 'age' with the corresponding values
  val Person(name, age) = person
  println(s"Name: $name, Age: $age")
}

// Sum type that represents different geometric shapes
// Sealed trait ensures that all cases are known at compile time
sealed trait Shape
case class Circle(radius: Double) extends Shape
case class Rectangle(width: Double, height: Double) extends Shape
case class Triangle(base: Double, height: Double) extends Shape

/**
 * Function that calculates area using exhaustive pattern matching
 * Demonstrates how pattern matching ensures treatment of all cases
 * 
 * @param shape The geometric shape to calculate the area for
 * @return Option[Double] with the calculated area or None for unhandled cases
 */
def area(shape: Shape): Option[Double] = shape match {
  // Extracts the radius and calculates circle area
  case Circle(radius)           => Some(Math.PI * radius * radius)
  // Extracts width and height to calculate rectangle area
  case Rectangle(width, height) => Some(width * height)
  // Extracts base and height to calculate triangle area
  case Triangle(base, height)   => Some(0.5 * base * height)
  // Default case (wildcard) for unhandled types
  case _                        => None
}

/**
 * Demonstrates pattern matching with collections and sum types
 * Processes a list of geometric shapes
 */
@main def runAreaCalculations(): Unit = {
  // Heterogeneous list of different shapes
  val shapes: List[Shape] = List(
    Circle(5),
    Rectangle(4, 6),
    Triangle(3, 7)
  )

  // Processes each shape using pattern matching
  shapes.foreach { shape =>
    val result = area(shape)
    // Option.getOrElse provides default value for None cases
    println(s"Área: ${result.getOrElse("Desconhecida")}")
  }
}

/**
 * Another demonstration of parameter destructuring
 * Shows the same technique as variableDestructuring
 */
@main def parameterDestructuring(): Unit = {
  val person = Person("Alice", 30)
  val Person(name, age) = person
  println(s"Name: $name, Age: $age")
}

/**
 * Function that demonstrates pattern matching with lists
 * Shows specific patterns for recursive data structures
 * 
 * @param list List of integers to process
 * @return String describing the structure of the list
 */
def processList(list: List[Int]): String = list match {
  // Nil represents empty list
  case Nil => "Lista vazia"
  // :: (cons) separates head from tail
  // head :: tail destructures the list into first element and rest
  case head :: tail => s"Cabeça: $head, Resto: ${tail.mkString(", ")}"
}

/**
 * Demonstrates pattern matching with lists
 * Shows how to work with recursive data structures
 */
@main def runListExample(): Unit = {
  val list1 = List(1, 2, 3)
  val list2 = List.empty[Int]

  println(processList(list1)) // Cabeça: 1, Resto: 2, 3
  println(processList(list2)) // Lista vazia
}

// Nested case classes to demonstrate deep pattern matching
case class Address(street: String, city: String)
case class Customer(name: String, address: Address)

/**
 * Function that demonstrates nested pattern matching
 * Extracts values from nested data structures in a single expression
 * 
 * @param customer Customer with nested address
 * @return Formatted string with customer information
 */
def customerInfo(customer: Customer): String = customer match {
  // Nested pattern matching: extracts fields from Customer AND Address
  // Customer(name, Address(street, city)) destructures two levels
  case Customer(name, Address(street, city)) =>
    s"Nome: $name\nEndereço: $street, $city"
}

/**
 * Demonstrates pattern matching with nested structures
 * Shows how to extract values from multiple levels of case classes
 */
@main def runCustomerExample(): Unit = {
  val customer = Customer("Alice", Address("123 Main St", "Wonderland"))
  println(customerInfo(customer))
}