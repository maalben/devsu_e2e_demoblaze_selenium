/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package com.devsu.demoblaze.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Wait implements Interaction {

	private final int timeWait;

	public Wait(int timeWait) {
		this.timeWait = timeWait;
	}

	public int getTimeWait() {
		return timeWait;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
        int length = getTimeWait() * 1000;
        try {
            Thread.sleep(length);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
	}

	public static Wait theNext(int time) {
		 return instrumented(Wait.class, time);
	}
}
