package verifier;

/**
 * describes the sort of a program
 */
public enum KindOfProgram {
        /**
         * indicates a program to prove that assume=>rest
         */
        FunctionAssumeToRemainingProgram,
        /**
         * indicates a program to prove that whileEnsure=>rest
         */
        WhileEnsureToRemainingProgram,
        /**
         * indicates a program to prove that functionEnsure=>rest
         */
        FunctionEnsureToRemainingProgram,
        /**
         * indicates a program to prove that invariant & condition => invariant
         */
        InvariantAndConditionToInvariant,
        /**
         * indicates a program to prove that invariant & !condition => ensure
         */
        InvariantAndNotConditionToWhileEnsure
    }
