
package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.typesafe.scalalogging.Logger

class UserValidator {
  private val logger: Logger = Logger(getClass)

  // Define a function to check if an User is valid
  def userIsValid(user: User): Boolean = {
    val companyReadDto = new CompanyReadDto
    val emailValidator = new EmailValidator

    companyReadDto.getCompanyByName(user.companyName) match {
      case Some(_) =>
        val isValid = emailValidator.emailIdIsValid(user.emailId)
        if (!isValid) {
          logger.warn(s"Invalid email format for user ${user.firstName} ${user.lastName}")
        }
        isValid
      case None =>
        logger.warn(s"Invalid company name ${user.companyName} for user ${user.firstName} ${user.lastName}")
        false
    }
  }
}
