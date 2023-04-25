package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class PasswordStrengthCheckerSpec extends AnyFlatSpec {
  "isStrong" should "return true for a strong password" in {
    val password = "abc123DEF%@#"
    val userName = "Pradyuman"
    assert(PasswordStrengthChecker.isStrong(password, userName))
  }

  it should "return false for a password without an uppercase letter" in {
    val password = "abc123%@#"
    val userName = "Pradyuman"
    assert(!PasswordStrengthChecker.isStrong(password, userName))
  }

  it should "return false for a password without a lowercase letter" in {
    val password = "ABC123%@#"
    val userName = "Pradyuman"
    assert(!PasswordStrengthChecker.isStrong(password, userName))
  }

  it should "return false for a password without a digit" in {
    val password = "abcDEF%@#"
    val userName = "john"
    assert(!PasswordStrengthChecker.isStrong(password, userName))
  }

  it should "return false for a password with a special character that is not allowed" in {
    val password = "abc123DEF^*"
    val userName = "Pradyuman"
    assert(!PasswordStrengthChecker.isStrong(password, userName))
  }

  it should "return false for a password that contains the user's name" in {
    val password = "Pradyuman123DEF%@#"
    val userName = "Pradyuman"
    assert(!PasswordStrengthChecker.isStrong(password, userName))
  }

  it should "return false for a password that is too short" in {
    val password = "abc123%"
    val userName = "Pradyuman"
    assert(!PasswordStrengthChecker.isStrong(password, userName))
  }
}


