package guardPatterns

// Case class that represents an item with name and price
// Demonstrates product types - combines multiple values in a structure
case class Item(name: String, price: Double)

// Sealed trait defines a sum type with multiple variants
// Each category represents a different item classification
sealed trait ItemCategory
case class Cheap(item: Item) extends ItemCategory           // Cheap item
case class ModeratelyPriced(item: Item) extends ItemCategory // Moderately priced item
case class Expensive(item: Item) extends ItemCategory       // Expensive item
case class Unknown(item: Item) extends ItemCategory         // Item of unknown category

/**
 * Function that categorizes an item based on its price using guard patterns
 * Guards (if) allow adding extra conditions to matching patterns
 * 
 * Pattern matching with guards:
 * - case pattern if condition => result
 * - Allows conditional logic within pattern matching
 * - More expressive than simple pattern matching
 */
def categorizeItem(item: Item): ItemCategory = {
  item match {
    // Guard pattern: extracts fields AND checks condition
    case Item(n, p) if p < 10.0                => Cheap(item)
    // Multiple conditions can be combined with &&
    case Item(n, p) if p >= 10.0 && p <= 100.0 => ModeratelyPriced(item)
    case Item(n, p) if p > 100.0               => Expensive(item)
    // Wildcard _ captures any case not handled above
    case _                                     => Unknown(item)
  }
}

/**
 * Main function that demonstrates the use of guard patterns
 * Tests different price ranges to show how guards work
 */
def main(args: Array[String]): Unit = {
  // Test with cheap item (< 10.0)
  println(
    categorizeItem(Item("Pen", 1.50))
  ) // Output: Cheap(Item(Pen,1.5))
  
  // Test with moderately priced item (>= 10.0 && <= 100.0)
  println(
    categorizeItem(Item("Book", 25.00))
  ) // Output: ModeratelyPriced(Item(Book,25.0))
  
  // Test with expensive item (> 100.0)
  println(
    categorizeItem(Item("Laptop", 1200.00))
  ) // Output: Expensive(Item(Laptop,1200.0))
}
