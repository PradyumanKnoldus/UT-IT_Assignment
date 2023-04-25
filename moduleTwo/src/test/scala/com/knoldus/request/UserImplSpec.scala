
package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.scalatest.flatspec.AnyFlatSpec

class UserImplSpec extends AnyFlatSpec {

  val userValidator = new UserValidator
  val userImpl = new UserImpl(userValidator)

  "UserImpl" should "return email id for valid user details" in {
    val user = User("Pradyuman", "Singh", 23, "pradyuman.singh@knoldus.com", "Knoldus")
    assert(userImpl.createUser(user) === Some("pradyuman.singh@knoldus.com"))
  }

  it should "return None for invalid user details" in {
    val user = User("Khan", "Singh", 23, "khan.singh@.com", "Knoldus")
    assert(userImpl.createUser(user) === None)
  }
}

