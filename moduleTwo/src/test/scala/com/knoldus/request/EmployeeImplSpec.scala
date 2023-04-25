
package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeImplSpec extends AnyFlatSpec {

  val employeeValidator = new EmployeeValidator
  val employeeImpl = new EmployeeImpl(employeeValidator)

  "EmployeeImpl" should "return email id for valid employee details" in {
    val employee = Employee("Pradyuman", "Singh", 23, 60000.0, "Software Engineer", "Knoldus", "pradyuman.singh@knoldus.com")
    assert(employeeImpl.createEmployee(employee) === Some("pradyuman.singh@knoldus.com"))
  }

  it should "return None for invalid employee details" in {
    val employee = Employee("Khan", "Singh", 25, 50000.0, "Software Engineer", "Knoldus", "khan.singh@.com")
    assert(employeeImpl.createEmployee(employee) === None)
  }
}

