package com.javidev.mvvm_user_yayo.dataLayer.model


// SE PUEDE LLAMAR USERRESPONSE POR EJEM LO QUE SE TRATA ES QUE SEA IGUAL QUE EL JSON
// ESTO LUEGO LO INYECTO Y LO MANEJO EN EL REPOSITORIO
// importante las variables tienes que llevar el mismo nombre que en la api
data class ApiResponse(
    val results: List<Results> = emptyList()
)


data class Results(
    val name: UserName?,
    val location: UserLocation?,
    val picture: UserPicture?
)