package ru.myapplication.randomuserapp.domain.usercreate

import javax.inject.Inject

internal class GetGendersUseCase @Inject constructor() {

    operator fun invoke(): List<GenderDomain> = listOf(
        GenderDomain.FEMALE,
        GenderDomain.MALE,
    )
}