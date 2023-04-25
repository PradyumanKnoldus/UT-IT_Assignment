
package com.knoldus.validator

import com.knoldus.models.{Company, Employee}
import com.knoldus.db.CompanyReadDto
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeValidatorSpec extends AnyFlatSpec {
  val employeeValidator = new EmployeeValidator

  "EmployeeValidator" should "return true for a valid employee belonging to an existing company" in {
    val validEmployee = Employee("Pradyuman", "Singh", 23, 60000.0, "Software Engineer", "Knoldus", "pradyuman.singh@knoldus.com")
    val companyReadDto = new CompanyReadDto
    val knoldusCompany = Company("Knoldus", "knoldus@gmail.com", "Noida")
    assert(companyReadDto.getCompanyByName("Knoldus") === Some(knoldusCompany))
    assert(employeeValidator.employeeIsValid(validEmployee) === true)
  }

  it should "return false for an employee belonging to a non-existent company" in {
    val invalidEmployee = Employee("Khan", "Singh", 25, 50000.0, "Software Engineer", "Amazon", "khan.singh@gmail.com")
    assert(employeeValidator.employeeIsValid(invalidEmployee) === false)
  }

  it should "return false for an employee with an invalid email id" in {
    val invalidEmployee = Employee("Khan", "Singh", 25, 50000.0, "Software Engineer", "Knoldus", "khan.singh@.com")
    assert(employeeValidator.employeeIsValid(invalidEmployee) === false)
  }
}

