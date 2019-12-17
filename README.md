# lombok-onparam

Demonstrates a problem with the onParam_ option of @EqualsAndHashCode in conjunction with ECJs null checkers.

The project contains one test case, one as the Lombok version and one as the Delomboke'd version.

The test case contains two methods that are INCORRECTLY tagged with @Null-annotations. If "mvn clean compile" finishes without errors, then something went wrong with the null checking, as the code should generate an error.

The test case also contains the class itself, tagged with @EqualsAndHashCode and respectively the generated methods. This code throws an error, but shouldn't - logically, adding the onParams_ flag to the annotation should result in the method being compatible to the inherited Object.* signatures, but the error indicates that this doesn't happen. Delombok correctly places the provided annotation as expected, so it seems that there is a disconnect between Lombok and Delombok. Additionally, Delombok creates code with a minor syntax error (the annotation placement is wrong).
