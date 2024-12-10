package org.example.models.API;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationsData {
    private Integer applicantid;
    private Integer applicationid;
    private Integer citizenid;
    private String dateofapplication;
    private String kindofapplication;
    private String statusofapplication;
    private Integer staffid;
    private String channel;
    private Object image;
}






