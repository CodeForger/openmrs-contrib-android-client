/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.mobile.api;

import org.openmrs.mobile.models.Location;
import org.openmrs.mobile.models.retrofit.Encounter;
import org.openmrs.mobile.models.retrofit.EncounterType;
import org.openmrs.mobile.models.retrofit.Encountercreate;
import org.openmrs.mobile.models.retrofit.FormResource;
import org.openmrs.mobile.models.retrofit.IdGenPatientIdentifiers;
import org.openmrs.mobile.models.retrofit.IdentifierType;
import org.openmrs.mobile.models.retrofit.Obscreate;
import org.openmrs.mobile.models.retrofit.Observation;
import org.openmrs.mobile.models.retrofit.Patient;
import org.openmrs.mobile.models.retrofit.Results;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {


    @GET("form?v=custom:(uuid,name,resources)")
    Call<Results<FormResource>> getForms();

    @GET("location")
    Call<Results<Location>> getLocations();

    @GET("patientidentifiertype")
    Call<Results<IdentifierType>> getIdentifierTypes();

    @GET("module/idgen/generateIdentifier.form?source=1")
    Call<IdGenPatientIdentifiers> getPatientIdentifiers(@Query("username") String username,
                                                        @Query("password") String password);

    @GET("patient?v=full")
    Call<Results<Patient>> getPatients(@Query("q") String query);

    @GET("patient?lastviewed&v=full")
    Call<Results<Patient>> getLastViewedPatients();

    @POST("patient")
    Call<Patient> createPatient(
            @Body Patient patient);

    @GET("patient")
    Call<Results<Patient>> getPatients(@Query("q") String searchQuery,
                                       @Query("v") String representation);

    @POST("obs")
    Call<Observation> createObs(@Body Obscreate obscreate);

    @POST("encounter")
    Call<Encounter> createEncounter(@Body Encountercreate encountercreate);

    @GET("encountertype")
    Call<Results<EncounterType>> getEncounterTypes();

}
