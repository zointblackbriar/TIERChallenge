package org.tierapp.sampleapp.service;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.tierchallenge.sampleapp.dto.URLDto;

///*
// * Copyright 2022-2023 Orcun Oruc
// *
// * You should have received a copy of a license with this program. 
// *
// * You may not use, copy, modify, sublicense, or distribute the Program or any
// * portion of it, except as expressly provided under the given license.
// */



///**
// * TODO The @Validated annotation on the interface indicates that the implementing class 
// should perform validation on the method arguments according to the specified constraints.
// *
// * @author Orcun oruc
// */
@Validated
public interface URLShortenerService {

    //~ Methods ------------------------------------------------------------------------------------------------------------------
	public String getUrlByKey(@NotBlank String key);
	public URLDto shortenUrl(@NotBlank String url);
	
}
