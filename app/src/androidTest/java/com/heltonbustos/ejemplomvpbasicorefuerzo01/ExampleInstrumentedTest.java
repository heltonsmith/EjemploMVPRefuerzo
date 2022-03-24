package com.heltonbustos.ejemplomvpbasicorefuerzo01;

import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;
import android.os.IBinder;
import android.view.WindowManager;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.Root;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import com.heltonbustos.ejemplomvpbasicorefuerzo01.vista.LoginViewImpl;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest extends TypeSafeMatcher<Root> {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.heltonbustos.ejemplomvpbasicorefuerzo01", appContext.getPackageName());
    }

    @Rule
    public ActivityScenarioRule<LoginViewImpl> actividad
            = new ActivityScenarioRule<LoginViewImpl>(LoginViewImpl.class);


    @Test
    public void probarTexto(){
        Espresso.onView(ViewMatchers.withId(R.id.txtUser))
                .perform(ViewActions.typeText("admin"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.txtPass))
                .perform(ViewActions.typeText("123"), ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.btnLogin))
                .perform(ViewActions.click());

        Espresso.onView(withText(R.string.toast_exito))
                .inRoot(new ExampleInstrumentedTest())
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Override
    protected boolean matchesSafely(Root item) {
        int type = item.getWindowLayoutParams().get().type;
        if ((type == WindowManager.LayoutParams.TYPE_TOAST)) {
            IBinder windowToken = item.getDecorView().getWindowToken();
            IBinder appToken = item.getDecorView().getApplicationWindowToken();
            if (windowToken == appToken) {
                //means this window isn't contained by any other windows.
                return true;
            }
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {

    }
}