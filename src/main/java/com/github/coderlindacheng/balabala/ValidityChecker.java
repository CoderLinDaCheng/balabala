package com.github.coderlindacheng.balabala;

import com.google.common.base.Preconditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by lindacheng on 16/7/14.
 */
public final class ValidityChecker {

    private static final Logger logger = LoggerFactory
            .getLogger(ValidityChecker.class);

    public static int checkGreaterThan0WithCallerInfo(Object caller, int num,
                                                      Object errorMessageTemplate, Object... errorMessageArgs) {

        return checkGreaterThanANumWithCallerInfo(caller, num, 0, errorMessageTemplate, errorMessageArgs);
    }

    public static int checkGreaterThanANumWithCallerInfo(Object caller,
                                                         int num, int greaterThan, Object errorMessageTemplate,
                                                         Object... errorMessageArgs) {

        return checkGreaterThanANum(num, greaterThan,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static int checkGreaterThanANum(int num, int greaterThan,
                                           Object errorMessageTemplate, Object... errorMessageArgs) {
        try {
            Preconditions.checkArgument(num > greaterThan,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
            return num;
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    private static String joinParentToErrorMessageTemplate(Object parent,
                                                           Object errorMessageTemplate) {
        try {
            return StrBuilderUtil.toString("[", parent, "]", " ",
                    errorMessageTemplate);
        } catch (Exception e) {
            logger.error(String.valueOf(parent), e);
            throw e;
        }
    }

    public static int checkGreaterThan0(int num, Object errorMessageTemplate,
                                        Object... errorMessageArgs) {
        return checkGreaterThanANum(num, 0, errorMessageTemplate, errorMessageArgs);
    }

    public static int checkNotGreaterThan0WithCallerInfo(Object caller,
                                                         int num, Object errorMessageTemplate, Object... errorMessageArgs) {
        return checkNotGreaterThanANumWithCallerInfo(caller, num, 0, errorMessageTemplate, errorMessageArgs);
    }

    public static int checkNotGreaterThanANumWithCallerInfo(Object caller,
                                                            int num, int notGreaterThan, Object errorMessageTemplate,
                                                            Object... errorMessageArgs) {
        return checkNotGreaterThanANum(num, notGreaterThan,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static int checkNotGreaterThanANum(int num, int notGreaterThan,
                                              Object errorMessageTemplate, Object... errorMessageArgs) {
        try {
            Preconditions.checkArgument(num <= notGreaterThan,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
            return num;
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    public static int checkNotGreaterThan0(int num,
                                           Object errorMessageTemplate, Object... errorMessageArgs) {
        return checkNotGreaterThanANum(num, 0, errorMessageTemplate, errorMessageArgs);
    }

    public static int checkNotLessThan0WithCallerInfo(Object caller, int num,
                                                      Object errorMessageTemplate, Object... errorMessageArgs) {
        return checkNotLessThanANumWithCallerInfo(caller, num, 0, errorMessageTemplate, errorMessageArgs);
    }

    public static int checkNotLessThanANumWithCallerInfo(Object caller,
                                                         int num, int notLessThan, Object errorMessageTemplate,
                                                         Object... errorMessageArgs) {
        return checkNotLessThanANum(num, notLessThan,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static int checkNotLessThanANum(int num, int notLessThan,
                                           Object errorMessageTemplate, Object... errorMessageArgs) {
        try {
            Preconditions.checkArgument(num >= notLessThan,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
            return num;
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    public static int checkNotLessThan0(int num, Object errorMessageTemplate,
                                        Object... errorMessageArgs) {
        return checkNotLessThanANum(num, 0, errorMessageTemplate, errorMessageArgs);
    }

    public static int checkLessThan0WithCallerInfo(Object caller, int num,
                                                   Object errorMessageTemplate,
                                                   Object... errorMessageArgs) {
        return checkLessThanANumWithCallerInfo(caller, num, 0, errorMessageTemplate, errorMessageArgs);
    }

    public static int checkLessThanANumWithCallerInfo(Object caller, int num,
                                                      int lessThan, Object errorMessageTemplate,
                                                      Object... errorMessageArgs) {
        return checkLessThanANum(num, lessThan,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static int checkLessThanANum(int num, int lessThan,
                                        Object errorMessageTemplate, Object... errorMessageArgs) {
        try {
            Preconditions.checkArgument(num < lessThan,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
            return num;
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    public static int checkLessThan0(int num,
                                     Object errorMessageTemplate, Object... errorMessageArgs) {
        return checkLessThanANum(num, 0, errorMessageTemplate, errorMessageArgs);
    }

    public static <T> T checkEqualsWithCallerInfo(Object caller, T actual,
                                                  T expected, Object errorMessageTemplate, Object... errorMessageArgs) {
        return checkEquals(actual, expected,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static <T> T checkEquals(T actual, T expected,
                                    Object errorMessageTemplate, Object... errorMessageArgs) {
        try {
            Preconditions.checkArgument(actual == expected,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
            return actual;
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    public static <T> T checkNotNullWithCallerInfo(Object caller, T obj,
                                                   Object errorMessageTemplate, Object... errorMessageArgs) {
        return checkNotNull(obj,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static <T> T checkNotNull(T obj, Object errorMessageTemplate,
                                     Object... errorMessageArgs) {
        try {
            return Preconditions.checkNotNull(obj,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    public static <T> void checkEmptyWithCallerInfo(Object caller, T[] array,
                                                    Object errorMessageTemplate, Object... errorMessageArgs) {
        checkEmpty(array,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static <T> void checkEmpty(T[] array, Object errorMessageTemplate,
                                      Object... errorMessageArgs) {
        try {
            Preconditions.checkArgument(array == null || array.length <= 0,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    public static <T> void checkEmptyWithCallerInfo(Object caller,
                                                    List<T> list, Object errorMessageTemplate,
                                                    Object... errorMessageArgs) {
        checkEmpty(list,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static <T> void checkEmpty(List<T> list,
                                      Object errorMessageTemplate, Object... errorMessageArgs) {
        try {
            Preconditions.checkArgument(list == null || list.isEmpty(),
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    public static <T> void checkNotEmptyWithCallerInfo(Object caller,
                                                       T[] array, Object errorMessageTemplate, Object... errorMessageArgs) {
        checkNotEmpty(array,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static <T> void checkNotEmpty(T[] array,
                                         Object errorMessageTemplate, Object... errorMessageArgs) {
        try {
            final T[] checkNotNull = Preconditions.checkNotNull(array,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
            Preconditions.checkArgument(checkNotNull.length > 0,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    public static <T> void checkNotEmptyWithCallerInfo(Object caller,
                                                       List<T> list, Object errorMessageTemplate,
                                                       Object... errorMessageArgs) {
        checkNotEmpty(list,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static <T> void checkNotEmpty(List<T> list,
                                         Object errorMessageTemplate, Object... errorMessageArgs) {
        try {
            final List<T> checkNotNull = Preconditions.checkNotNull(list,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
            Preconditions.checkArgument(!checkNotNull.isEmpty(),
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    public static void checkTrueWithCallerInfo(Object caller, boolean isTrue,
                                               Object errorMessageTemplate, Object... errorMessageArgs) {
        checkTrue(isTrue,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static void checkTrue(boolean isTrue, Object errorMessageTemplate,
                                 Object... errorMessageArgs) {
        try {
            Preconditions.checkArgument(isTrue,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }

    public static void checkFalseWithCallerInfo(Object caller, boolean isFalse,
                                                Object errorMessageTemplate, Object... errorMessageArgs) {
        checkFalse(isFalse,
                joinParentToErrorMessageTemplate(caller, errorMessageTemplate),
                errorMessageArgs);
    }

    public static void checkFalse(boolean isFalse, Object errorMessageTemplate,
                                  Object... errorMessageArgs) {
        try {
            Preconditions.checkArgument(!isFalse,
                    String.valueOf(errorMessageTemplate), errorMessageArgs);
        } catch (Exception e) {
            logger.error(e.toString(), e);
            throw e;
        }
    }
}
