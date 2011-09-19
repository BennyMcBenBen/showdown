package showdown.model;

/**
 * Credit card type.
 * @author Ben
 */
public enum CreditCardType {
        VISA("VISA"), MASTERCARD("Mastercard"), DISCOVER("Discover");

        private final String value;

        /**
         * Constructs a credit card type.
         * @param value value
         */
        private CreditCardType(String value) {
            this.value = value;
        }

        /**
         * Gets a string representation of this credit card type.
         * @return type string
         */
        @Override
        public String toString() {
            return value;
        }
}