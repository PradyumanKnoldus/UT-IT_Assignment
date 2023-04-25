
package com.knoldus.db

import com.knoldus.models.Company

import scala.collection.immutable.HashMap

class CompanyReadDto {
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val philipsCompany: Company = Company("Philips", "philips123@gmail.com", "Noida")
  // Storing the companies in a HashMap with company name as the key
  val companies: HashMap[String, Company] = HashMap("Knoldus" -> knoldusCompany, "Philips" -> philipsCompany)

  // Method to get a company by name
  def getCompanyByName(name: String): Option[Company] = companies.get(name)

}
