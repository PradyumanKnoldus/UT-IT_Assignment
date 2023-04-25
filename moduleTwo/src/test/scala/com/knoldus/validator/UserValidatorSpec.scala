
package com.knoldus.validator

import com.knoldus.models.{Company, User}
import com.knoldus.db.CompanyReadDto
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorSpec extends AnyFlatSpec {
  val userValidator = new UserValidator

  "EmployeeValidator" should "return true for a valid employee belonging to an existing company" in {
    val validUser = User("Pradyuman", "Singh", 23, "pradyuman.singh@knoldus.com", "Knoldus")
    val companyReadDto = new CompanyReadDto
    val knoldusCompany = Company("Knoldus", "knoldus@gmail.com", "Noida")
    assert(companyReadDto.getCompanyByName("Knoldus") === Some(knoldusCompany))
    assert(userValidator.userIsValid(validUser) === true)
  }

  it should "return false for an employee belonging to a non-existent company" in {
    val invalidUser = User("Khan", "Singh", 23, "khan.singh@gmail.com", "Amazon")
    assert(userValidator.userIsValid(invalidUser) === false)
  }

  it should "return false for an employee with an invalid email id" in {
    val invalidUser = User("Khan", "Singh", 23, "khan.singh@.com", "Knoldus")
    assert(userValidator.userIsValid(invalidUser) === false)
  }
}

