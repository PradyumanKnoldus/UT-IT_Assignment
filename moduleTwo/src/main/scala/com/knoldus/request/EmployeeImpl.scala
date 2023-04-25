
package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import com.typesafe.scalalogging.Logger

class EmployeeImpl(employeeValidator: EmployeeValidator) {
  private val logger: Logger = Logger(getClass)

  // Define a function to create an employee
  def createEmployee(employee: Employee): Option[String] = {
    if (employeeValidator.employeeIsValid(employee)) {
      logger.info(s"Employee ${employee.emailId} created successfully")
      Option(employee.emailId)
    } else {
      logger.warn(s"Invalid employee ${employee.emailId}")
      None
    }
  }
}
