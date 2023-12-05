package com.stackroute.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
* Please note not to change any test cases here in this class
* You are required to create at least 10 test cases specified in the BlogServiceTest.java
* Please note that this test case will fail if you have not created the required test classes
 */
@SpringBootTest
class StackTestingExceptionApplicationTests {

	private static final String TEST_PACKAGE = "com.stackroute.test.service";
	private static final String MSG_01 = "As per the requirement, the following test class should be created :";
	private static final String MSG_02 = " for testing class ";
	private static final String MSG_03 = "As per the requirement, there should be at least ";
	private static final String MSG_04 = " test cases in ";

	@Test
	public void givenServiceTestsClassNameThenCheckClassExists() {
		String packageName = TEST_PACKAGE;
		String testClassName = "BlogServiceTest";
		String classToBeTested = "BlogService";
		final Class<?> actualTestClass = checkTestClassExists(packageName, testClassName);
		assertNotNull(actualTestClass, MSG_01 + " " + packageName + "." + testClassName + MSG_02 + classToBeTested);
	}

	@Test
	public void givenServiceTestsClassNameThenCheckClassContainsRequiredTestMethods() {
		String packageName = TEST_PACKAGE;
		String testClassName = "BlogServiceTest";
		String classToBeTested = "BlogService";
		int requiredTestCaseCount = 10;
		final Class<?> actualTestClass = checkTestClassExists(packageName, testClassName);
		assertNotNull(actualTestClass, MSG_01 + " " + packageName + "." + testClassName + MSG_02 + classToBeTested);
		final long testMethodsCount = checkTestClassContainsRequiredTestMethods(actualTestClass);
		assertTrue(testMethodsCount >= requiredTestCaseCount, MSG_03 + requiredTestCaseCount + MSG_04
				+ testClassName);
	}

	private Class<?> checkTestClassExists(String packageName, String className) {
		String qualifiedClassName = packageName + "." + className;
		Class<?> testClass;
		try {
			testClass = Class.forName(qualifiedClassName);
		} catch (ClassNotFoundException e) {
			testClass = null;
		}
		return testClass;
	}

	private long checkTestClassContainsRequiredTestMethods(Class<?> testClass) {
		Method[] methods = testClass.getDeclaredMethods();
		return Arrays.stream(methods).filter(method -> method.isAnnotationPresent(Test.class)).count();
	}

}
