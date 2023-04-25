
package com.knoldus.db

import com.knoldus.models.Company
import org.scalatest.flatspec.AnyFlatSpec

class CompanyReadDtoSpec extends AnyFlatSpec {

  val companyReadDto = new CompanyReadDto

  "CompanyReadDto" should "return Knoldus company details for valid name Knoldus" in {
    val expectedCompany = Some(Company("Knoldus", "knoldus@gmail.com", "Noida"))
    assert(companyReadDto.getCompanyByName("Knoldus") === expectedCompany)
  }

  it should "return Philips company details for valid name Philips" in {
    val expectedCompany = Some(Company("Philips", "philips123@gmail.com", "Noida"))
    assert(companyReadDto.getCompanyByName("Philips") === expectedCompany)
  }

  it should "return None for invalid company name" in {
    val expectedCompany = Some(Company("Microsoft", "microsoft99@outlook.com", "Gurgaon"))
    assert(companyReadDto.getCompanyByName("Microsoft") === None)
  }
}

