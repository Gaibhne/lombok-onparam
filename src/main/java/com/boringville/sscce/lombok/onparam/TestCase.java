package com.boringville.sscce.lombok.onparam;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

import lombok.EqualsAndHashCode;
import lombok.Value;

/* This causes the error in question:
 *
 * "Illegal redefinition of parameter o, inherited method from Object does not constrain this parameter"
 *
 */
@EqualsAndHashCode(onParam_ = @Nullable)
@NonNullByDefault
public class TestCase {
	/*
	 * There should be a warning here saying:
	 *
	 * "The nullness annotation is redundant with a default that applies to this locatio"
	 *
	 * If this warning is missing then the ECJ settings did not apply correctly!
	 */
	private static void test(@NonNull Object poisonedPayload) {
		poisonedPayload.toString();
	}

	public static void triggerError(@Nullable Object heisenbergPoison) {
		/*
		 * There should be an error here saying:
		 *
		 * "Null type mismatch (type annotations): required '@NonNull Object' but this expression has type '@Nullable Object'"
		 *
		 * If this warning is missing then the ECJ settings did not apply correctly!
		 */
		TestCase.test(heisenbergPoison);
	}
}
