
package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class DuplicateElementsCheckerSpec extends AnyFlatSpec {
  "DuplicateElementsChecker" should "return true for list with duplicate elements" in {
    val duplicateElementsChecker = new DuplicateElementsChecker
    val inputList = List(1, 2, 3, 1)
    assert(duplicateElementsChecker.hasDuplicates(inputList))
  }

  it should "return false for list with no duplicate elements" in {
    val duplicateElementsChecker = new DuplicateElementsChecker
    val inputList = List(1, 2, 3, 4)
    assert(!duplicateElementsChecker.hasDuplicates(inputList))
  }

  it should "return true for list with duplicate string elements" in {
    val duplicateElementsChecker = new DuplicateElementsChecker
    val inputList = List("a", "b", "c", "a")
    assert(duplicateElementsChecker.hasDuplicates(inputList))
  }

  it should "return false if the input list is empty" in {
    val duplicateElementsChecker = new DuplicateElementsChecker
    val inputList = List()
    assert(!duplicateElementsChecker.hasDuplicates(inputList))
  }
}

