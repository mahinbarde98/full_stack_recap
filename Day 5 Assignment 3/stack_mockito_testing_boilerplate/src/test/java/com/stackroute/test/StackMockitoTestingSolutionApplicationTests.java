package com.stackroute.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Please note, not to change any test cases here in this class
 * You are required to create at least 8 test cases specified in the BlogControllerTest.java
 * You are required to create at least 4 test cases specified in the BlogRepositoryIntegrationTest.java
 * Please note that this test case will fail if you have not created the required test classes
 */
@SpringBootTest
class StackMockitoTestingSolutionApplicationTests {

	private static final String TEST_PACKAGE = "com.stackroute.test.controller";
	private static final String TEST_PACKAGE1 = "com.stackroute.test.repository";
	private static final String MSG_01 = "As per the requirement, the following test class should be created :";
	private static final String MSG_02 = " for testing class ";
	private static final String MSG_03 = "As per the requirement, there should be at least ";
	private static final String MSG_04 = " test cases in ";

	@Test
	public void givenControllerTestsClassNameThenCheckClassExists() {
		String packageName = TEST_PACKAGE;
		String testClassName = "BlogControllerTest";
		String classToBeTested = "BlogController";
		final Class<?> actualTestClass = checkTestClassExists(packageName, testClassName);
		assertNotNull(actualTestClass, MSG_01 + " " + packageName + "." + testClassName + MSG_02 + classToBeTested);
	}

	@Test
	public void givenControllerTestsClassNameThenCheckClassContainsRequiredTestMethods() {
		String packageName = TEST_PACKAGE;
		String testClassName = "BlogControllerTest";
		String classToBeTested = "BlogController";
		int requiredTestCaseCount = 8;
		final Class<?> actualTestClass = checkTestClassExists(packageName, testClassName);
		assertNotNull(actualTestClass, MSG_01 + " " + packageName + "." + testClassName + MSG_02 + classToBeTested);
		final long testMethodsCount = checkTestClassContainsRequiredTestMethods(actualTestClass);
		assertTrue(testMethodsCount >= requiredTestCaseCount, MSG_03 + requiredTestCaseCount + MSG_04
				+ testClassName);
	}

	@Test
	public void givenRepositoryTestsClassNameThenCheckClassExists() {
		String packageName = TEST_PACKAGE1;
		String testClassName = "BlogRepositoryIntegrationTest";
		String classToBeTested = "BlogRepository";
		final Class<?> actualTestClass = checkTestClassExists(packageName, testClassName);
		assertNotNull(actualTestClass, MSG_01 + " " + packageName + "." + testClassName + MSG_02 + classToBeTested);
	}
	@Test
	public void givenRepositoryTestsClassNameThenCheckClassContainsRequiredTestMethods() {
		String packageName = TEST_PACKAGE1;
		String testClassName = "BlogRepositoryIntegrationTest";
		String classToBeTested = "BlogRepository";
		int requiredTestCaseCount = 4;
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
