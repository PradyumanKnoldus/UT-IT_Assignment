
package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.typesafe.scalalogging.Logger

class CompanyValidator {
  private val logger: Logger = Logger(getClass)

  // Define a function to check if a company is valid
  def companyIsValid(company: Company): Boolean = {
    val companyReadDto = new CompanyReadDto
    val emailValidator = new EmailValidator

    if (companyReadDto.getCompanyByName(company.name).isDefined) {
      logger.warn(s"Duplicate company ${company.name}")
      false
    } else {
      val isEmailValid = emailValidator.emailIdIsValid(company.emailId)
      if (!isEmailValid) {
        logger.warn(s"Invalid email ${company.emailId}")
      }
      isEmailValid
    }
  }
}
