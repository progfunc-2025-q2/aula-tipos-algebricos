package unapply

/**
 * Point2 class that represents a 2D point
 * Unlike case class, it's a regular class that requires manual implementation
 * of apply/unapply to work with pattern matching
 */
class Point2(val x: Double, val y: Double)

/**
 * Companion object for Point2
 * Manually implements what case classes do automatically
 */
object Point2 {
  /**
   * Apply method: constructor that allows creating instances without 'new'
   * Enables syntax: Point2(3.0, 4.0) instead of new Point2(3.0, 4.0)
   */
  def apply(x: Double, y: Double): Point2 = new Point2(x, y)

  /**
   * Unapply method: custom extractor for pattern matching
   * - Receives a Point2 instance
   * - Returns a tuple with the extracted values
   * - Allows destructuring: val Point2(x, y) = point
   * 
   * Note: Case classes generate this method automatically
   */
  def unapply(point: Point2): (Double, Double) = (point.x, point.y)
}

/**
 * Main function that demonstrates the use of custom extractors
 * Shows how apply/unapply work together to create convenient syntax
 */
@main def testPoint2 = {
  // apply is called implicitly here
  val point = Point2(3.0, 4.0)
  
  // unapply is called implicitly for destructuring
  // Extracts the x and y components of the point
  val Point2(x, y) = point

  println(s"Point coordinates: x = $x, y = $y")
  
  // Demonstrates calculation using the extracted values
  println(s"Distance from origin: ${math.sqrt(x * x + y * y)}")

  // Creating a new point using the extracted values
  val updatedPoint = Point2(x + 1, y + 1)
  println(s"Updated Point coordinates: x = ${updatedPoint.x}, y = ${updatedPoint.y}")
}