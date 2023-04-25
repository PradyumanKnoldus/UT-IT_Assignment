
package com.knoldus

import com.typesafe.scalalogging.Logger

import scala.util.{Failure, Success, Try}

class DuplicateElementsChecker {
  private val logger: Logger = Logger(getClass)

  // This method checks if a given list contains any duplicate elements.
  // It returns true if the list has duplicates, false otherwise.
  def hasDuplicates[A](inputList: List[A]): Boolean = {
    Try {
      val distinctList = inputList.distinct
      inputList != distinctList
    } match {
      case Success(result) =>
        if (result) {
          logger.info("\nFound duplicate elements in list: {}", inputList)
          true
        } else {
          logger.info("\nNo duplicate elements found in list: {}", inputList)
          false
        }
      case Failure(exception) =>
        logger.error(s"An error occurred while checking for duplicates in list: $inputList", exception)
        false
    }
  }
}
