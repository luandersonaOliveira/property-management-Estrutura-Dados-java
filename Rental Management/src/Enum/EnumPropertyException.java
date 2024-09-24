package Enum;

public enum EnumPropertyException {
    // VALID
    PropertyAddedSuccessfully,
    PropertyRemovedSuccessfully,
    PropertyChangedSuccessfully,

    // INVALID
    PropertyInvalidIndex,
    PropertyInvalidAddress,
    PropertyInvalidRentalValue,
    PropertyInvalidType,
    PropertyInvalidOccupation,
    
    // NO REGISTERED
    PropertyInvalid,
    PropertyNotUpdated,
    PropertyNoRegistered,
    LandlordNotAddedToProperty,
    TenantNotAddedToProperty;
}
