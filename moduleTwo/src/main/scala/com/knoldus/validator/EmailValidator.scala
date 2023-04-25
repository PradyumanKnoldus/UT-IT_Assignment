
package com.knoldus.validator

import com.typesafe.scalalogging.Logger

class EmailValidator {
  private val logger: Logger = Logger(getClass)

  // Define a function to check if an Email is valid
  def emailIdIsValid(email: String): Boolean = {
    val atIndex = email.indexOf("@")
    val dotIndex = email.lastIndexOf(".")
    val isValid = (atIndex > 0) && (dotIndex > (atIndex + 1)) && (dotIndex < email.length - 1) && (atIndex == email.lastIndexOf("@")) && (email.length - dotIndex >= 3)

    if (!isValid) {
      logger.warn(s"Invalid email format: $email")
    }
    isValid
  }
}
