package finalsurge.steps.pages.home;

import component.button.menu.dailyVitals.ViewAddVitalsButton;
import component.button.menu.gearRoutes.RoutesButton;
import component.button.menu.gearRoutes.ShoesButton;
import component.button.menu.workouts.AddWorkoutButton;
import component.button.menu.workouts.ReportsStatisticsButton;
import component.button.menu.workouts.WorkoutLibraryButton;
import finalsurge.steps.AbstractSteps;
import finalsurge.steps.pages.authorization.SignUpSteps;
import finalsurge.steps.pages.gearRoutes.RoutesSteps;
import finalsurge.steps.pages.gearRoutes.ShoesSteps;
import finalsurge.steps.pages.vitals.AddVitalsSteps;
import finalsurge.steps.pages.workouts.AddWorkoutSteps;
import finalsurge.steps.pages.workouts.ReportsStatisticsSteps;
import finalsurge.steps.pages.workouts.WorkoutLibraryStep;
import finalsurge.utils.PropertiesUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.dailyVitals.ViewPage;
import pages.authorization.LoginPage;
import pages.authorization.SignUpPage;
import pages.gearRoutes.RoutesPage;
import pages.gearRoutes.ShoesPage;
import pages.home.DashboardPage;
import pages.workouts.AddWorkoutPage;
import pages.workouts.ReportsStatisticsPage;
import pages.workouts.WorkoutLibraryPage;

public class MainSteps extends AbstractSteps {

    private LoginPage loginPage;
    private SignUpPage signUpPage;
    private AddWorkoutButton addWorkoutButton;
    private ViewAddVitalsButton viewAddVitalsButton;
    private ReportsStatisticsButton reportButton;
    private WorkoutLibraryButton workoutLibraryButton;
    private ShoesButton shoesButton;
    private RoutesButton routesButton;
    private DashboardPage dashboardPage;

    private static final String VALID_LOGIN = PropertiesUtils.getEnv("valid_login");
    private static final String VALID_PASSWORD = PropertiesUtils.getEnv("valid_password");

    private static final String INVALID_LOGIN = PropertiesUtils.getEnv("invalid_login");
    private static final String INVALID_PASSWORD = PropertiesUtils.getEnv("invalid_password");


    public MainSteps(WebDriver driver) {
        super(driver);
    }

    // Надо добавить URL
    @Step("Open 'Login' page")
    @Link(url = "https://log.finalsurge.com/login.cshtml", name = "Final Surge")
    public MainSteps openLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Open 'FinalSurge' page")
    @Description("Open Home page of Final Surge after signing in")
    public MainSteps openFinalSurge() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Open SignUp page")
    public SignUpSteps openSignUpPage() {
        signUpPage = new SignUpPage(driver);
        signUpPage.openSignInPage();
        return new SignUpSteps(driver);
    }

    // Надо добавить кредентиалс
    @Step("Sign in with valid credential")
    @Description("Check that it is possible to enter the site with a valid login and password")
    public MainSteps loginWithValidCredits() {
        loginPage.authentication(
                VALID_LOGIN,
                VALID_PASSWORD
        );
        validatePageIsLoaded(new DashboardPage(driver));
        return this;
    }

