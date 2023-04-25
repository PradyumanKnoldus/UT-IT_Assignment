
package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class FactorialOfANumberSpec extends AnyFlatSpec {
  "FactorialOfANumber" should "return Left for negative numbers" in {
    assert(FactorialOfANumber.findFactorialOfANumber(-5) == Left("Factorial is Undefined for negative numbers"))
  }

  it should "return Right for non-negative numbers" in {
    assert(FactorialOfANumber.findFactorialOfANumber(0) == Right(BigInt(1)))
    assert(FactorialOfANumber.findFactorialOfANumber(1) == Right(BigInt(1)))
    assert(FactorialOfANumber.findFactorialOfANumber(2) == Right(BigInt(2)))
    assert(FactorialOfANumber.findFactorialOfANumber(5) == Right(BigInt(120)))
    assert(FactorialOfANumber.findFactorialOfANumber(10) == Right(BigInt(3628800)))
  }

}
