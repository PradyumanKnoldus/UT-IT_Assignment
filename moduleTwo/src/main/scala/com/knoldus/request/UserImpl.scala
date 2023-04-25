
package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import com.typesafe.scalalogging.Logger

class UserImpl(userValidator: UserValidator){
  private val logger: Logger = Logger(getClass)

  // Define a function to create an user
  def createUser(user: User): Option[String] = {
    if (userValidator.userIsValid(user)) {
      logger.info(s"User ${user.emailId} created successfully")
      Option(user.emailId)
    } else {
      logger.warn(s"Invalid user ${user.emailId}")
      None
    }
  }
}