    // Надо добавить кредентиалс
    @Step("Sign in with invalid credentials")
    @Description("Check that it is impossible to enter the site with a invalid login and password")
    public MainSteps loginWithInvalidCredits() {
        loginPage.authentication(
                INVALID_LOGIN,
                INVALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    // Надо добавить кредентиалс
    @Step("Sign in with invalid Email")
    @Description("Check that it is impossible to enter the site with a invalid login")
    public MainSteps loginWithInvalidEmail() {
        loginPage.authentication(
                INVALID_LOGIN,
                VALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    // Надо добавить кредентиалс
    @Step("Sign in with invalid Password")
    @Description("Check that it is impossible to enter the site with a invalid password")
    public MainSteps loginWithInvalidPassword() {
        loginPage.authentication(
                VALID_LOGIN,
                INVALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    // Надо добавить кредентиалс
    @Step("Sign in with empty Email field")
    @Description("Check that it is impossible to enter the site without a login")
    public MainSteps loginWithEmptyEmailField() {
        loginPage.authentication(
                "",
                VALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    // Надо добавить кредентиалс
    @Step("Sign in with empty Password field")
    @Description("Check that it is impossible to enter the site without a password")
    public MainSteps loginWithEmptyPasswordField() {
        loginPage.authentication(
                VALID_LOGIN,
                ""
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Open 'Add Workout' page")
    @Description("Check that it is possible to open 'Add Workout' page from Menu")
    public AddWorkoutSteps openAddWorkout() {
        addWorkoutButton = new AddWorkoutButton(driver);
        Assert.assertTrue(
                addWorkoutButton.isComponentDisplayed(),
                addWorkoutButton.getClass().getSimpleName().concat(" not displayed")
        );
        addWorkoutButton.click();
        validatePageIsLoaded(new AddWorkoutPage(driver));
        return new AddWorkoutSteps(driver);
    }

    @Step("Open 'Report' page")
    public ReportsStatisticsSteps openReportPage() {
        reportButton = new ReportsStatisticsButton(driver);
        Assert.assertTrue(
                reportButton.isComponentDisplayed(),
                reportButton.getClass().getSimpleName().concat(" not displayed")
        );
        reportButton.click();
        validatePageIsLoaded(new ReportsStatisticsPage(driver));
        return new ReportsStatisticsSteps(driver);
    }

    @Step("Open 'Daily Vitals page")
    public AddVitalsSteps openDailyVitalsPage() {
        viewAddVitalsButton = new ViewAddVitalsButton(driver);
        Assert.assertTrue(
                viewAddVitalsButton.isComponentDisplayed(),
                viewAddVitalsButton.getClass().getSimpleName().concat(" not displayed")
        );
        viewAddVitalsButton.click();
        validatePageIsLoaded(new ViewPage(driver));
        return new AddVitalsSteps(driver);
    }

    @Step("Open 'Workout Library' page")
    @Description("Check that it is possible to open 'Workout Library' page from Menu")
    public WorkoutLibraryStep openWorkoutLibrary() {
        workoutLibraryButton = new WorkoutLibraryButton(driver);
        Assert.assertTrue(
                workoutLibraryButton.isComponentDisplayed(),
                workoutLibraryButton.getClass().getSimpleName().concat(" is not displayed")
        );
        workoutLibraryButton.click();
        validatePageIsLoaded(new WorkoutLibraryPage(driver));
        return new WorkoutLibraryStep(driver);
    }

    @Step("Open 'Shoes' page")
    @Description("Check that it is possible to open 'Shoes' page from Menu")
    public ShoesSteps openShoes() {
        shoesButton = new ShoesButton(driver);
        Assert.assertTrue(
                shoesButton.isComponentDisplayed(),
                shoesButton.getClass().getSimpleName().concat(" is not displayed")
        );
        shoesButton.click();
        validatePageIsLoaded(new ShoesPage(driver));
        return new ShoesSteps(driver);
    }

    @Step("Open 'Logout' page")
    public LogoutSteps openLogoutPage() {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.openLogoutPage();
        return new LogoutSteps(driver);
    }

    @Step("Open 'Routes' page")
    @Description("Check that it is possible to open 'Routes' page from Menu")
    public RoutesSteps openRoutes() {
        routesButton = new RoutesButton(driver);
        Assert.assertTrue(
                routesButton.isComponentDisplayed(),
                routesButton.getClass().getSimpleName().concat(" is not displayed")
        );
        routesButton.click();
        validatePageIsLoaded(new RoutesPage(driver));
        return new RoutesSteps(driver);
    }
}
