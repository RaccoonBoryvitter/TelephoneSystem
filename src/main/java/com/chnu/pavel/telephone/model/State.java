package com.chnu.pavel.telephone.model;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.Country
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 22.03.2021|02:11
 * @Version Country: 1.0
 */

public enum State {

    Belarus("+375"),
    Moldova("+373"),
    Poland("+48"),
    Romania("+40"),
    Russia("+7"),
    Ukraine("+380");
    // and so far and so on...

    private final String phoneCode;

    State(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getPhoneCode() {
        return this.phoneCode;
    }
}
