package finalsurge.steps.pages.home;

import component.button.header.IconMenuButton;
import component.button.menu.dailyVitals.ViewAddVitalsButton;
import component.button.menu.gearRoutes.RoutesButton;
import component.button.menu.gearRoutes.ShoesButton;
import component.button.menu.workouts.AddWorkoutButton;
import component.button.menu.workouts.ReportsStatisticsButton;
import component.button.menu.workouts.WorkoutLibraryButton;
import finalsurge.constants.button.MenuIconButtonConstants;
import finalsurge.constants.credantials.LoginDataConstant;
import finalsurge.steps.AbstractSteps;
import finalsurge.steps.frames.OtherCalculatorStep;
import finalsurge.steps.frames.WorkoutCalcSteps;
import finalsurge.steps.pages.authorization.SignUpSteps;
import finalsurge.steps.pages.gearRoutes.RoutesSteps;
import finalsurge.steps.pages.gearRoutes.ShoesSteps;
import finalsurge.steps.pages.vitals.AddVitalsSteps;
import finalsurge.steps.pages.workouts.AddWorkoutSteps;
import finalsurge.steps.pages.workouts.ReportsStatisticsSteps;
import finalsurge.steps.pages.workouts.WorkoutLibraryStep;
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
    private IconMenuButton iconMenuButton;

    public MainSteps(WebDriver driver) {
        super(driver);
    }

    // TODO: Надо добавить URL
    @Step("Open 'Login' page")
    @Link(url = "https://log.finalsurge.com/login.cshtml", name = "Final Surge")
    public MainSteps openLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with valid credential")
    @Description("Check that it is possible to enter the site with a valid login and password")
    public MainSteps loginWithValidCredits() {
        loginPage.authentication(
                LoginDataConstant.VALID_LOGIN,
                LoginDataConstant.VALID_PASSWORD
        );
        validatePageIsLoaded(new DashboardPage(driver));
        return this;
    }

    @Step("Open SignUp page")
    public SignUpSteps openSignUpPage() {
        signUpPage = new SignUpPage(driver);
        signUpPage.openSignInPage();
        return new SignUpSteps(driver);
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

    @Step("Open 'Workout calculator")
    @Description("Open")
    public WorkoutCalcSteps openWorkoutCalc() {
        iconMenuButton = new IconMenuButton(driver, MenuIconButtonConstants.INTENSITY_ICON_MENU_ID);
        Assert.assertTrue(
                iconMenuButton.isComponentDisplayed(),
                iconMenuButton.getClass().getSimpleName().concat(" is not displayed")
        );
        iconMenuButton.click();
        return new WorkoutCalcSteps(driver);
    }

    @Step("Open 'Other Calculator' popup")
    @Description("Check that it is possible to open 'Other Calculator' popup from Header")
    public OtherCalculatorStep openOtherCalculator() {
        iconMenuButton = new IconMenuButton(driver,MenuIconButtonConstants.OTHER_ICON_MENU_ID);
        Assert.assertTrue(
                iconMenuButton.isComponentDisplayed(),
                iconMenuButton.getClass().getSimpleName().concat(" is not displayed")
        );
        iconMenuButton.click();
        return new OtherCalculatorStep(driver);
    }
}
