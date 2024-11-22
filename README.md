 Online Insurance Management System

 Description
The Online Insurance Management System is a Java-based application designed to streamline the process of managing insurance policies. It features user authentication through CAPTCHA, dynamic premium calculation based on user age, and unique policy number generation. The system supports file handling for secure data storage and utilizes Role-Based Access Control (RBAC) for admin functionalities.

 Features
- User Authentication: CAPTCHA-based verification to ensure the user is not a robot.
- Dynamic Premium Calculation: Calculates premium based on age using conditional logic.
- Policy Number Generation: Generates unique policy numbers using string manipulation.
- Data Persistence: Uses Java file I/O (`File`, `FileWriter`, `BufferedWriter`) for storing user and policy data.
- Admin Access: Role-Based Access Control (RBAC) to differentiate between admin and user roles.
- Input Validation: Ensures correct email, phone number, and date format using Java validation techniques.
- Logging: Appends policy data to a centralized `Admin.txt` file for administrative access.

 Technologies Used
- Java  
  - `java.util`: For handling input and random generation.
  - `java.io`: For file handling and data persistence.
  - `java.time`: For date-related operations and age calculations.
  - `java.lang`: For basic Java classes like `String` and `System`.

 Getting Started
To run this project locally, follow these steps:

 Prerequisites
- Java JDK 8 or higher installed on your machine.


 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

 Acknowledgments
- Thanks to the Java documentation for providing comprehensive resources to implement the file handling and date management features.
