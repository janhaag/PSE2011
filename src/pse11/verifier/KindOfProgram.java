package verifier;

/**
 * describes the sort of a program
 */
public enum KindOfProgram {
        /**
         * indicates a program to prove that assume=>rest
         */
        AssumeToRemaining,
        /**
         * indicates a program to prove that whileEnsure=>rest
         */
        WhileEnsureToRemaining,
        /**
         * indicates a program to prove that functionEnsure=>rest
         */
        FunctionEnsureToRemaining,
        /**
         * indicates a program to prove that invariant & condition => invariant
         */
        InvariantAndConditionToInvariant,
        /**
         * indicates a program to prove that invariant & !condition => ensure
         */
        InvariantAndNotConditionToEnsure
    }
