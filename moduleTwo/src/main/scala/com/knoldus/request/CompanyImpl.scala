
package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import com.typesafe.scalalogging.Logger

class CompanyImpl(companyValidator: CompanyValidator) {
  private val logger: Logger = Logger(getClass)

  // Define a function to create a company
  def createCompany(company: Company): Option[String] = {
    if (companyValidator.companyIsValid(company)) {
      logger.info(s"/nCreating company ${company.name}")
      Option(company.name)
    } else {
      logger.warn(s"/nInvalid company ${company.name}")
      None
    }
  }
}
