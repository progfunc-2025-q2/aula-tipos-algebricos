package result

// Sum types (also called union types) represent a choice between different alternatives
// sealed trait ensures all implementations are in this file (closed hierarchy)
// Result[T] is a generic sum type with three possible variants
sealed trait Result[T]

// Case classes implementing the sealed trait - these are the sum type variants
// Success represents a successful operation with a value
case class Success[T](value: T) extends Result[T]
// Failure represents a failed operation with an error message
case class Failure[T](error: String) extends Result[T]
// Pending represents an operation that is still in progress
case class Pending[T](message: String) extends Result[T]

// Function demonstrating explicit error handling without exceptions
// Returns Success for valid operations, Failure for invalid ones
def divide(a: Int, b: Int): Result[Int] = {
  if (b == 0) Failure("Division by zero")  // Explicit error case
  else Success(a / b)                      // Success case
}

@main def testResult = {
    // Testing both success and failure cases
    println(divide(10, 2))  // Output: Success(5)
    println(divide(10, 0))  // Output: Failure(Division by zero)
}

// Pattern matching function - exhaustive matching on all variants
// Pattern matching is the primary way to work with sum types
def handleResult[T](result: Result[T]): String = result match {
  case Success(value) => s"Operação bem-sucedida: $value"
  case Failure(error) => s"Operação falhou: $error"
  case Pending(message) => s"Operação pendente: $message"
  case _ => "Resultado desconhecido"  // Catch-all case (shouldn't happen with sealed traits)
}

@main def runResultExample(): Unit = {
  // Creating instances of each variant
  val successResult: Result[Int] = Success(42)
  val failureResult: Result[Int] = Failure("Erro desconhecido")
  val pendingResult: Result[Int] = Pending("Aguardando confirmação")

  // Pattern matching handles each case appropriately
  println(handleResult(successResult))   // Output: Operação bem-sucedida: 42
  println(handleResult(failureResult))   // Output: Operação falhou: Erro desconhecido
  println(handleResult(pendingResult))   // Output: Operação pendente: Aguardando confirmação
  println(handleResult(null))            // Output: Resultado desconhecido
}
