object PolynomialFeatures {

  def main(args: Array[String]): Unit = {

    // Input data
    val numbers = List(1, 2, 3)

    // Polynomial degree
    val degree = 3

    println("Input Data:")
    println(numbers)

    println()
    println("Polynomial Features up to Degree 3:")

    // Generate polynomial features
    val polynomialFeatures = numbers.flatMap { number =>
      (1 to degree).map { power =>
        Math.pow(number, power).toInt
      }
    }

    println(polynomialFeatures)

    println()
    println("Detailed Polynomial Features:")

    numbers.foreach { number =>
      val features = (1 to degree).map { power =>
        Math.pow(number, power).toInt
      }

      println(s"$number -> ${features.mkString(", ")}")
    }
  }
}