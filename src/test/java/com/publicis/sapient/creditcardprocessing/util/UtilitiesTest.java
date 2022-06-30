package com.publicis.sapient.creditcardprocessing.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.publicis.sapient.creditcardprocessing.util.Utilities.validateUsingLuhn;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilitiesTest {

    @Test
    void validateCardCheck() {
       assertTrue(validateUsingLuhn().test(4648354228028685L));
    }

    @Test
    void invalidateCardCheck() {
        assertFalse(validateUsingLuhn().test(1234567898028685L));
    }
}