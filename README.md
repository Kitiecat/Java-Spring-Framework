**Part C changes:**
7/19
Created mainscreen.css in the static/css folder
File mainscreen.html
Line 13 added stylesheet
Line 15 renamed title to Tom's Computer Hardware Store
Lines 18-28 Added header to create a navbar
Lines 29-79 Added a container div and changed some of the of elements to create a more professional look using bootstrap css

**Part D changes:**
7/29
created the AboutController class, used mapping to point it to the /about url. Created template about.html and modified the mainscreen.html to create a link in a navbar
Files: about.html and AboutController


**Part E changes:**
7/30
added code to the BootStrapData class to create 5 initial parts and products that will only run if the database is empty.
File: BootStrapData
Lines 39-92

**Part F changes:**
Added the Buy Now button to the mainscreen.html file, created the BuyPrebuiltController class, created a method to modify the inventory amount.
7/30
File: mainscreen.html
Line: 100
File: BuyPrebuiltController
File: Prebuilt (renamed from Products)
Lines: 109
Created the files successfulbuyprebuilt.html and unsuccessfulbuyprebuilt.html

**Part G changes:**
7/30
Modified the Part class to include two fields invMin and invMax, created validation to enforce inventory values
File: Part
Lines: 37-38
Renamed InhousePart and associated files to InternalPart to reflect customer buisness logic.
Renamed the OutsourcedPart class and associated files to Peripherals. 
Modifed the InternalPartForm and PeripheralsPartForm to display invMin and invMax.

File: InhousePartService renamed to InternalPartService
File: InhousePartServiceImpl renamed to InternalPartServiceImpl
File: InhousePartRepository renamed to InternalPartRepository
File: OutsourcedPartService renamed to PeripheralsParService
File: OutsourcedPartServiceImpl renamed to PeripheralsParServiceImpl
File: OutsourcedPartRepository renamed to PeripheralsPartRepository

File: InternalPartForm.html
Lines 50-60 Added Inventory Min and Inventory Max
Also reworked the rest of the html to conform to the rest of the website.

File: PeripheralsPartForm.html
Lines 49-59
Also reworked the rest of the html to conform to the rest of the website.

**Part H changes:**
Created the InventoryMaxValidator, InventoryMinValidator, ValidInventoryMax, ValidInventoryMin custom validators

File: InternalPartForm.html
Lines 53 and 59 Added an error message


File: PeripheralsPartForm.html
Lines 52 and 58 Added an error message


**Part I Changes:**
File: PartTest
Lines: 86-118

**Part J Changes**
Removed the DeletePartsValidator as it was unused. 


<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 

## SUPPLEMENTAL RESOURCES  
1.	How to clone a project to IntelliJ using Git?

> Ensure that you have Git installed on your system and that IntelliJ is installed using [Toolbox](https://www.jetbrains.com/toolbox-app/). Make sure that you are using version 2022.3.2. Once this has been confirmed, click the clone button and use the 'IntelliJ IDEA (HTTPS)' button. This will open IntelliJ with a prompt to clone the proejct. Save it in a safe location for the directory and press clone. IntelliJ will prompt you for your credentials. Enter in your WGU Credentials and the project will be cloned onto your local machine.  

2. How to create a branch and start Development?

- GitLab method
> Press the '+' button located near your branch name. In the dropdown list, press the 'New branch' button. This will allow you to create a name for your branch. Once the branch has been named, you can select 'Create Branch' to push the branch to your repository.

- IntelliJ method
> In IntelliJ, Go to the 'Git' button on the top toolbar. Select the new branch option and create a name for the branch. Make sure checkout branch is selected and press create. You can now add a commit message and push the new branch to the local repo.

## SUPPORT
If you need additional support, please navigate to the course page and reach out to your course instructor.
## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!
