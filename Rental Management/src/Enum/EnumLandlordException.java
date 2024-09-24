package Enum;

public enum EnumLandlordException {
    // VALID
    LandlordAddedSuccessfully,
    LandlordRemovedSuccessfully,
    LandlordChangedSuccessfully,

    // INVALID
    LandlordInvalidIndex,
    LandlordInvalidName,
    LandlordInvalidCPF,
    LandlordInvalidTelephone,
    LandlordInvalidEmail,

    // NO REGISTERED
    LandlordInvalid,
    LandlordNotUpdated,
    LandlordNoRegistered,
    PropertyNotAddedToLandlord;
}
