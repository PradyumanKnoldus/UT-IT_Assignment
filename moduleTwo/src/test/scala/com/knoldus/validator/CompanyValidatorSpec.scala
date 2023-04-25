
package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.models.Company

class CompanyValidatorSpec extends AnyFlatSpec {
  val companyValidator = new CompanyValidator

  "CompanyValidator" should "return true for a valid company" in {
    val validCompany = Company("ABC Inc.", "abc.inc@example.com", "Delhi")
    assert(companyValidator.companyIsValid(validCompany) === true)
  }

  it should "return false if a company with the same name already exists in the database" in {
    val existingCompany = Company("Knoldus", "knoldus@gmail.com", "Noida")
    assert(companyValidator.companyIsValid(existingCompany) === false)
  }

  it should "return false if the email id is invalid" in {
    val invalidEmailCompany = Company("XYZ Corp.", "xyz@.com", "Tamil Nadu")
    assert(companyValidator.companyIsValid(invalidEmailCompany) === false)
  }
}
