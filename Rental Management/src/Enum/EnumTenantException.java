package Enum;

public enum EnumTenantException {
    // VALID
    TenantAddedSuccessfully,
    TenantRemovedSuccessfully,
    TenantChangedSuccessfully,

    // INVALID
    TenantInvalidIndex,
    TenantInvalidBalance,
    TenantInvalidName,
    TenantInvalidCPF,
    TenantInvalidTelephone,
    TenantInvalidEmail,

    // NO REGISTERED
    TenantInvalid,
    TenantNotUpdated,
    TenantNoRegistered,
    PropertyNotAddedToTenant;
}
