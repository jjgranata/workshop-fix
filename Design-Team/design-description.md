
Design Specification

Main menu:
    The main menu is the central navigation point of the app, allowing users to access different functionalities. It fulfills the requirement of presenting the user with options to enter/edit current job details, enter job offers, adjust comparison settings, and compare job offers.
    UML representation: The MainMenu class is associated with the compApp class, which serves as the entry point of the application. The MainMenu class has methods to display the menu options and handle user input.
    
Enter/edit current job details:
    The CurrentJob class encapsulates the details of the user's current job. It includes attributes for each job detail mentioned in the requirements, such as title, company, location, salary, bonus, and other benefits. The class provides methods to enter, edit, save, and cancel job details.
    UML representation: The CurrentJob class is associated with the compApp class. It has a one-to-one association with the Location class to represent the job location details.
    
Enter job offers:
    The JobOffer class represents the details of a job offer. It has the same attributes as the CurrentJob class, allowing users to enter and save job offer details. Multiple job offers can be associated with the compApp.
    UML representation: The JobOffer class is associated with the compApp class with a one-to-many relationship. It also has a one-to-one association with the Location class.
    
Adjust comparison settings:
    The ComparisonSettings class allows users to assign weights to different factors for job comparison. It includes attributes for each factor's weight and a method to assign the weights.
    UML representation: The ComparisonSettings class is associated with the compApp class.
    
Compare job offers:
    The compareJobs class handles the comparison logic for job offers. It includes methods to compute job scores, rank jobs based on scores, and compare two selected jobs. The class depends on the CurrentJob and JobOffer classes to perform the comparisons.
    UML representation: The compareJobs class is associated with the compApp class. It has a dependency relationship with the CurrentJob and JobOffer classes, indicated by the dashed arrow.
    
Job score calculation:
    The computeJobScore() method in the compareJobs class implements the weighted average formula for calculating job scores based on the provided requirements. It takes into account the adjusted salary, bonus, and other factors.
    UML representation: The computeJobScore() method is included in the compareJobs class.
    
User interface:
    The UI aspects are not explicitly represented in the UML diagram as they will be handled by the GUI implementation. However, the design includes methods for data entry, display, and user interaction, which will be invoked by the corresponding UI components.
    UML representation: Not directly represented in the UML diagram.
    
Single system assumption:
    The design assumes a single system running the app, without the need for communication or saving between devices. This simplifies the design and focuses on the core functionalities of the app.
    
   UML representation: Not explicitly represented in the UML diagram.
