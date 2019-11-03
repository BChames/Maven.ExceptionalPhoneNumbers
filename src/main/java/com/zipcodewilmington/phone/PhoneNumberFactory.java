package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        //Using the createRandomPhoneNumber from Part 3, generate an array of PhoneNumber objects,
        // whose length reflects the input argument.
        //For example createRandomPhoneNumber(5) should return an array of 5 PhoneNumber objects.

        //phoneNumberCount; -length
        //each count should generate a random number and put it in an array
        PhoneNumber[] randomPhoneNumberArray = new PhoneNumber[phoneNumberCount];
        int count = 0;
        PhoneNumber j;

        for(int i = 0; i < phoneNumberCount; i++){
            j = PhoneNumberFactory.createRandomPhoneNumber();
            randomPhoneNumberArray[count] = j;

        }
        return randomPhoneNumberArray;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {

       int randomAreaCode = RandomNumberFactory.createInteger(100, 999);
       int randomCentralOfficeCode = RandomNumberFactory.createInteger(100, 999);
       int randomPhoneLineCode = RandomNumberFactory.createInteger(1000, 9999);

        return createPhoneNumberSafely(randomAreaCode, randomCentralOfficeCode, randomPhoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        /*
        Add logging to the createPhoneNumberSafely method from Part 2, which logs the message

(###)-###-#### is not a valid phone number
Where (###)-###-#### will be replaced with the respective input parameter.
         */

        int phoneNumberInt = areaCode + centralOfficeCode + phoneLineCode;
        String phoneNumberString = Integer.toString(phoneNumberInt);

        try {
            return createPhoneNumber(phoneNumberString);
        } catch (InvalidPhoneNumberFormatException e) {
            logger.info(phoneNumberString + "is not a valid phone number");
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException{
        logger.info("Attempting to create a new PhoneNumber object with a value of" + phoneNumberString);
        return new PhoneNumber(phoneNumberString);
    }
}
