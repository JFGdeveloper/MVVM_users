package com.javidev.mvvm_user_yayo.dataLayer.model


// SE PUEDE LLAMAR USERRESPONSE POR EJEM LO QUE SE TRATA ES QUE SEA IGUAL QUE EL JSON
// ESTO LUEGO LO INYECTO Y LO MANEJO EN EL REPOSITORIO
data class ApiResponse(val result: List<Results> = emptyList())

data class Results(
    val name: UserName?,
    val location: UserLocation?,
    val picture: UserPicture?
)