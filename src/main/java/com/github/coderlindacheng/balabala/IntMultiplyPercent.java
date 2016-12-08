package com.github.coderlindacheng.balabala;

import com.google.common.math.IntMath;

import com.github.coderlindacheng.balabala.common.AbstractCommon;

/**
 * Created by lindacheng on 16/7/14.
 */
public class IntMultiplyPercent extends AbstractCommon {

    public final int molecule;
    public final int denominator;

    private IntMultiplyPercent(Object caller, int molecule, int denominator) {
        this.molecule = molecule;
        ValidityChecker.checkNotLessThan0WithCallerInfo(
                readerbaleCaller(caller), molecule,
                errMsg("molecule must greater than 0"));
        this.denominator = denominator;
        ValidityChecker.checkGreaterThan0WithCallerInfo(
                readerbaleCaller(caller), denominator,
                errMsg("denominator must greater than 0"));
    }

    private IntMultiplyPercent(int molecule, int denominator) {
        this.molecule = molecule;
        this.denominator = denominator;
    }

    public static IntMultiplyPercent checkedGenerate(int molecule,
                                                     int denominator) {
        return checkedGenerate(null, molecule, denominator);
    }

    public static IntMultiplyPercent checkedGenerate(Object caller,
                                                     int molecule, int denominator) {
        return new IntMultiplyPercent(caller, molecule, denominator);
    }

    public static IntMultiplyPercent uncheckedGenerate(int molecule,
                                                       int denominator) {
        return new IntMultiplyPercent(molecule, denominator);
    }

    public int checkedMultiply(int arg) {
        return IntMath.checkedMultiply(arg, this.molecule) / this.denominator;
    }

    public int uncheckedMultiply(int arg) {
        return arg * this.molecule / this.denominator;
    }

    public IntMultiplyPercent checkedAdd(IntMultiplyPercent toAdd) {
        return checkedAdd(null, toAdd);
    }

    public IntMultiplyPercent checkedAdd(Object caller, IntMultiplyPercent toAdd) {
        ValidityChecker
                .checkEqualsWithCallerInfo(
                        readerbaleCaller(caller),
                        toAdd.denominator,
                        this.denominator,
                        errMsg("plus the arg's denominator is not same as the origin's"));

        return new IntMultiplyPercent(caller, IntMath.checkedAdd(this.molecule,
                toAdd.molecule), this.denominator);
    }

    public IntMultiplyPercent uncheckedAdd(IntMultiplyPercent toAdd) {
        return new IntMultiplyPercent(this.molecule + toAdd.molecule, this.denominator);
    }

    public float toFloat() {
        return (float) this.molecule / this.denominator;
    }

    @Override
    public String toString() {
        return "com.github.coderlindacheng.balabala.IntMultiplyPercent";
    }
}
