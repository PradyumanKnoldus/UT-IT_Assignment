
package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorSpec extends AnyFlatSpec {
  val emailValidator = new EmailValidator

  "EmailValidator" should "return true for a valid email id" in {
    val validEmail = "pradyuman.singh@knoldus.com"
    assert(emailValidator.emailIdIsValid(validEmail) === true)
  }

  it should "return false for an email id without '@'" in {
    val invalidEmail = "pradyuman.singhknoldus.com"
    assert(emailValidator.emailIdIsValid(invalidEmail) === false)
  }

  it should "return false for an email id without '.'" in {
    val invalidEmail = "pradyuman.singh@knolduscom"
    assert(emailValidator.emailIdIsValid(invalidEmail) === false)
  }

  it should "return false for an email id with '.' before '@'" in {
    val invalidEmail = "pradyuman.@knolduscom"
    assert(emailValidator.emailIdIsValid(invalidEmail) === false)
  }

  it should "return false for an email id with a domain of less than 2 characters" in {
    val invalidEmail = "pradyuman.singh@knoldus.i"
    assert(emailValidator.emailIdIsValid(invalidEmail) === false)
  }

  it should "return false for an email id with two '@' symbols" in {
    val invalidEmail = "pradyuman@singh@knoldus.com"
    assert(emailValidator.emailIdIsValid(invalidEmail) === false)
  }
}

