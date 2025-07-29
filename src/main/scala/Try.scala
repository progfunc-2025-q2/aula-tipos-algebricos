package tryExample 

import scala.util.{Try, Success, Failure}

// Try is a monad in Scala's standard library for error handling
// It's a sum type with two possible values: Success[T] or Failure[T]
// Try automatically catches exceptions and wraps them in Failure
// This allows for safe operations that might throw exceptions
def divide(a: Int, b: Int): Try[Int] = Try {
  a / b  // Division by zero will be caught and wrapped in Failure
}

@main def run = {
    // Success case - normal division
    println(divide(10, 2))   // Output: Success(5)
    
    // Failure case - division by zero throws ArithmeticException
    // Try catches the exception and wraps it in Failure
    println(divide(10, 0))   // Output: Failure(java.lang.ArithmeticException: / by zero)
    
    // Success case with negative result
    println(divide(10, -2))  // Output: Success(-5)
}