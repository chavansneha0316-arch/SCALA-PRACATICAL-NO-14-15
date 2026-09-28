import scala.util.Random

object TimeSeriesAnalysis {

  def main(args: Array[String]): Unit = {

    // Generate synthetic daily sales data for 30 days
    val random = new Random(42)

    val salesData = (1 to 30).map { day =>
      val sales = 1000 + random.nextInt(501)
      (day, sales)
    }

    println("Daily Sales Time Series")
    println("-----------------------")

    salesData.foreach {
      case (day, sales) =>
        println(s"Day $day : Rs. $sales")
    }

    // Extract sales values
    val sales = salesData.map(_._2)

    // Basic time series analysis
    val totalSales = sales.sum
    val averageSales = sales.sum.toDouble / sales.length
    val minimumSales = sales.min
    val maximumSales = sales.max

    val minDay = salesData.minBy(_._2)._1
    val maxDay = salesData.maxBy(_._2)._1

    println()
    println("Basic Time Series Analysis")
    println("--------------------------")
    println(f"Total Sales   : Rs. $totalSales")
    println(f"Average Sales : Rs. $averageSales%.2f")
    println(s"Minimum Sales : Rs. $minimumSales on Day $minDay")
    println(s"Maximum Sales : Rs. $maximumSales on Day $maxDay")

    // Compare first half and second half
    val firstHalf = sales.take(15)
    val secondHalf = sales.drop(15)

    val firstAverage = firstHalf.sum.toDouble / firstHalf.length
    val secondAverage = secondHalf.sum.toDouble / secondHalf.length

    println()
    println("Trend Analysis")
    println("--------------")
    println(f"First 15 Days Average  : Rs. $firstAverage%.2f")
    println(f"Last 15 Days Average   : Rs. $secondAverage%.2f")

    if (secondAverage > firstAverage) {
      println("Trend: Sales increased in the second half.")
    } else if (secondAverage < firstAverage) {
      println("Trend: Sales decreased in the second half.")
    } else {
      println("Trend: Sales remained approximately stable.")
    }
  }
}