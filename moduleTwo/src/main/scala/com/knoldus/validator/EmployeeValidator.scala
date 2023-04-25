
package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Employee
import com.typesafe.scalalogging.Logger

class EmployeeValidator {
  private val logger: Logger = Logger(getClass)

  // Define a function to check if an Employee is valid
  def employeeIsValid(employee: Employee): Boolean = {
    val companyReadDto = new CompanyReadDto
    val emailValidator = new EmailValidator

    companyReadDto.getCompanyByName(employee.companyName) match {
      case Some(_) =>
        val isValid = emailValidator.emailIdIsValid(employee.emailId)
        if (!isValid) {
          logger.warn(s"Invalid email format for employee ${employee.firstName} ${employee.lastName}")
        }
        isValid
      case None =>
        logger.warn(s"Invalid company name ${employee.companyName} for employee ${employee.firstName} ${employee.lastName}")
        false
    }
  }
}
