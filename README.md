# FinalSurge

### Tests

| ID  | Pages           | Cases                                                              | Who did | Status | 
|-----|-----------------|--------------------------------------------------------------------|---------|--------|
| *   | Login           | Login page loaded                                                  | Vlad    | Done   |
| *   | Login           | Sign in with valid credential                                      | Vlad    | Done   |
| *   | Login           | Sign in with invalid credential                                    | Vlad    | Done   |
| *   | Login           | Sign in with invalid 'Email' and valid 'Password'                  | Vlad    | Done   |
| *   | Login           | Sign in with valid 'Email' and invalid 'Password'                  | Vlad    | Done   |
| *   | Login           | Sign in with empty 'Email' and 'Password' fields                   | Vlad    | Done   |
| *   | Login           | Sign in with empty 'Email' field                                   | Vlad    | Done   |
| *   | Login           | Sign in with empty 'Password' field                                | Vlad    | Done   |
| *   | Login           | Login button display                                               | Vlad    | Done   |
| *   | Login           | Check that 'Forgot password?' link is working                      | Vlad    | *      |
| *   | Login           | Check that 'Not registered? Sign up here for free' link is working | Vlad    | *      |
| *   | Register        | Sign up with valid credential                                      | Nadya   | Done   |
| *   | Register        | Sign up with empty 'Email'                                         | Nadya   | Done   |
| *   | Register        | Sign up with empty 'Password'                                      | Nadya   | Done   |
| *   | Register        | Sign up with empty 'Re-type password'                              | Nadya   | Done   |
| *   | Register        | Sign up with empty 'First Name'                                    | Nadya   | Done   |
| *   | Register        | Sign up with empty 'Last Name'                                     | Nadya   | Done   |
| *   | Register        | Sign up with password which doesn't match the rule                 | Nadya   | Done   |
| *   | Register        | Sign up: password doesn't match retype password                    | Nadya   | Done   |
| *   | Home            | Header option display                                              | Vlad    | Done   |
| *   | Home            | Home page loaded                                                   | Vlad    | Done   |
| *   | Home            | Breadcrumbs display                                                | Vlad    | Done   |
| *   | Add Workout     | 'Add Workout' page loaded                                          | Vlad    | Done   |
| *   | Add Workout     | Breadcrumbs display                                                | Vlad    | Done   |
| *   | Add Workout     | Sidebar with activity display                                      | Vlad    | Done   |
| *   | Add Workout     | Choose any activity type from sidebar                              | Vlad    | Done   |
| *   | Add Workout     | Form display                                                       | Vlad    | Done   |
| *   | Add Workout     | Fields displayed                                                   | Vlad    | Done   |
| *   | Add Workout     | 'Submit' button display                                            | Vlad    | Done   |
| *   | Add Workout     | Add workout with valid data                                        | Vlad    | Done   |
| *   | Workout Details | 'Workout Details' page loaded                                      | Vlad    | Done   |
| *   | Workout Details | Check that added workout value matched                             | Vlad    | Done   |
| *   | Reports         | Opening "Reports & Statistics" page from the main menu             | Nadya   | Done   |
| *   | Reports         | Displaying the report when only the period is selected             | Nadya   | Done   |
| *   | Reports         | Displaying the report when all filters are selected                | Nadya   | Done   |
| *   | Reports         | Displaying the message if data isn't matched the filter's elements | Nadya   |        |
| *   | Reports         | Displaying the message if "End Date" is less "Start Date"          | Nadya   |        |
| *   | Reports         | Adding the comment to the workout                                  | Nadya   |        |
| *   | Reports         | Deleting the comment from the workout                              | Nadya   |        |
| *   | Reports         | Opening "Reports & Statistics" page from the home page             | Nadya   |        |
| *   | Workout Library | 'Workout Library' page loaded                                      | Vlad    | Done   |
| *   | Workout Library | Breadcrumbs display                                                | Vlad    | Done   |
| *   | Workout Library | Form display                                                       | Vlad    | Done   |
| *   | Workout Library | Fields displayed                                                   | Vlad    | Done   |
| *   | Workout Library | 'Add Workout' button display                                       | Vlad    | Done   |
| *   | Workout Library | Choose any activity type from Form                                 | Vlad    | Done   |
| *   | Workout Library | Check that added workout value matched                             | Vlad    | Done   |
| *   | Workout Library | Table display wit data                                             | Vlad    | Done   |
| *   | Shoes           |                                                                    | Vlad    |        |
| *   | Shoes           |                                                                    | Vlad    |        |
| *   | Shoes           |                                                                    | Vlad    |        |
| *   | Shoes           |                                                                    | Vlad    |        |
| *   | Shoes           |                                                                    | Vlad    |        |
| *   | Shoes           |                                                                    | Vlad    |        |
| *   | Shoes           |                                                                    | Vlad    |        |
| *   | Shoes           |                                                                    | Vlad    |        |


### TestNg command for run
Запуск групп тестов: mvn clean test -Dgroups=negative,smoke

### Allure command for run
Запуск allure: allure serve target/allure-results




