
package com.knoldus

import com.typesafe.scalalogging.Logger

import scala.annotation.tailrec

object FactorialOfANumber {
  private val logger: Logger = Logger(getClass)

  // A tail recursive function to find the factorial of a number
  def findFactorialOfANumber(number: Int): Either[String, BigInt] = {
    if (number < 0) {
      Left("Factorial is Undefined for negative numbers")
    } else {
      @tailrec
      def factorialHelper(number: Int, accumulator: BigInt = 1): BigInt = {
        if (number <= 1) {
          accumulator
        } else {
          factorialHelper(number - 1, number * accumulator)
        }
      }

      val result = factorialHelper(number)
      logger.info(s"Factorial of $number is $result")
      Right(result)
    }
  }
}
