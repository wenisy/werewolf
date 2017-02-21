package com.werewolf.model;

public enum Roles {
    WEREWOLF(1, "WEREWOLF"), FORTUNETELLER(2, "FORTUNETELLER"), HUNTER(3, "HUNTER"), WITCH(4, "WITCH"),
    VILLAGER(5, "VILLAGER"), IDIOT(6, "IDIOT"), CUPID(7, "CUPID"), WHITEWOLF(8, "WHITEWOLF"), SAVIOR(9, "SAVIOR");
    private int roleNumber;
    private String roleName;

    Roles(int roleNumber) {
        this.roleNumber = roleNumber;
    }

    Roles(int roleNumber, String roleName) {
        this.roleNumber = roleNumber;
        this.roleName = roleName;
    }

    public int getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(int roleNumber) {
        this.roleNumber = roleNumber;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
