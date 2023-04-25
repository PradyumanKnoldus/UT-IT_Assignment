
package com.knoldus

import com.typesafe.scalalogging.Logger

import scala.util.{Failure, Success, Try}

object PasswordStrengthChecker {
  private val logger: Logger = Logger(getClass)

  // Define a set of special characters that are allowed in the password
  private val specialCharacters = Set('%', '@', '#', '&', '$')

  // Check if the given password meets all the strength requirements
  def isStrong(password: String, userName: String): Boolean = {
    Try {
      val hasUppercase = password.exists(_.isUpper)
      val hasLowercase = password.exists(_.isLower)
      val hasDigits = password.exists(_.isDigit)
      val hasAllowedSpecialChars = password.exists(specialCharacters.contains)
      val doesNotContainName = !password.toLowerCase.contains(userName.toLowerCase)
      val meetsAllConstraints = hasUppercase && hasLowercase && hasDigits && hasAllowedSpecialChars && doesNotContainName

      meetsAllConstraints && password.length >= 8
    } match {
      case Success(isStrong) =>
        if (isStrong) {
          logger.info(s" Entered Password is strong")
        } else {
          logger.warn(s" Entered Password is weak")
        }
        isStrong
      case Failure(exception) =>
        logger.error(s" Error checking password strength for user $userName: ${exception.getMessage}")
        false
    }
  }

  def main(args: Array[String]): Unit = {
    val fullName = scala.io.StdIn.readLine("Enter your Full Name: ")
    val email = scala.io.StdIn.readLine("Enter your Email: ")
    val password = scala.io.StdIn.readLine("Enter your Password: ")

    val userName = fullName.split(" ").head

    PasswordStrengthChecker.isStrong(password, userName)
  }
}



