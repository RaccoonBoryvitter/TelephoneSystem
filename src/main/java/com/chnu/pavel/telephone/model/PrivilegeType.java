package com.chnu.pavel.telephone.model;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.PrivilegeType
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 15.03.2021|02:56
 * @Version PrivilegeType: 1.0
 */

public enum PrivilegeType {

    None(1.0),
    Pensioner(0.6),
    Invalid(0.5),
    Combatant(0.7),
    Chernobyl(0.65);

    final double costMultiplier;

    PrivilegeType(double costMultiplier) {
        this.costMultiplier = costMultiplier;
    }

}
