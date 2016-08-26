package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * List of some of the possible types that can be cast to the database types.
 */
@Entity
public class PossibleTypes {

    @Id
    @GeneratedValue
    private long id;

    private int someInt;
    private short someShort;
    private float someFloat;
    private double someDouble;
    private boolean someBoolean;

    private Integer someInteger;
    private BigDecimal someBigDecimal;
    private BigInteger someBitInteger;

    private int[] integerArr;
    private double[] doubleArray;

    private MyEnum myEnum;

    // @Transient annotation makes annotated variable ignored by the database.
    // There won't be a column of such a type.
    @Transient
    private int ignoredField;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public short getSomeShort() {
        return someShort;
    }

    public void setSomeShort(short someShort) {
        this.someShort = someShort;
    }

    public float getSomeFloat() {
        return someFloat;
    }

    public void setSomeFloat(float someFloat) {
        this.someFloat = someFloat;
    }

    public double getSomeDouble() {
        return someDouble;
    }

    public void setSomeDouble(double someDouble) {
        this.someDouble = someDouble;
    }

    public boolean isSomeBoolean() {
        return someBoolean;
    }

    public void setSomeBoolean(boolean someBoolean) {
        this.someBoolean = someBoolean;
    }

    public Integer getSomeInteger() {
        return someInteger;
    }

    public void setSomeInteger(Integer someInteger) {
        this.someInteger = someInteger;
    }

    public BigDecimal getSomeBigDecimal() {
        return someBigDecimal;
    }

    public void setSomeBigDecimal(BigDecimal someBigDecimal) {
        this.someBigDecimal = someBigDecimal;
    }

    public BigInteger getSomeBitInteger() {
        return someBitInteger;
    }

    public void setSomeBitInteger(BigInteger someBitInteger) {
        this.someBitInteger = someBitInteger;
    }

    public int[] getIntegerArr() {
        return integerArr;
    }

    public void setIntegerArr(int[] integerArr) {
        this.integerArr = integerArr;
    }

    public double[] getDoubleArray() {
        return doubleArray;
    }

    public void setDoubleArray(double[] doubleArray) {
        this.doubleArray = doubleArray;
    }

    public MyEnum getMyEnum() {
        return myEnum;
    }

    public void setMyEnum(MyEnum myEnum) {
        this.myEnum = myEnum;
    }

    public int getIgnoredField() {
        return ignoredField;
    }

    public void setIgnoredField(int ignoredField) {
        this.ignoredField = ignoredField;
    }

}
