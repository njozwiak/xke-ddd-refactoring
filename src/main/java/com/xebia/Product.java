package com.xebia;

import java.util.Date;
import java.util.List;

public class Product {

    private Long id;

    private String name;

    private String referenceCode;

    private String technicalCode;

    private Date marketDate;

    private Date placeDate;

    private List<EcheanceRequest> echeanceRequests;

    private List<DeviseConversion> deviseConversions;



}
