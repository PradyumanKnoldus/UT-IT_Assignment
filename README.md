# UT-IT (Multi-Module Assignment)

--------------------------------------------------------------------------------------------------------------------------------------------------------------

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

--------------------------------------------------------------------------------------------------------------------------------------------------------------

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

### -> Company Implementation Class

This class is used to implement the createCompany method to create a company. It takes an instance of CompanyValidator to validate the input Company object. If the company is valid, it logs a message indicating that the company is being created and returns the name of the company. If the company is not valid, it logs a warning message and returns None.

#### Dependencies

This class depends on the following classes:

>Company: This is a case class that represents a company.
    
>CompanyValidator: This is a class that provides methods to validate a Company object.

#### Methods

**createCompany**

    def createCompany(company: Company): Option[String]

This method takes a Company object as input and returns an optional String. It first validates the input object using the companyIsValid method of CompanyValidator. If the company is valid, it logs a message indicating that the company is being created and returns the name of the company wrapped in an Option. If the company is not valid, it logs a warning message and returns None.

### -> Employee Implementation Class

This is a class to create an EmployeeImpl. It has a single function createEmployee, which takes an Employee object as input and returns an Option[String]. If the input Employee object is valid, the function returns an Option containing the emailId of the employee, otherwise it returns None.

#### Dependencies

This class depends on the following classes:

>Employee: This is a case class that represents an employee.
    
>EmployeeValidator: This is a class that provides methods to validate an Employee object.

#### Methods

    def createEmployee(employee: Employee): Option[String] 

This method takes an Employee object as input and returns an Option[String]. If the input Employee object is valid, the method returns an Option containing the emailId of the employee, otherwise it returns None.

### -> User Implementation Class

This class contains the implementation of the methods to create a user. It takes a UserValidator as a parameter to validate the user details.

#### Dependencies

> User: This is a case class that represents an user.
    
>UserValidator: A validator class to validate the user details.

#### Method

    createUser(user: User): Option[String]

This method takes a User object as input, validates the user details using the UserValidator, and creates a user. It returns an Option[String] where Some(emailId) is returned on successful creation of the user and None is returned otherwise.

### Validators

### -> Company Validator

This is a class that checks if a given Company object is valid or not. The CompanyValidator class has a single method, companyIsValid, which takes a Company object as input and returns a Boolean value.

#### Method

    companyIsValid(company: Company): Boolean

This method takes a Company object as input and returns true if the company is valid, false otherwise. A company is considered valid if it satisfies the following conditions:
        
>The company name is not a duplicate of any existing company.
        
>The company email is a valid email address.

#### Dependencies

>CompanyReadDto: This class provides access to a database of company objects.
    
>EmailValidator: This class is used to validate email addresses.

### -> Email Validator

This class is responsible for validating an email address.

#### Methods

    emailIdIsValid(email: String): Boolean

This method takes an email address as a string parameter and returns a Boolean indicating whether the email is valid or not. The validation is performed by checking if the email has the correct format, i.e., contains only one "@" symbol and at least one "." after the "@" symbol.

### -> Employee Validator

The EmployeeValidator class provides functionality to validate an instance of the Employee class. It ensures that the Employee object contains valid information, such as a valid email address and a valid company name.

#### Methods

The EmployeeValidator class provides the following public methods:

    employeeIsValid(employee: Employee): Boolean

This method takes an instance of the Employee class as an input parameter and returns a Boolean value indicating whether or not the input Employee object is valid.

The method first checks if the Employee object contains a valid company name. It uses the CompanyReadDto class to retrieve a company object by name and validates whether it exists or not.

If the company name is valid, the method checks if the email address of the Employee object is valid using the EmailValidator class. It returns true if the email is valid, false otherwise.

#### Dependencies

The EmployeeValidator class depends on the following classes:

>CompanyReadDto: To retrieve company information by name.

>EmailValidator: To validate email addresses.

### -> User Validator

This is a class that provides validation functionality for a User model.

#### Methods

    userIsValid(user: User): Boolean

This function takes a User object as input and returns a Boolean indicating whether the object is valid or not. The function checks if the company name provided in the User object is valid and if the email provided is a valid email format. If the company name is not valid or the email is not valid, the function returns false and logs a warning message using com.typesafe.scalalogging.Logger. If everything is valid, the function returns true.

#### Dependencies

This class depends on the following classes:

>CompanyReadDto: To retrieve company information by name.

>EmailValidator: To validate email addresses.

## Additional 

### -> Scala Style Plugin

To ensure code quality and maintain consistency, we have added the Scala Style plugin to our project. This plugin helps enforce a consistent code style and detects potential issues in our code. We can configure the plugin to adhere to a particular coding standard, such as the Scala Style Guide. By using this plugin, we can ensure that our code follows best practices and is easy to read and maintain.

    addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

## Testing

The program includes unit tests for all the modules here.

To run the tests, you can use the following command:

    sbt test

