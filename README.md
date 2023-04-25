# UT-IT (Multi-Module Assignment)

## Module One

### -> Password Strength Checker

This is a Scala program that checks the strength of a given password based on specific requirements. It verifies if the password meets the following criteria:

>Contains at least one uppercase letter

>Contains at least one lowercase letter

>Contains at least one digit

>Contains at least one special character (%, @, #, &, $)

>Does not contain the user's name

>Has a minimum length of 8 characters

### -> Factorial Of A Number

This is a Scala program that calculates the factorial of a number.

#### Usage

The program defines an object named "FactorialOfANumber", which contains a method named "findFactorialOfANumber". The method takes an integer as input and returns an Either object. If the input number is negative, the method returns a Left object with an error message. Otherwise, it calculates the factorial of the input number using a tail-recursive function and returns a Right object with the result.

#### Example

    import com.knoldus.FactorialOfANumber

    val result = FactorialOfANumber.findFactorialOfANumber(5)
    result match {
    case Left(errorMessage) => println(errorMessage)
    case Right(factorial) => println(factorial)
    }

### -> Duplicate Elements Checker

This is a Scala program that checks if a given list contains any duplicate elements.

#### Usage

The program defines a class named "DuplicateElementsChecker", which contains a method named "hasDuplicates". The method takes a list of type A as input and returns a Boolean value. If the input list has duplicates, the method returns true, otherwise, it returns false. The method also logs the result using the Scala Logging library.

#### Example

    import com.knoldus.DuplicateElementsChecker

    val inputList = List(1, 2, 3, 4, 5)
    val checker = new DuplicateElementsChecker
    val hasDuplicates = checker.hasDuplicates(inputList)

    println(hasDuplicates) // Output: false

## Module Two

### -> Company Read DTO

This module contains the CompanyReadDto class, which provides a HashMap of Company objects and a method to get a company by its name.

#### Company Class

The Company class has the following properties:

>name: Name of the company (String)

>email: Email of the company (String)
    
>city: City where the company is located (String)

#### CompanyReadDto Class

The CompanyReadDto class has the following methods:

    getCompanyByName(name: String): Option[Company]

Returns an Option of Company object based on the company name.