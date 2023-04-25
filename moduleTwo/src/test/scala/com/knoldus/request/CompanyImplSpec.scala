
package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplSpec extends AnyFlatSpec {

  val companyValidator = new CompanyValidator
  val companyImpl = new CompanyImpl(companyValidator)

  "CompanyImpl" should "return company name for valid company details" in {
    val company = Company("Microsoft", "microsoft99@outlook.com", "Noida")
    assert(companyImpl.createCompany(company) === Some("Microsoft"))
  }

  it should "return None for invalid company details" in {
    val company = Company("Amazon", "knoldus@.comx", "Noida")
    assert(companyImpl.createCompany(company) === None)
  }
}


