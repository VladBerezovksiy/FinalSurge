# Website: [FinalSurge](https://log.finalsurge.com/)

### Foreword:
Our framework is **crossbrowser**. Therefore, if you want to use a specific browser,
then you need to change the name of the browser in the code: (Image 1)
  
![alt-text](src/test/resources/ChangeBrowserNameImage.jpg "Image 1 - Steps to change Browser")

### TestNg command for run
**Command to run all tests:**
```
mvn clean test
```
**Command to run Smoke tests:**
```
mvn clean test -Dgroups="smoke"
```
**Command to run Negative tests:**
```
mvn clean test -Dgroups="negative"
```
  
### Allure command for run
**Command to run Allure on browser:**
```
mvn allure:serve
```
**Command to run Allure on project:**
```
mvn allure:report
```
  
### Tests documentation

| ID  | Pages            | Cases                                                               | Who did | Status | 
|-----|------------------|---------------------------------------------------------------------|---------|--------|
| *   | Login            | Login page loaded                                                   | Vlad    | Done   |
| *   | Login            | Sign in with valid credential                                       | Vlad    | Done   |
| *   | Login            | Sign in with invalid credential                                     | Vlad    | Done   |
| *   | Login            | Sign in with invalid 'Email' and valid 'Password'                   | Vlad    | Done   |
| *   | Login            | Sign in with valid 'Email' and invalid 'Password'                   | Vlad    | Done   |
| *   | Login            | Sign in with empty 'Email' and 'Password' fields                    | Vlad    | Done   |
| *   | Login            | Sign in with empty 'Email' field                                    | Vlad    | Done   |
| *   | Login            | Sign in with empty 'Password' field                                 | Vlad    | Done   |
| *   | Login            | Login button display                                                | Vlad    | Done   |
| *   | Login            | Check that 'Not registered? Sign up here for free' link is working  | Nadya   | Done   |
| *   | Register         | Sign up with valid credential                                       | Nadya   | Done   |
| *   | Register         | Sign up with empty 'Email'                                          | Nadya   | Done   |
| *   | Register         | Sign up with empty 'Password'                                       | Nadya   | Done   |
| *   | Register         | Sign up with empty 'Re-type password'                               | Nadya   | Done   |
| *   | Register         | Sign up with empty 'First Name'                                     | Nadya   | Done   |
| *   | Register         | Sign up with empty 'Last Name'                                      | Nadya   | Done   |
| *   | Register         | Sign up with password which doesn't match the rule                  | Nadya   | Done   |
| *   | Register         | Sign up: password doesn't match retype password                     | Nadya   | Done   |
| *   | Home             | Header option display                                               | Vlad    | Done   |
| *   | Home             | Home page loaded                                                    | Vlad    | Done   |
| *   | Home             | Breadcrumbs display                                                 | Vlad    | Done   |
| *   | Add Workout      | 'Add Workout' page loaded                                           | Vlad    | Done   |
| *   | Add Workout      | Breadcrumbs display                                                 | Vlad    | Done   |
| *   | Add Workout      | Sidebar with activity display                                       | Vlad    | Done   |
| *   | Add Workout      | Choose any activity type from sidebar                               | Vlad    | Done   |
| *   | Add Workout      | Form display                                                        | Vlad    | Done   |
| *   | Add Workout      | Fields displayed                                                    | Vlad    | Done   |
| *   | Add Workout      | 'Submit' button display                                             | Vlad    | Done   |
| *   | Add Workout      | Add workout with valid data                                         | Vlad    | Done   |
| *   | Workout Details  | 'Workout Details' page loaded                                       | Vlad    | Done   |
| *   | Workout Details  | Check that added workout value matched                              | Vlad    | Done   |
| *   | Reports          | Opening "Reports & Statistics" page from the main menu              | Nadya   | Done   |
| *   | Reports          | Displaying the report when only the period is selected              | Nadya   | Done   |
| *   | Reports          | Displaying the report when all filters are selected                 | Nadya   | Done   |
| *   | Reports          | Check that the data in the table match the selected period          | Nadya   | Done   |
| *   | Reports          | Check that the data in the table match the selected period and type | Nadya   | Done   |
| *   | Reports          | 'Report & Statistics' page loaded                                   | Nadya   | Done   |
| *   | Reports          | 'View Report' button is displayed                                   | Nadya   | Done   |
| *   | Reports          | Breadcrumbs display                                                 | Nadya   | Done   |
| *   | Workout Library  | 'Workout Library' page loaded                                       | Vlad    | Done   |
| *   | Workout Library  | Breadcrumbs display                                                 | Vlad    | Done   |
| *   | Workout Library  | Form display                                                        | Vlad    | Done   |
| *   | Workout Library  | Fields display                                                      | Vlad    | Done   |
| *   | Workout Library  | 'Add Workout' button display                                        | Vlad    | Done   |
| *   | Workout Library  | Check that added workout value matched                              | Vlad    | Done   |
| *   | Workout Library  | Table display wit data                                              | Vlad    | Done   |
| *   | Shoes            | 'Shoes' page loaded                                                 | Vlad    | Done   |
| *   | Shoes            | Breadcrumbs display                                                 | Vlad    | Done   |
| *   | Shoes            | Form display                                                        | Vlad    | Done   |
| *   | Shoes            | Fields display                                                      | Vlad    | Done   |
| *   | Shoes            | 'Add Shoe' button display                                           | Vlad    | Done   |
| *   | Shoes            | Table display wit data                                              | Vlad    | Done   |
| *   | Shoes            | Check that added workout value matched                              | Vlad    | Done   |
| *   | Daily Vital      | 'View & Add Vitals' page loaded                                     | Nadya   | Done   |
| *   | Daily Vital      | 'Add Vitals' button is displayed                                    | Nadya   | Done   |
| *   | Daily Vital      | Check that the fiels for adding vilals are displayed                
|     |                  | after clicking the button 'Add Vitals'                              | Nadya   | Done   |
| *   | Daily Vital      | Add new vital                                                       | Nadya   | Done   |
| *   | Daily Vital      | Choose the period for 'Daily Vitals' table                          | Nadya   | Done   |
| *   | Daily Vital      | 'View' button is displayed                                          | Nadya   | Done   |
| *   | Daily Vital      | Table with data is displayed                                        | Nadya   | Done   |
| *   | Daily Vital      | Check that entered data matches the data in the table               | Nadya   | Done   |
| *   | Routes           | 'Shoes' page loaded                                                 | Vlad    | Done   |
| *   | Routes           | Breadcrumbs display                                                 | Vlad    | Done   |
| *   | Routes           | Form display                                                        | Vlad    | Done   |
| *   | Routes           | Fields display                                                      | Vlad    | Done   |
| *   | Routes           | 'Add Route' button display                                          | Vlad    | Done   |
| *   | Routes           | Table display wit data                                              | Vlad    | Done   |
| *   | Routes           | Check that added workout value matched                              | Vlad    | Done   |
| *   | Workout calc     | Open the frame 'Workout calculator'                                 | Nadya   | Done   |
| *   | Workout calc     | Check that calculator works                                         | Nadya   | Done   |
| *   | Workout calc     | Check the message if the value of minutes isn't entered             | Nadya   | Done   |
| *   | Workout calc     | Check the message if the value of seconds isn't entered             | Nadya   | Done   |
| *   | Workout calc     | Check the message if the event doesn't match the time               | Nadya   | Done   |
| *   | Other Calculator | Open the frame 'Workout calculator'                                 | Vlad    | Done   |
| *   | Other Calculator | Check that calculator works                                         | Vlad    | Done   |
| *   | Other Calculator | Fields display                                                      | Vlad    | Done   |
| *   | Other Calculator | 'Calculate Paces' button display                                    | Vlad    | Done   |
