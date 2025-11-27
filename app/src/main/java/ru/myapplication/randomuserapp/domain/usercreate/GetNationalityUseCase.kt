package ru.myapplication.randomuserapp.domain.usercreate

import javax.inject.Inject

internal class GetNationalityUseCase @Inject constructor() {

    operator fun invoke(): List<NationalityDomain> = listOf(
        NationalityDomain.AU,
        NationalityDomain.BR,
        NationalityDomain.CA,
        NationalityDomain.CH,
        NationalityDomain.DE,
        NationalityDomain.DK,
        NationalityDomain.ES,
        NationalityDomain.FI,
        NationalityDomain.FR,
        NationalityDomain.GB,
        NationalityDomain.IE,
        NationalityDomain.IN,
        NationalityDomain.IR,
        NationalityDomain.MX,
        NationalityDomain.NL,
        NationalityDomain.NO,
        NationalityDomain.NZ,
        NationalityDomain.RS,
        NationalityDomain.TR,
        NationalityDomain.UA,
        NationalityDomain.US,
    )
}